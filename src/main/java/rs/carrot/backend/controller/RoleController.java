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
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllRoles")
	public ResponseEntity<List<Role>> getAllRoles(@RequestParam(name = "q", required = false) Specification<Role> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(roleService.findAll(specification, sort));
	}

	@GetMapping("/{roleId}")
	@ApiOperation(value = "", nickname = "getRoleById")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findById(roleId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveRole")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateRole")
	public ResponseEntity<Role> updateRole(@RequestBody Role role) {
		return ResponseEntity.ok(roleService.update(role));
	}

	@DeleteMapping("/{roleId}")
	@ApiOperation(value = "", nickname = "deleteRoleById")
	public void deleteRoleById(@PathVariable Integer roleId) {
		roleService.deleteById(roleId);
	}

}

