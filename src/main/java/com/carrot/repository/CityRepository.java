package com.carrot.repository;

import com.carrot.entity.City;
import com.carrot.entity.Country;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {
    List<City> findAllByCountry_Id(Integer countryId);

    Optional<City> findByCountry_Id(Integer countryId);
}