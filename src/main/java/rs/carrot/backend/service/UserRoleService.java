package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findAll(Specification<UserRole> specification, Sort sort);

    UserRole save(UserRole userRole);

    UserRole update(UserRole userRole);

    UserRole findById(Integer userRoleId);

    void deleteById(Integer userRoleId);

}