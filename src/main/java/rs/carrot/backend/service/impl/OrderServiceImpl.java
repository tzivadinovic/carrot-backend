package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.OrderRepository;
import rs.carrot.backend.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public List<Order> findAll(Specification<Order> specification, Sort sort) {
		return orderRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Order findById(Integer orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new NoSuchElementException("OrderService.notFound"));
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Integer orderId) {
		orderRepository.deleteById(orderId);
	}


}