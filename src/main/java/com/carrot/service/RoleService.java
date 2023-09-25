package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface RoleService {

	List<Role> findAll(Specification<Role> specification, Sort sort);

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleId);

	void deleteById(Integer roleId);

}