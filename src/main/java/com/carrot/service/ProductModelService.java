package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface ProductModelService {

	List<ProductModel> findAll(Specification<ProductModel> specification, Sort sort);

	ProductModel save(ProductModel productModel);

	ProductModel update(ProductModel productModel);

	ProductModel findById(Integer productModelId);

	void deleteById(Integer productModelId);

}