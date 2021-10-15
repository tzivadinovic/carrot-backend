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
@RequestMapping("/product-models")
@RequiredArgsConstructor
public class ProductModelController {
	private final ProductModelService productModelService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProductModels")
	public ResponseEntity<List<ProductModel>> getAllProductModels(@RequestParam(name = "q", required = false) Specification<ProductModel> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(productModelService.findAll(specification, sort));
	}

	@GetMapping("/{productModelId}")
	@ApiOperation(value = "", nickname = "getProductModelById")
	public ResponseEntity<ProductModel> getProductModelById(@PathVariable Integer productModelId) {
		return ResponseEntity.ok(productModelService.findById(productModelId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveProductModel")
	public ResponseEntity<ProductModel> saveProductModel(@RequestBody ProductModel productModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productModelService.save(productModel));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateProductModel")
	public ResponseEntity<ProductModel> updateProductModel(@RequestBody ProductModel productModel) {
		return ResponseEntity.ok(productModelService.update(productModel));
	}

	@DeleteMapping("/{productModelId}")
	@ApiOperation(value = "", nickname = "deleteProductModelById")
	public void deleteProductModelById(@PathVariable Integer productModelId) {
		productModelService.deleteById(productModelId);
	}

}
