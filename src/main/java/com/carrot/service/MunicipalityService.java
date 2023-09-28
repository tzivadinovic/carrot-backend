package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface MunicipalityService {

	List<Municipality> findAll(Specification<Municipality> specification, Sort sort);

	Municipality save(Municipality municipality);

	Municipality update(Municipality municipality);

	Municipality findById(Integer municipalityId);

	void deleteById(Integer municipalityId);

	List<Municipality> findAllByCityId(Integer cityId);

}