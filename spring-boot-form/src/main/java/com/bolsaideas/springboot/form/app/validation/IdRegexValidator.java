package com.bolsaideas.springboot.form.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdRegexValidator implements ConstraintValidator<IdentifiationRegexAnnotation, String> {

    @Override
    public void initialize(IdentifiationRegexAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return value.matches("REGEX");
    }
}
