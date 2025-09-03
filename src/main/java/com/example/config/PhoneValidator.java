package com.example.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {
    @Override
    public boolean isValid(String msg, ConstraintValidatorContext constraintValidatorContext) {
        if (!msg.isEmpty() && !msg.isBlank() && msg.matches("^(?:\\+91|91)?[6-9]\\d{9}$")){
            return true;
        }
        return false;
    }
}
