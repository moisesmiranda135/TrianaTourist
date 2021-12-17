package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public List<POI> all() {
        return poiService.findAll();
    }

    @GetMapping("/{id}")
    public POI one(@PathVariable Long id) {
        return poiService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePOI(@PathVariable Long id) {
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
