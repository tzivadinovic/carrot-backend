package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface CityService {

	List<City> findAll(Specification<City> specification, Sort sort);

	City save(City city);

	City update(City city);

	City findById(Integer cityId);

	void deleteById(Integer cityId);

	List<City> findAllByCountryId(Integer countryId);

	City findByCountryId(Integer countryId);

}