package rs.carrot.productservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.productservice.entity.ProductSpecification;

import java.util.List;

public interface ProductSpecificationService {

    List<ProductSpecification> findAll(Specification<ProductSpecification> specification, Sort sort);

    ProductSpecification save(ProductSpecification productSpecification);

    ProductSpecification update(ProductSpecification productSpecification);

    ProductSpecification findById(Integer productSpecificationId);

    void deleteById(Integer productSpecificationId);

}