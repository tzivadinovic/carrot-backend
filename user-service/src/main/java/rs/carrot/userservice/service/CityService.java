package rs.carrot.userservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.userservice.entity.City;

import java.util.List;

public interface CityService {

    List<City> findAll(Specification<City> specification, Sort sort);

    City save(City city);

    City update(City city);

    City findById(Integer cityId);

    void deleteById(Integer cityId);

}