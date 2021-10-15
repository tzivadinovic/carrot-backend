package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.ProductBrand;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer>, JpaSpecificationExecutor<ProductBrand> {

}