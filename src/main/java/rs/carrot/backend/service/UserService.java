package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface UserService {

	List<User> findAll(Specification<User> specification, Sort sort);

	User save(User user);

	User update(User user);

	User findById(Integer userId);

	void deleteById(Integer userId);

}