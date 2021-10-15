package rs.carrot.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.UserRole;
import rs.carrot.backend.repository.UserRoleRepository;
import rs.carrot.backend.service.UserRoleService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll(Specification<UserRole> specification, Sort sort) {
        return userRoleRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public UserRole findById(Integer userRoleId) {
        return userRoleRepository.findById(userRoleId)
                .orElseThrow(() -> new NoSuchElementException("UserRoleService.notFound"));
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteById(Integer userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }


}