package com.harmonic.web.validation;

import com.harmonic.to.RestaurantTo;
import com.harmonic.util.exception.FieldEmptyException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RestaurantValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RestaurantTo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RestaurantTo to = (RestaurantTo) target;
        if (to.getName().isEmpty()) {
            throw new FieldEmptyException("Name is required!");
        }

    }

}
