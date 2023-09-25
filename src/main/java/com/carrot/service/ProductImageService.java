package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface ProductImageService {

	List<ProductImage> findAll(Specification<ProductImage> specification, Sort sort);

	ProductImage save(ProductImage productImage);

	ProductImage update(ProductImage productImage);

	ProductImage findById(Integer productImageId);

	void deleteById(Integer productImageId);

}