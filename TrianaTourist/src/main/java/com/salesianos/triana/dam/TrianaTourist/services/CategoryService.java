package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.dto.category.CategoryDTOConverter;
import com.salesianos.triana.dam.TrianaTourist.dto.category.CreateCategoryDTO;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDTOConverter categoryDTOConverter;
    private final POIRepository poiRepository;


    public List<Category> findAll() {
        List<Category> result = categoryRepository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return result;

        }
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }


    public Category save (CreateCategoryDTO c){
        Category category = categoryDTOConverter.createCategory(c);

        this.categoryRepository.save(category);

        return category;

    }


    public CreateCategoryDTO edit (CreateCategoryDTO category, Long id) {
        return categoryRepository.findById(id).map(c -> {
            c.setName(category.getName());
            categoryRepository.save(c);
            return categoryDTOConverter.editCategory(c);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));

    }


    public void deleteById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Category.class);
        }else{
            List<POI> poi = poiRepository.allCategoryPOI(id);
            poi.forEach(p -> {
                p.setCategory(null);
                poiRepository.save(p);
            });
            categoryRepository.deleteById(id);
        }
    }
}