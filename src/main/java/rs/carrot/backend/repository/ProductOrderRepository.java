package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer>, JpaSpecificationExecutor<ProductOrder> {

}