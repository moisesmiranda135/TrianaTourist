package com.salesianos.triana.dam.TrianaTourist.dto.POI;

import com.salesianos.triana.dam.TrianaTourist.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPOIDTO {

    private String name;

    private String location;

    private String description;

    private LocalDate date;

    private String categoryName;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
