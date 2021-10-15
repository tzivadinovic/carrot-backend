package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.ProductModel;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel> {

}