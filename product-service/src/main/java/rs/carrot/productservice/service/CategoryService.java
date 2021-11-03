package rs.carrot.productservice.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import rs.carrot.productservice.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll(Specification<Category> specification, Sort sort);

    Category save(Category category);

    Category update(Category category);

    Category findById(Integer categoryId);

    void deleteById(Integer categoryId);

}