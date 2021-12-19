package com.salesianos.triana.dam.TrianaTourist.dto.category;

import com.salesianos.triana.dam.TrianaTourist.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter {

    public Category createCategory(CreateCategoryDTO category){
        return new Category(
                category.getName()
        );
    }
}
