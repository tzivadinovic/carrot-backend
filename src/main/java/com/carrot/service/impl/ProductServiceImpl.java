package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.ProductRepository;
import com.carrot.service.ProductService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<Product> findAll(Specification<Product> specification, Sort sort) {
		return productRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Product findById(Integer productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NoSuchElementException("ProductService.notFound"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Integer productId) {
		productRepository.deleteById(productId);
	}


}