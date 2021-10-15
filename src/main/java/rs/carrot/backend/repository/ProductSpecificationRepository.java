package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.ProductSpecification;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Integer>, JpaSpecificationExecutor<ProductSpecification> {

}