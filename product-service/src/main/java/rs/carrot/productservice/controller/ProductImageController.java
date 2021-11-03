package rs.carrot.productservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.productservice.entity.ProductImage;
import rs.carrot.productservice.service.ProductImageService;

import java.util.List;

@RestController
@RequestMapping("/product-images")
@RequiredArgsConstructor
public class ProductImageController {
    private final ProductImageService productImageService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllProductImages")
    public ResponseEntity<List<ProductImage>> getAllProductImages(@RequestParam(name = "q", required = false) Specification<ProductImage> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(productImageService.findAll(specification, sort));
    }

    @GetMapping("/{productImageId}")
    @ApiOperation(value = "", nickname = "getProductImageById")
    public ResponseEntity<ProductImage> getProductImageById(@PathVariable Integer productImageId) {
        return ResponseEntity.ok(productImageService.findById(productImageId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveProductImage")
    public ResponseEntity<ProductImage> saveProductImage(@RequestBody ProductImage productImage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productImageService.save(productImage));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateProductImage")
    public ResponseEntity<ProductImage> updateProductImage(@RequestBody ProductImage productImage) {
        return ResponseEntity.ok(productImageService.update(productImage));
    }

    @DeleteMapping("/{productImageId}")
    @ApiOperation(value = "", nickname = "deleteProductImageById")
    public void deleteProductImageById(@PathVariable Integer productImageId) {
        productImageService.deleteById(productImageId);
    }

}

