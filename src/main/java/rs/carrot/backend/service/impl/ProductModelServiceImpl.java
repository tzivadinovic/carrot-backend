package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.ProductModelRepository;
import rs.carrot.backend.service.ProductModelService;

@Service
@RequiredArgsConstructor
public class ProductModelServiceImpl implements ProductModelService {
	private final ProductModelRepository productModelRepository;

	@Override
	public List<ProductModel> findAll(Specification<ProductModel> specification, Sort sort) {
		return productModelRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public ProductModel findById(Integer productModelId) {
		return productModelRepository.findById(productModelId)
				.orElseThrow(() -> new NoSuchElementException("ProductModelService.notFound"));
	}

	@Override
	public ProductModel save(ProductModel productModel) {
		return productModelRepository.save(productModel);
	}

	@Override
	public ProductModel update(ProductModel productModel) {
		return productModelRepository.save(productModel);
	}

	@Override
	public void deleteById(Integer productModelId) {
		productModelRepository.deleteById(productModelId);
	}


}