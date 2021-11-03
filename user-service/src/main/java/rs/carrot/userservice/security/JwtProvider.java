package rs.carrot.userservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    @Value("${jwt.secret:secret}")
    private String secret;
    private final long VALIDITY = 7200000;

    public String createToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + VALIDITY);
        return JWT.create()
                .withSubject(username)
                .withArrayClaim("roles", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).toArray(new String[]{}))
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC512(secret));
    }

    public DecodedJWT decode(String token) {
        if (token == null)
            throw new BadCredentialsException("No token provided");

        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token);
        } catch (TokenExpiredException ex) {
            throw new CredentialsExpiredException(ex.getMessage());
        } catch (SignatureVerificationException ex) {
            throw new BadCredentialsException(ex.getMessage());
        }
    }

    private List<GrantedAuthority> getAuthorities(DecodedJWT decoded) {
        List<String> roles = decoded.getClaim("roles").asList(String.class);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    private String getUsername(DecodedJWT decoded) {
        return decoded.getSubject();
    }

    public Authentication getAuthentication(String token) {
        DecodedJWT decoded = decode(token);
        if (token == null)
            return null;
        return new UsernamePasswordAuthenticationToken(getUsername(decoded), null, getAuthorities(decoded));
    }

    public Authentication getAuthentication(HttpServletRequest req) {
        return getAuthentication(resolveToken(req));
    }

    private String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken == null || !bearerToken.startsWith("Bearer "))
            return null;

        return bearerToken.substring("Bearer ".length());
    }
}