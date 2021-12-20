package com.salesianos.triana.dam.TrianaTourist.validation.simple.validations;



import com.salesianos.triana.dam.TrianaTourist.validation.simple.annotations.UniquePhoto;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniquePhotoValidator implements ConstraintValidator<UniquePhoto, String> {

    private String coverPhotoField;
    private String photo2Field;
    private String photo3Field;


    @Override
    public void initialize(UniquePhoto constraintAnnotation) {
        coverPhotoField = constraintAnnotation.coverPhotoField();
        photo2Field = constraintAnnotation.photo2Field();
        photo3Field = constraintAnnotation.photo3Field();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String coverPhoto = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhotoField);
        String photo2 = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2Field);
        String photo3 = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3Field);

        if ((coverPhoto.contentEquals(photo2))
                || (coverPhoto.contentEquals(photo3))
                || (photo2.contentEquals(photo3))
        ){
            return coverPhoto == null;
        } else {
            return StringUtils.hasText(coverPhoto) && true;
        }

    }

}