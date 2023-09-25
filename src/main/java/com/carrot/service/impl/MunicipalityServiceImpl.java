package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.MunicipalityRepository;
import com.carrot.service.MunicipalityService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImpl implements MunicipalityService {
	private final MunicipalityRepository municipalityRepository;

	@Override
	public List<Municipality> findAll(Specification<Municipality> specification, Sort sort) {
		return municipalityRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Municipality findById(Integer municipalityId) {
		return municipalityRepository.findById(municipalityId)
				.orElseThrow(() -> new NoSuchElementException("MunicipalityService.notFound"));
	}

	@Override
	public Municipality save(Municipality municipality) {
		return municipalityRepository.save(municipality);
	}

	@Override
	public Municipality update(Municipality municipality) {
		return municipalityRepository.save(municipality);
	}

	@Override
	public void deleteById(Integer municipalityId) {
		municipalityRepository.deleteById(municipalityId);
	}


}