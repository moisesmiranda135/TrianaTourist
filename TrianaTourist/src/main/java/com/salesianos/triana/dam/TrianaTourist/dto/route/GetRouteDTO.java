package com.salesianos.triana.dam.TrianaTourist.dto.route;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.GetPOIDTO;
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
public class GetRouteDTO {

    private String name;

    private List<GetPOIDTO> steps = new ArrayList<>();

}
