package com.carrot.security;

import com.carrot.data.ResponseValue;
import com.carrot.data.TokenResponse;
import com.carrot.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.carrot.util.ObjectMapperUtils.readValue;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;
	private final JwtProviderImpl jwtProvider;
	private final Properties errorMessages;


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		User user = readValue(request, User.class);
		if (user == null)
			throw new UsernameNotFoundException(errorMessages.getProperty("auth.invalidCredentials"));
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String username = authResult.getName();
		String token = jwtProvider.createToken(authResult.getName(), authResult.getAuthorities());
		String refreshToken = jwtProvider.createRefreshToken(username);
		response.setContentType(MediaType.APPLICATION_JSON.toString());
		TokenResponse tokenResponse = TokenResponse.builder().token(token).refreshToken(refreshToken).build();
		response.setHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + tokenResponse.getToken());
		response.setHeader(SecurityConstants.REFRESH_TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + tokenResponse.getRefreshToken());
		new ObjectMapper().writeValue(response.getWriter(), tokenResponse);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON.toString());
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		new ObjectMapper().writeValue(response.getWriter(), ResponseValue.of(failed.getMessage()));
	}

}