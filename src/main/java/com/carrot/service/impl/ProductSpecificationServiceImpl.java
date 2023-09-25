package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.ProductSpecificationRepository;
import com.carrot.service.ProductSpecificationService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
	private final ProductSpecificationRepository productSpecificationRepository;

	@Override
	public List<ProductSpecification> findAll(Specification<ProductSpecification> specification, Sort sort) {
		return productSpecificationRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public ProductSpecification findById(Integer productSpecificationId) {
		return productSpecificationRepository.findById(productSpecificationId)
				.orElseThrow(() -> new NoSuchElementException("ProductSpecificationService.notFound"));
	}

	@Override
	public ProductSpecification save(ProductSpecification productSpecification) {
		return productSpecificationRepository.save(productSpecification);
	}

	@Override
	public ProductSpecification update(ProductSpecification productSpecification) {
		return productSpecificationRepository.save(productSpecification);
	}

	@Override
	public void deleteById(Integer productSpecificationId) {
		productSpecificationRepository.deleteById(productSpecificationId);
	}


}