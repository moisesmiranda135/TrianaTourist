package com.salesianos.triana.dam.TrianaTourist.dto.category;


import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniqueCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateCategoryDTO {

    @NotBlank(message = "{category.name.notblank}")
    @UniqueCategory(message = "{category.name.unique}")
    private String name;
}
