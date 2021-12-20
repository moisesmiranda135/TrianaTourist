package com.salesianos.triana.dam.TrianaTourist.dto.route;

import com.salesianos.triana.dam.TrianaTourist.models.RoutePOI;
import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniqueCategory;
import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniqueRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRouteDTO {

    @UniqueRoute(message = "{route.name.unique}")
    private String name;

    private List<RoutePOI> steps = new ArrayList<>();

}
