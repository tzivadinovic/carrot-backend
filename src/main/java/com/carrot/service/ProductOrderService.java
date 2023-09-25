package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface ProductOrderService {

	List<ProductOrder> findAll(Specification<ProductOrder> specification, Sort sort);

	ProductOrder save(ProductOrder productOrder);

	ProductOrder update(ProductOrder productOrder);

	ProductOrder findById(Integer productOrderId);

	void deleteById(Integer productOrderId);

}