package rs.carrot.userservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.userservice.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll(Specification<User> specification, Sort sort);

    User findById(Integer userId);

    User loadByUsername(String username);

    User save(User user);

    User update(User user);

    void deleteById(Integer userId);

}