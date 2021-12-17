package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public List<Category> all() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category one(@PathVariable Long id) {
        return categoryService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
