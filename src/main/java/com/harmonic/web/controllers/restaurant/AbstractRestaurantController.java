package com.harmonic.web.controllers.restaurant;

import com.harmonic.model.Restaurant;
import com.harmonic.service.RestaurantService;
import com.harmonic.to.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.harmonic.util.RestaurantUtil.*;

public class AbstractRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    List<RestaurantTo> getAll() {
        return asTo(restaurantService.getAll());
    }

    RestaurantTo get(int id) {
        return asTo(restaurantService.get(id));
    }

    void deleteRestaurant(int restaurantId) {
        restaurantService.delete(restaurantId);
    }

    void createOrUpdateRestaurant(RestaurantTo restaurantTo) {
        restaurantService.save(createFromTo(restaurantTo));
    }
}
