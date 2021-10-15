package rs.carrot.backend.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.*;

public interface SubCategoryService {

	List<SubCategory> findAll(Specification<SubCategory> specification, Sort sort);

	SubCategory save(SubCategory subCategory);

	SubCategory update(SubCategory subCategory);

	SubCategory findById(Integer subCategoryId);

	void deleteById(Integer subCategoryId);

}