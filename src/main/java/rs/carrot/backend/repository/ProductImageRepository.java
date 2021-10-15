package rs.carrot.backend.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.carrot.backend.entity.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>, JpaSpecificationExecutor<ProductImage> {

}