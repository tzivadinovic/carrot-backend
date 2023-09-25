package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface UserService {

	List<User> findAll(Specification<User> specification, Sort sort);

	User save(User user);

	User update(User user);

	User findById(Integer userId);

	void deleteById(Integer userId);

}