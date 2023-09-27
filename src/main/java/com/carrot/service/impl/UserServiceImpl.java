package com.carrot.service.impl;

import com.carrot.data.dto.UserDTO;
import com.carrot.entity.*;
import com.carrot.repository.RoleRepository;
import com.carrot.repository.UserRepository;
import com.carrot.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> findAll(Specification<User> specification, Sort sort) {
        return userRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User saveUserDTO(UserDTO userDTO) {
        Role role = userDTO.getIsAdmin() ? roleRepository.findByName("ADMIN") : roleRepository.findByName("CUSTOMER");
        User user = userDTO.getUser();
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("UserServiceImpl.userByUsername.notFound"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}