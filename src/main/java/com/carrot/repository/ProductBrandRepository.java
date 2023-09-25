package com.carrot.repository;

import com.carrot.entity.ProductBrand;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer>, JpaSpecificationExecutor<ProductBrand> {

}