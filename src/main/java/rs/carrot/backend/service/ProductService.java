package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(Specification<Product> specification, Sort sort);

    Product save(Product product);

    Product update(Product product);

    Product findById(Integer productId);

    void deleteById(Integer productId);

}