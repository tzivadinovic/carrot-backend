package rs.carrot.backend.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.backend.entity.*;
import rs.carrot.backend.service.*;

@RestController
@RequestMapping("/product-specifications")
@RequiredArgsConstructor
public class ProductSpecificationController {
	private final ProductSpecificationService productSpecificationService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProductSpecifications")
	public ResponseEntity<List<ProductSpecification>> getAllProductSpecifications(@RequestParam(name = "q", required = false) Specification<ProductSpecification> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(productSpecificationService.findAll(specification, sort));
	}

	@GetMapping("/{productSpecificationId}")
	@ApiOperation(value = "", nickname = "getProductSpecificationById")
	public ResponseEntity<ProductSpecification> getProductSpecificationById(@PathVariable Integer productSpecificationId) {
		return ResponseEntity.ok(productSpecificationService.findById(productSpecificationId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveProductSpecification")
	public ResponseEntity<ProductSpecification> saveProductSpecification(@RequestBody ProductSpecification productSpecification) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productSpecificationService.save(productSpecification));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateProductSpecification")
	public ResponseEntity<ProductSpecification> updateProductSpecification(@RequestBody ProductSpecification productSpecification) {
		return ResponseEntity.ok(productSpecificationService.update(productSpecification));
	}

	@DeleteMapping("/{productSpecificationId}")
	@ApiOperation(value = "", nickname = "deleteProductSpecificationById")
	public void deleteProductSpecificationById(@PathVariable Integer productSpecificationId) {
		productSpecificationService.deleteById(productSpecificationId);
	}

}

