package rs.carrot.productservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.productservice.entity.ProductOrder;

import java.util.List;

public interface ProductOrderService {

    List<ProductOrder> findAll(Specification<ProductOrder> specification, Sort sort);

    ProductOrder save(ProductOrder productOrder);

    ProductOrder update(ProductOrder productOrder);

    ProductOrder findById(Integer productOrderId);

    void deleteById(Integer productOrderId);

}