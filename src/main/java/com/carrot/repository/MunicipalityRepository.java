package com.carrot.repository;

import com.carrot.entity.Municipality;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer>, JpaSpecificationExecutor<Municipality> {

}