package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface OrderService {

	List<Order> findAll(Specification<Order> specification, Sort sort);

	Order save(Order order);

	Order update(Order order);

	Order findById(Integer orderId);

	void deleteById(Integer orderId);

}