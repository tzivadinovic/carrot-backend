package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.ProductOrderRepository;
import com.carrot.service.ProductOrderService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOrderServiceImpl implements ProductOrderService {
	private final ProductOrderRepository productOrderRepository;

	@Override
	public List<ProductOrder> findAll(Specification<ProductOrder> specification, Sort sort) {
		return productOrderRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public ProductOrder findById(Integer productOrderId) {
		return productOrderRepository.findById(productOrderId)
				.orElseThrow(() -> new NoSuchElementException("ProductOrderService.notFound"));
	}

	@Override
	public ProductOrder save(ProductOrder productOrder) {
		return productOrderRepository.save(productOrder);
	}

	@Override
	public ProductOrder update(ProductOrder productOrder) {
		return productOrderRepository.save(productOrder);
	}

	@Override
	public void deleteById(Integer productOrderId) {
		productOrderRepository.deleteById(productOrderId);
	}


}