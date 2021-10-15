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
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
	private final AddressService addressService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllAddresses")
	public ResponseEntity<List<Address>> getAllAddresses(@RequestParam(name = "q", required = false) Specification<Address> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(addressService.findAll(specification, sort));
	}

	@GetMapping("/{addressId}")
	@ApiOperation(value = "", nickname = "getAddressById")
	public ResponseEntity<Address> getAddressById(@PathVariable Integer addressId) {
		return ResponseEntity.ok(addressService.findById(addressId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveAddress")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateAddress")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		return ResponseEntity.ok(addressService.update(address));
	}

	@DeleteMapping("/{addressId}")
	@ApiOperation(value = "", nickname = "deleteAddressById")
	public void deleteAddressById(@PathVariable Integer addressId) {
		addressService.deleteById(addressId);
	}

}

