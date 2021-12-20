package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.CreatePOIDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.POI.GetPOIDTO;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public List<GetPOIDTO> all() {
        return poiService.findAll();
    }

    @GetMapping("/{id}")
    public GetPOIDTO one(@PathVariable Long id) {
        return poiService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<POI> created(@Valid @RequestBody CreatePOIDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(poiService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreatePOIDTO> edit(@Valid @RequestBody CreatePOIDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(poiService.edit(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePOI(@PathVariable Long id) {
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
