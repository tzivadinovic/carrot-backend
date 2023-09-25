package com.carrot.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.carrot.data.ResponseError;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends GenericFilterBean {
    private final JwtProvider jwtProvider;

//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException {
//        try {
//			Authentication auth = getAuthenticationManager().authenticate(jwtProvider.getAuthentication(req));
//			SecurityContextHolder.getContext().setAuthentication(auth);
//        } catch (AuthenticationException ignored) {}
//        filterChain.doFilter(req, res);
//    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        // We don't want token verification to interrupt the login request
        if (((HttpServletRequest) req).getServletPath().equals("/login") &&
                ((HttpServletRequest) req).getMethod().equals("POST")) {
            filterChain.doFilter(req, res);
            return;
        }

        String token = jwtProvider.resolveToken((HttpServletRequest) req);
        String refreshToken = jwtProvider.resolveRefreshToken((HttpServletRequest) req);

        // During authorization, we need to check for both refresh and regular
        // token validity since we need to allow refreshToken to be used to
        // generate a new authentication token without requiring the user to
        // login again using username and password.
        if (token != null || refreshToken != null) {
            if (token != null && jwtProvider.validateToken(token)) {
                // if the authentication token is valid we proceed as normal
                Authentication auth = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            } else if (refreshToken != null && jwtProvider.validateToken(refreshToken)) {
                // this branch will execute if the authentication token is not
                // valid. If that is the case we set the authentication using
                // the refreshToken which does not contain any roles. That should
                // signal the frontend application to make a request to refresh
                // user's credentials using the AuthController#refreshToken
                // endpoint.
                Authentication auth = jwtProvider.getRefreshAuthentication(refreshToken);
                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                // if neither of the tokens are valid we do not proceed
                writeErrorToResponse((HttpServletRequest) req,
                        (HttpServletResponse) res,
                        TokenExpiredException.class);
                // possibly we do not need to break the filter chain. We can just
                // set the Authentication to null in the SecurityContextHolder
                // and let spring security do the rest (Because we might have
                // some endpoints that do not require authentication).
                return;
            }
        }
        filterChain.doFilter(req, res);
    }

    private void writeErrorToResponse(HttpServletRequest request, HttpServletResponse response, Class<? extends RuntimeException> exception) throws IOException {
        String reason;
        HttpStatus code;
        if (exception.isAnnotationPresent(ResponseStatus.class)) {
            ResponseStatus status = TokenExpiredException.class.getAnnotation(ResponseStatus.class);
            reason = status.reason();
            code = status.code();
        } else {
            // default values
            reason = "Your session has expired";
            code = HttpStatus.UNAUTHORIZED;
        }
        ResponseError error = new ResponseError(code, request, reason);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }
}