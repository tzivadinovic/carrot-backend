package com.carrot.service;

import com.carrot.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface SubCategoryService {

	List<SubCategory> findAll(Specification<SubCategory> specification, Sort sort);

	SubCategory save(SubCategory subCategory);

	SubCategory update(SubCategory subCategory);

	SubCategory findById(Integer subCategoryId);

	void deleteById(Integer subCategoryId);

}