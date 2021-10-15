package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.ProductRepository;
import rs.carrot.backend.service.ProductService;

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