package com.salesianos.triana.dam.TrianaTourist.dto.POI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePOIDTO {

    @NotBlank(message = "{POI.name.notblank}")
    private String name;

    private String location;

    private String description;

    private LocalDate date;

    private Long category_id;

    private String coverPhoto;

    private String photo2;

    private String photo3;
}