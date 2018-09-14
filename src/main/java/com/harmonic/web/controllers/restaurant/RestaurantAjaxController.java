package com.harmonic.web.controllers.restaurant;

import com.harmonic.to.RestaurantTo;
import com.harmonic.web.validation.RestaurantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/restaurants")
public class RestaurantAjaxController extends AbstractRestaurantController {

    private final RestaurantValidator validator;

    @Autowired
    public RestaurantAjaxController(RestaurantValidator validator) {
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public RestaurantTo get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        super.deleteRestaurant(id);
    }

    @PostMapping
    public void createOrUpdateRestaurant(@Validated RestaurantTo restaurantTo) {
        super.createOrUpdateRestaurant(restaurantTo);
    }
}
