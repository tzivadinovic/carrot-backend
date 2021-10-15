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
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
	private final CountryService countryService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries(@RequestParam(name = "q", required = false) Specification<Country> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(countryService.findAll(specification, sort));
	}

	@GetMapping("/{countryId}")
	@ApiOperation(value = "", nickname = "getCountryById")
	public ResponseEntity<Country> getCountryById(@PathVariable Integer countryId) {
		return ResponseEntity.ok(countryService.findById(countryId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveCountry")
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
		return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		return ResponseEntity.ok(countryService.update(country));
	}

	@DeleteMapping("/{countryId}")
	@ApiOperation(value = "", nickname = "deleteCountryById")
	public void deleteCountryById(@PathVariable Integer countryId) {
		countryService.deleteById(countryId);
	}

}

