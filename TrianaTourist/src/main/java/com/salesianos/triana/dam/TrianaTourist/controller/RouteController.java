package com.salesianos.triana.dam.TrianaTourist.controller;


import com.salesianos.triana.dam.TrianaTourist.dto.route.CreateRouteDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.route.GetRouteDTO;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/")
    public List<GetRouteDTO> all() {
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public GetRouteDTO one(@PathVariable Long id) {
        return routeService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Route> created(@Valid @RequestBody CreateRouteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateRouteDTO> edit(@Valid @RequestBody CreateRouteDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(routeService.edit(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable Long id) {
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id1}/poi/{id2}")
    public ResponseEntity<Route> addPOItoRoute(@PathVariable Long id1, @PathVariable Long id2) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.addPOItoRoute(id1, id2));
    }

    @DeleteMapping("{id1}/poi/{id2}")
    public ResponseEntity<Route> deletePOItoRoute(@PathVariable Long id1, @PathVariable Long id2) {
        return  ResponseEntity.ok().body(routeService.deletePOItoRoute(id1, id2));
    }
}
