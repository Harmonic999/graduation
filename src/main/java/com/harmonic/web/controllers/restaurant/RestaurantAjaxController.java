package com.harmonic.web.controllers.restaurant;

import com.harmonic.to.RestaurantTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/restaurants")
public class RestaurantAjaxController extends AbstractRestaurantController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<RestaurantTo> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}")
    RestaurantTo get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    void deleteRestaurant(@PathVariable int id) {
        super.deleteRestaurant(id);
    }

    @Override
    @PostMapping
    void createOrUpdateRestaurant(RestaurantTo restaurantTo) {
        super.createOrUpdateRestaurant(restaurantTo);
    }
}
