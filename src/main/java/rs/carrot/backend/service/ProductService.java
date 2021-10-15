package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface ProductService {

	List<Product> findAll(Specification<Product> specification, Sort sort);

	Product save(Product product);

	Product update(Product product);

	Product findById(Integer productId);

	void deleteById(Integer productId);

}