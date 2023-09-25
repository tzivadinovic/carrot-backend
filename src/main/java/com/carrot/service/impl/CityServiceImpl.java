package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.CityRepository;
import com.carrot.service.CityService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
	private final CityRepository cityRepository;

	@Override
	public List<City> findAll(Specification<City> specification, Sort sort) {
		return cityRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public City findById(Integer cityId) {
		return cityRepository.findById(cityId)
				.orElseThrow(() -> new NoSuchElementException("CityService.notFound"));
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City update(City city) {
		return cityRepository.save(city);
	}

	@Override
	public void deleteById(Integer cityId) {
		cityRepository.deleteById(cityId);
	}


}