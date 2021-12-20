package com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations;



import com.salesianos.triana.dam.TrianaTourist.validation.simple.validations.UniquePhotoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniquePhotoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniquePhoto {

    String message() default "El valor de este campo debe ser único";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String coverPhotoField();
    String photo2Field();
    String photo3Field();
}
