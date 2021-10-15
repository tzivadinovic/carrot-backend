package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

    List<ProductImage> findAll(Specification<ProductImage> specification, Sort sort);

    ProductImage save(ProductImage productImage);

    ProductImage update(ProductImage productImage);

    ProductImage findById(Integer productImageId);

    void deleteById(Integer productImageId);

}