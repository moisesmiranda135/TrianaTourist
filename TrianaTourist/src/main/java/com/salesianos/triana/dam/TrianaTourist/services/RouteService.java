package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;


    public List<Route> findAll() {
        List<Route> result = routeRepository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        } else {
            return result;

        }
    }

    public Route findById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    //FALTA EDITAR Y CREAR


    public void deleteById(Long id) {

        Optional<Route> estacionServicio = routeRepository.findById(id);
        if(estacionServicio.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }
}
