package rs.carrot.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.userservice.entity.Country;
import rs.carrot.userservice.repository.CountryRepository;
import rs.carrot.userservice.service.CountryService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll(Specification<Country> specification, Sort sort) {
        return countryRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Country findById(Integer countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new NoSuchElementException("CountryService.notFound"));
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Integer countryId) {
        countryRepository.deleteById(countryId);
    }


}