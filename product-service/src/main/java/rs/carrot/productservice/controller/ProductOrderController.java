package rs.carrot.productservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.productservice.entity.ProductOrder;
import rs.carrot.productservice.service.ProductOrderService;

import java.util.List;

@RestController
@RequestMapping("/product-orders")
@RequiredArgsConstructor
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllProductOrders")
    public ResponseEntity<List<ProductOrder>> getAllProductOrders(@RequestParam(name = "q", required = false) Specification<ProductOrder> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(productOrderService.findAll(specification, sort));
    }

    @GetMapping("/{productOrderId}")
    @ApiOperation(value = "", nickname = "getProductOrderById")
    public ResponseEntity<ProductOrder> getProductOrderById(@PathVariable Integer productOrderId) {
        return ResponseEntity.ok(productOrderService.findById(productOrderId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveProductOrder")
    public ResponseEntity<ProductOrder> saveProductOrder(@RequestBody ProductOrder productOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productOrderService.save(productOrder));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateProductOrder")
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder) {
        return ResponseEntity.ok(productOrderService.update(productOrder));
    }

    @DeleteMapping("/{productOrderId}")
    @ApiOperation(value = "", nickname = "deleteProductOrderById")
    public void deleteProductOrderById(@PathVariable Integer productOrderId) {
        productOrderService.deleteById(productOrderId);
    }

}

