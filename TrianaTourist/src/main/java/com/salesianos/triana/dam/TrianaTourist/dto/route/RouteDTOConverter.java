package com.salesianos.triana.dam.TrianaTourist.dto.route;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.GetPOIDTO;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDTOConverter {

    public static GetRouteDTO RouteToGetRouteDTO(Route r) {

        return GetRouteDTO.builder()
                .name(r.getName())
                .steps(r.getSteps().stream().map(poi -> new GetPOIDTO(
                        poi.getName(),
                        poi.getLocation(),
                        poi.getDescription(),
                        poi.getDate(),
                        poi.getCategory().getName(),
                        poi.getCoverPhoto(),
                        poi.getPhoto2(),
                        poi.getPhoto3()
                )).toList())
                .build();
    }

    public CreateRouteDTO editRoute(Route route){
        return CreateRouteDTO.builder()
                .name(route.getName())
                .build();
    }
}
