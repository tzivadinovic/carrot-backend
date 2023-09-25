package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface OrderService {

	List<Order> findAll(Specification<Order> specification, Sort sort);

	Order save(Order order);

	Order update(Order order);

	Order findById(Integer orderId);

	void deleteById(Integer orderId);

}