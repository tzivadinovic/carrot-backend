package com.carrot.controller;

import com.carrot.entity.*;
import com.carrot.service.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/municipalities-by-city")
    @ApiOperation(value = "", nickname = "getAllMunicipalitiesByCityId")
    public ResponseEntity<List<Municipality>> getAllMunicipalitiesByCityId(@RequestParam Integer cityId) {
        return ResponseEntity.ok(municipalityService.findAllByCityId(cityId));
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

