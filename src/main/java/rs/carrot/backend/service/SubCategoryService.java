package rs.carrot.backend.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.backend.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    List<SubCategory> findAll(Specification<SubCategory> specification, Sort sort);

    SubCategory save(SubCategory subCategory);

    SubCategory update(SubCategory subCategory);

    SubCategory findById(Integer subCategoryId);

    void deleteById(Integer subCategoryId);

}