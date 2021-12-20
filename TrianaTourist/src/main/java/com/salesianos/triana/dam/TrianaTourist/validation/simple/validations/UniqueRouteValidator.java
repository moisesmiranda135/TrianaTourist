package com.salesianos.triana.dam.TrianaTourist.validation.simple.validations;

import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniqueCategory;
import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniqueRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !routeRepository.existsByName(name);
    }
}
