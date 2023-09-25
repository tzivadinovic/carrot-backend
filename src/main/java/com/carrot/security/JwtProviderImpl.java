package com.carrot.security;

import com.carrot.entity.User;
import com.carrot.service.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProviderImpl implements JwtProvider {
    private final UserService userService;
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expire-length:18000}")
    private long validityInSeconds;
    @Value("${jwt.refresh-expire-length:18000}")
    private long refreshValidityInSeconds = 18000;

    public JwtProviderImpl(UserService userService) {
        this.userService = userService;
    }

    public String createToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInSeconds * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String createRefreshToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + refreshValidityInSeconds * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        User user = this.userService.findByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    public Authentication getRefreshAuthentication(String token) {
        User user = this.userService.findByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        return resolveToken(req, SecurityConstants.TOKEN_HEADER);
    }

    public String resolveRefreshToken(HttpServletRequest req) {
        return resolveToken(req, SecurityConstants.REFRESH_TOKEN_HEADER);
    }

    private String resolveToken(HttpServletRequest req, String header) {
        String bearerToken = req.getHeader(header);

        if (bearerToken == null || !bearerToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            return null;
        }

        return bearerToken.substring(SecurityConstants.TOKEN_PREFIX.length());
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
