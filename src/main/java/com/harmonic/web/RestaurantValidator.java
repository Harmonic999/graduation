package com.harmonic.web;

import com.harmonic.to.RestaurantTo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RestaurantValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RestaurantTo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //RestaurantTo restaurantTo = (RestaurantTo) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name field is empty");
    }

}
