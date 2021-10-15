package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.ProductOrderRepository;
import rs.carrot.backend.service.ProductOrderService;

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