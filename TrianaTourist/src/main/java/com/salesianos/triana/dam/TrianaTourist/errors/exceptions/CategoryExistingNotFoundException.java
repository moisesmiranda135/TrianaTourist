package com.salesianos.triana.dam.TrianaTourist.errors.exceptions;

public class CategoryExistingNotFoundException extends EntityNotFoundException {

    public CategoryExistingNotFoundException() {
        super(String.format("La categoría del punto de interés debe ser una categoría existente"));
    }
}
