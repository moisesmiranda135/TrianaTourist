package com.salesianos.triana.dam.TrianaTourist.dto.POI;

import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniquePhoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@UniquePhoto(coverPhotoField = "coverPhoto", photo2Field = "photo2", photo3Field = "photo3", message = "{POI.uniquePhoto.notmatch}")
public class CreatePOIDTO {

    @NotBlank(message = "{POI.name.notblank}")
    private String name;

    @Pattern(regexp ="^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$"
            ,message = "{POI.location.pattern}" )
    private String location;

    private String description;

    private LocalDate date;

    private Long category_id;

    @NotBlank(message = "{POI.name.blank}")
    @NotNull(message = "{POI.name.null}")
    @Pattern(regexp = "(https?:\\/\\/.*\\.(?:png|jpg))", message = "{POI.url.pattern}")
    private String coverPhoto;

    @Pattern(regexp = "(https?:\\/\\/.*\\.(?:png|jpg))", message = "{POI.url.pattern}")
    private String photo2;

    @Pattern(regexp = "(https?:\\/\\/.*\\.(?:png|jpg))", message = "{POI.url.pattern}")
    private String photo3;
}