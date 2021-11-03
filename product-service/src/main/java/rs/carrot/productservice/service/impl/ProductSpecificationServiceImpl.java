package rs.carrot.productservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.productservice.entity.ProductSpecification;
import rs.carrot.productservice.repository.ProductSpecificationRepository;
import rs.carrot.productservice.service.ProductSpecificationService;

import java.util.List;
import java.util.NoSuchElementException;

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