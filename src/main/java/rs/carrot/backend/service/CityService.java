package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface CityService {

	List<City> findAll(Specification<City> specification, Sort sort);

	City save(City city);

	City update(City city);

	City findById(Integer cityId);

	void deleteById(Integer cityId);

}