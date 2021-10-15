package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll(Specification<Country> specification, Sort sort);

    Country save(Country country);

    Country update(Country country);

    Country findById(Integer countryId);

    void deleteById(Integer countryId);

}