package com.carrot.security;

import com.carrot.entity.User;
import com.carrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

@Component
@RequiredArgsConstructor
@Primary
public class AuthenticationManagerImpl implements AuthenticationManager {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final Environment env;
    @Resource(name = "errorMessages")
    private Properties properties;
    @Value("${spring.security.disabled:false}")
    private String securityDisabled;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty())
            throw new BadCredentialsException(properties.getProperty("auth.invalidCredentials"));

        User user = userOptional.get();
        if (!user.isEnabled())
            throw new DisabledException(properties.getProperty("auth.accountDisabled"));

        boolean isSecurityDisabled = Boolean.parseBoolean(securityDisabled)
                || Arrays.asList(env.getActiveProfiles()).contains("staging")
                || Arrays.asList(env.getActiveProfiles()).contains("qa")
                || Arrays.asList(env.getActiveProfiles()).contains("dev");

        // Security override
        if (!isSecurityDisabled) {
            // If the user's password in database is null. We're authenticating
            // with LDAP server.
            if (user.getPassword() == null) {
                if (password == null)
                    throw new BadCredentialsException(properties.getProperty("auth.invalidCredentials"));
            } else {
                if (password == null || !passwordEncoder.matches(password, user.getPassword()))
                    throw new BadCredentialsException(properties.getProperty("auth.invalidCredentials"));
            }
        }
        return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
    }
}
