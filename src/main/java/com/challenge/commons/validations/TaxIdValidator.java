package com.challenge.commons.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaxIdValidator implements ConstraintValidator<TaxId, String> {
    @Override
    public boolean isValid(String taxIdNumber, ConstraintValidatorContext arg1) {
        return taxIdNumber.matches("[A-z]{4}[0-9]{6}[A-z0-9]{3}");
    }    
}
