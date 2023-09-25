package com.carrot.controller;

import com.carrot.entity.*;
import com.carrot.service.*;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub-categories")
@RequiredArgsConstructor
public class SubCategoryController {
	private final SubCategoryService subCategoryService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllSubCategories")
	public ResponseEntity<List<SubCategory>> getAllSubCategories(@RequestParam(name = "q", required = false) Specification<SubCategory> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(subCategoryService.findAll(specification, sort));
	}

	@GetMapping("/{subCategoryId}")
	@ApiOperation(value = "", nickname = "getSubCategoryById")
	public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Integer subCategoryId) {
		return ResponseEntity.ok(subCategoryService.findById(subCategoryId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveSubCategory")
	public ResponseEntity<SubCategory> saveSubCategory(@RequestBody SubCategory subCategory) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(subCategory));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateSubCategory")
	public ResponseEntity<SubCategory> updateSubCategory(@RequestBody SubCategory subCategory) {
		return ResponseEntity.ok(subCategoryService.update(subCategory));
	}

	@DeleteMapping("/{subCategoryId}")
	@ApiOperation(value = "", nickname = "deleteSubCategoryById")
	public void deleteSubCategoryById(@PathVariable Integer subCategoryId) {
		subCategoryService.deleteById(subCategoryId);
	}

}

