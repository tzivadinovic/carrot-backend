package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface CountryService {

	List<Country> findAll(Specification<Country> specification, Sort sort);

	Country save(Country country);

	Country update(Country country);

	Country findById(Integer countryId);

	void deleteById(Integer countryId);

}