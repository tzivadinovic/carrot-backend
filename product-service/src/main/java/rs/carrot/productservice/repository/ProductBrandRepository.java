package rs.carrot.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.carrot.productservice.entity.ProductBrand;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer>, JpaSpecificationExecutor<ProductBrand> {

}