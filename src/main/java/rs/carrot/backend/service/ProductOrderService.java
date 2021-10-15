package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface ProductOrderService {

	List<ProductOrder> findAll(Specification<ProductOrder> specification, Sort sort);

	ProductOrder save(ProductOrder productOrder);

	ProductOrder update(ProductOrder productOrder);

	ProductOrder findById(Integer productOrderId);

	void deleteById(Integer productOrderId);

}