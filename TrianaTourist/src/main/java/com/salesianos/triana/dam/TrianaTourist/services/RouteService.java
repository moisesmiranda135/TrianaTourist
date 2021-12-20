package com.salesianos.triana.dam.TrianaTourist.services;


import com.salesianos.triana.dam.TrianaTourist.dto.route.CreateRouteDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.route.GetRouteDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.route.RouteDTOConverter;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDTOConverter routeDTOConverter;


    public List<GetRouteDTO> findAll() {
        List<Route> data = routeRepository.findAll();

        if (data.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        } else {
            List<GetRouteDTO> result =
                    data.stream()
                            .map(RouteDTOConverter::RouteToGetRouteDTO)
                            .collect(Collectors.toList());

            return result;
        }
    }

    public GetRouteDTO findById(Long id) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        } else {
            List<GetRouteDTO> result =
                    data.stream()
                            .map(RouteDTOConverter::RouteToGetRouteDTO)
                            .collect(Collectors.toList());

            return routeDTOConverter.RouteToGetRouteDTO(routeRepository.findById(id).get());
        }

    }

    public Route save(CreateRouteDTO dto) {

        Route route = Route.builder()
                .name(dto.getName())
                .build();

        return routeRepository.save(route);
    }

    public CreateRouteDTO edit (CreateRouteDTO route, Long id) {
        return routeRepository.findById(id).map(r -> {
            r.setName(route.getName());
            routeRepository.save(r);
            return routeDTOConverter.editRoute(r);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));

    }

    public void deleteById(Long id) {

        Optional<Route> data = routeRepository.findById(id);
        if(data.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Route.class);
        }else{
            data.map(r -> {
                r.setSteps(null);
                routeRepository.save(r);
                routeRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            });
        }
    }
}
