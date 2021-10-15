package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.ProductModel;

import java.util.List;

public interface ProductModelService {

    List<ProductModel> findAll(Specification<ProductModel> specification, Sort sort);

    ProductModel save(ProductModel productModel);

    ProductModel update(ProductModel productModel);

    ProductModel findById(Integer productModelId);

    void deleteById(Integer productModelId);

}