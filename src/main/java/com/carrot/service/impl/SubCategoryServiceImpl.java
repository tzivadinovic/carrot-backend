package com.carrot.service.impl;

import com.carrot.entity.*;
import com.carrot.repository.SubCategoryRepository;
import com.carrot.service.SubCategoryService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {
	private final SubCategoryRepository subCategoryRepository;

	@Override
	public List<SubCategory> findAll(Specification<SubCategory> specification, Sort sort) {
		return subCategoryRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public SubCategory findById(Integer subCategoryId) {
		return subCategoryRepository.findById(subCategoryId)
				.orElseThrow(() -> new NoSuchElementException("SubCategoryService.notFound"));
	}

	@Override
	public SubCategory save(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	@Override
	public SubCategory update(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	@Override
	public void deleteById(Integer subCategoryId) {
		subCategoryRepository.deleteById(subCategoryId);
	}


}