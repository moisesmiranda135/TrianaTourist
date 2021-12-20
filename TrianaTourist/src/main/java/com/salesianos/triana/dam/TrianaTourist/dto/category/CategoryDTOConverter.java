package com.salesianos.triana.dam.TrianaTourist.dto.category;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.CreatePOIDTO;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter {

    public Category createCategory(CreateCategoryDTO category){
        return new Category(
                category.getName()
        );
    }

    public CreateCategoryDTO editCategory(Category category){
        return CreateCategoryDTO.builder()
                .name(category.getName())
                .build();
    }
}
