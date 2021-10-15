package rs.carrot.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.backend.entity.Order;
import rs.carrot.backend.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(name = "q", required = false) Specification<Order> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(orderService.findAll(specification, sort));
    }

    @GetMapping("/{orderId}")
    @ApiOperation(value = "", nickname = "getOrderById")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveOrder")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

    @DeleteMapping("/{orderId}")
    @ApiOperation(value = "", nickname = "deleteOrderById")
    public void deleteOrderById(@PathVariable Integer orderId) {
        orderService.deleteById(orderId);
    }

}

