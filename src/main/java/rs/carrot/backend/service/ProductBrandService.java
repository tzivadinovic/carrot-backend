package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface ProductBrandService {

	List<ProductBrand> findAll(Specification<ProductBrand> specification, Sort sort);

	ProductBrand save(ProductBrand productBrand);

	ProductBrand update(ProductBrand productBrand);

	ProductBrand findById(Integer productBrandId);

	void deleteById(Integer productBrandId);

}