package rs.carrot.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
import rs.carrot.backend.bean.converter.ProfileManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;
    private final ProfileManager profileManager;

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
                    .anyRequest().authenticated().and()
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtProvider))
                    .addFilterBefore(new JwtAuthorizationFilter(authorizationManager(), jwtProvider), UsernamePasswordAuthenticationFilter.class);
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
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtProvider))
                    .addFilterBefore(new JwtAuthorizationFilter(authorizationManager(), jwtProvider), UsernamePasswordAuthenticationFilter.class);
        }

    }

    @Bean
    @Qualifier("authenticationManager")
    @Override
    public AuthenticationManager authenticationManager() {
        return authentication -> {
            String username = authentication.getName().toLowerCase(Locale.ROOT).trim();
            String password = authentication.getCredentials().toString();
            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (!passwordEncoder().matches(password, user.getPassword()))
                throw new BadCredentialsException("auth.invalidCredentials");

            if (!user.isCredentialsNonExpired())
                return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        };
    }

    @Bean
    @Qualifier("authorizationManager")
    public AuthenticationManager authorizationManager() {
        return authentication -> {
            if (authentication == null)
                return null;

            String username = authentication.getName().toLowerCase(Locale.ROOT).trim();
            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (!user.isCredentialsNonExpired())
                return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Authorization", "content-type", "x-xsrf-token", "XSRF-TOKEN"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}