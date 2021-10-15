package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface RoleService {

	List<Role> findAll(Specification<Role> specification, Sort sort);

	Role save(Role role);

	Role update(Role role);

	Role findById(Integer roleId);

	void deleteById(Integer roleId);

}