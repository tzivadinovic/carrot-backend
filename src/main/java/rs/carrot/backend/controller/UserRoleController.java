package rs.carrot.backend.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.carrot.backend.entity.UserRole;
import rs.carrot.backend.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/user-roles")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllUserRoles")
    public ResponseEntity<List<UserRole>> getAllUserRoles(@RequestParam(name = "q", required = false) Specification<UserRole> specification, @RequestParam(name = "sort", required = false) Sort sort) {
        return ResponseEntity.ok(userRoleService.findAll(specification, sort));
    }

    @GetMapping("/{userRoleId}")
    @ApiOperation(value = "", nickname = "getUserRoleById")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Integer userRoleId) {
        return ResponseEntity.ok(userRoleService.findById(userRoleId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveUserRole")
    public ResponseEntity<UserRole> saveUserRole(@RequestBody UserRole userRole) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRoleService.save(userRole));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateUserRole")
    public ResponseEntity<UserRole> updateUserRole(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(userRoleService.update(userRole));
    }

    @DeleteMapping("/{userRoleId}")
    @ApiOperation(value = "", nickname = "deleteUserRoleById")
    public void deleteUserRoleById(@PathVariable Integer userRoleId) {
        userRoleService.deleteById(userRoleId);
    }

}

