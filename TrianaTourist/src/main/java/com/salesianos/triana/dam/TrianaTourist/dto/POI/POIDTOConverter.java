package com.salesianos.triana.dam.TrianaTourist.dto.POI;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.CreatePOIDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.POI.GetPOIDTO;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import org.springframework.stereotype.Component;

@Component
public class POIDTOConverter {

    public static GetPOIDTO POIToGetPOIDTO(POI p) {

        GetPOIDTO result = new GetPOIDTO();
        result.setName(p.getName());
        result.setLocation(p.getLocation());
        result.setDescription(p.getDescription());
        result.setDate(p.getDate());
        result.setCategoryName(p.getCategory().getName());
        result.setCoverPhoto(p.getCoverPhoto());
        result.setPhoto2(p.getPhoto2());
        result.setPhoto3(p.getPhoto3());

        return result;
    }

    public CreatePOIDTO editPOI(POI poi){
        return CreatePOIDTO.builder()
                .name(poi.getName())
                .location(poi.getLocation())
                .description(poi.getDescription())
                .date(poi.getDate())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .category_id(poi.getCategory().getId())
                .build();
    }

}