package com.salesianos.triana.dam.TrianaTourist.errors.exceptions;

public class AddPOItoRouteNotFoundException extends EntityNotFoundException {

    public AddPOItoRouteNotFoundException() {
        super(String.format("El punto de interés ya existe en esta ruta"));
    }
}
