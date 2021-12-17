package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/")
    public List<Route> all() {
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public Route one(@PathVariable Long id) {
        return routeService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable Long id) {
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
