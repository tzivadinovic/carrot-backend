package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface ProductSpecificationService {

	List<ProductSpecification> findAll(Specification<ProductSpecification> specification, Sort sort);

	ProductSpecification save(ProductSpecification productSpecification);

	ProductSpecification update(ProductSpecification productSpecification);

	ProductSpecification findById(Integer productSpecificationId);

	void deleteById(Integer productSpecificationId);

}