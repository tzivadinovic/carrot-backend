package rs.carrot.authservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.carrot.authservice.service.external.UserService;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.getByUsername(username);
    }
}
