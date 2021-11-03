package rs.carrot.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.carrot.productservice.entity.ProductModel;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel> {

}