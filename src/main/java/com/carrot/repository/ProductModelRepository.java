package com.carrot.repository;

import com.carrot.entity.ProductModel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel> {

}