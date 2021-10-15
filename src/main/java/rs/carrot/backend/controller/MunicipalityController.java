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
@RequestMapping("/municipalities")
@RequiredArgsConstructor
public class MunicipalityController {
	private final MunicipalityService municipalityService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllMunicipalities")
	public ResponseEntity<List<Municipality>> getAllMunicipalities(@RequestParam(name = "q", required = false) Specification<Municipality> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(municipalityService.findAll(specification, sort));
	}

	@GetMapping("/{municipalityId}")
	@ApiOperation(value = "", nickname = "getMunicipalityById")
	public ResponseEntity<Municipality> getMunicipalityById(@PathVariable Integer municipalityId) {
		return ResponseEntity.ok(municipalityService.findById(municipalityId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveMunicipality")
	public ResponseEntity<Municipality> saveMunicipality(@RequestBody Municipality municipality) {
		return ResponseEntity.status(HttpStatus.CREATED).body(municipalityService.save(municipality));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateMunicipality")
	public ResponseEntity<Municipality> updateMunicipality(@RequestBody Municipality municipality) {
		return ResponseEntity.ok(municipalityService.update(municipality));
	}

	@DeleteMapping("/{municipalityId}")
	@ApiOperation(value = "", nickname = "deleteMunicipalityById")
	public void deleteMunicipalityById(@PathVariable Integer municipalityId) {
		municipalityService.deleteById(municipalityId);
	}

}
