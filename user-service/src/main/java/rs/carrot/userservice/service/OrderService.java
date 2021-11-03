package rs.carrot.userservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.userservice.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll(Specification<Order> specification, Sort sort);

    Order save(Order order);

    Order update(Order order);

    Order findById(Integer orderId);

    void deleteById(Integer orderId);

}