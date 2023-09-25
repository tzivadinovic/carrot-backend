package com.carrot.security;

import java.util.*;

import com.carrot.bean.converter.ProfileManager;
import com.carrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtProviderImpl jwtProvider;
    private final UserDetailsService userDetailsService;
    private final ProfileManager profileManager;
    private final UserRepository userRepository;
    private final Environment env;

    @Resource(name = "errorMessages")
    private Properties errorMessages;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (profileManager.isProfileActive("dev")) {
            http.httpBasic().disable()
                    .cors().and()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                    .antMatchers("/**").permitAll().and()
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtProvider, errorMessages))
                    .addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
        } else if (profileManager.isProfileActive("staging") || profileManager.isProfileActive("qa")) {
            http.httpBasic().disable()
                    .cors().and()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                    .authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-resources/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .and()
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtProvider, errorMessages))
                    .addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
        } else {
            http.httpBasic().disable()
                    .cors().and()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .and()
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtProvider, errorMessages))
                    .addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
        }
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() {
        return new AuthenticationManagerImpl(passwordEncoder(), userRepository, env);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        if (profileManager.isProfileActive("dev")) {
            configuration.setAllowedOrigins(List.of("http://127.0.0.1:3000",
                    "http://localhost:3000",
                    "http://localhost:4200", "http://localhost:8080"));
        } else if (profileManager.isProfileActive("staging") || profileManager.isProfileActive("qa")) {
            configuration.setAllowedOrigins(Collections.singletonList("localhost"));
        } else if (profileManager.isProfileActive("prod")) {
            configuration.setAllowedOrigins(List.of());
        }
        configuration.setAllowedMethods(Arrays.asList(
                "GET",
                "POST",
                "PUT",
                "PATCH",
                "DELETE",
                "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList(
                "Access-Control-Allow-Origin",
                "Authorization",
                "X-Refresh-Token",
                "content-type",
                "x-xsrf-token",
                "XSRF-TOKEN"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}