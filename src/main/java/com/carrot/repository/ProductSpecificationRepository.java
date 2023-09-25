package com.carrot.repository;

import com.carrot.entity.ProductSpecification;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Integer>, JpaSpecificationExecutor<ProductSpecification> {

}