package rs.carrot.userservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.userservice.entity.User;
import rs.carrot.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(name = "q", required = false) Specification<User> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(userService.findAll(specification, sort));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "", nickname = "getUserById")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping("/{username}/details")
    @ApiOperation(value = "", nickname = "getUserDetailsByUsername")
    public ResponseEntity<User> getUserDetailsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.loadByUsername(username));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "", nickname = "deleteUserById")
    public void deleteUserById(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }

}

