package rs.carrot.userservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.userservice.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Specification<Role> specification, Sort sort);

    Role save(Role role);

    Role update(Role role);

    Role findById(Integer roleId);

    void deleteById(Integer roleId);

}