package rs.carrot.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.backend.entity.ProductBrand;
import rs.carrot.backend.service.ProductBrandService;

import java.util.List;

@RestController
@RequestMapping("/product-brands")
@RequiredArgsConstructor
public class ProductBrandController {
    private final ProductBrandService productBrandService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllProductBrands")
    public ResponseEntity<List<ProductBrand>> getAllProductBrands(@RequestParam(name = "q", required = false) Specification<ProductBrand> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(productBrandService.findAll(specification, sort));
    }

    @GetMapping("/{productBrandId}")
    @ApiOperation(value = "", nickname = "getProductBrandById")
    public ResponseEntity<ProductBrand> getProductBrandById(@PathVariable Integer productBrandId) {
        return ResponseEntity.ok(productBrandService.findById(productBrandId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveProductBrand")
    public ResponseEntity<ProductBrand> saveProductBrand(@RequestBody ProductBrand productBrand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productBrandService.save(productBrand));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateProductBrand")
    public ResponseEntity<ProductBrand> updateProductBrand(@RequestBody ProductBrand productBrand) {
        return ResponseEntity.ok(productBrandService.update(productBrand));
    }

    @DeleteMapping("/{productBrandId}")
    @ApiOperation(value = "", nickname = "deleteProductBrandById")
    public void deleteProductBrandById(@PathVariable Integer productBrandId) {
        productBrandService.deleteById(productBrandId);
    }

}

