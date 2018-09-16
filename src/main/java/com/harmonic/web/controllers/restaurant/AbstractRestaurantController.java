package com.harmonic.web.controllers.restaurant;

import com.harmonic.service.RestaurantService;
import com.harmonic.service.VotesAccountantService;
import com.harmonic.to.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.harmonic.util.RestaurantUtil.*;

public abstract class AbstractRestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VotesAccountantService votesAccountantService;

    List<RestaurantTo> getAll() {
        List<RestaurantTo> tos = asTo(restaurantService.getAll());
        setVotes(tos, votesAccountantService.getAll());
        return tos;
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

    void handleUserVote(int userId, int restaurantId) {
        votesAccountantService.handleUserVote(userId, restaurantId);
    }
}
