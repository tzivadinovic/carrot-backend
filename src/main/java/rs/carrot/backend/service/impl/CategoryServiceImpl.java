package rs.carrot.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.repository.CategoryRepository;
import rs.carrot.backend.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll(Specification<Category> specification, Sort sort) {
		return categoryRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Category findById(Integer categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NoSuchElementException("CategoryService.notFound"));
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}


}