package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


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

    //FALTA EDITAR Y CREAR


    public void deleteById(Long id) {

        Optional<Category> estacionServicio = categoryRepository.findById(id);
        if(estacionServicio.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Category.class);
        }else{
            categoryRepository.deleteById(id);
        }
    }
}