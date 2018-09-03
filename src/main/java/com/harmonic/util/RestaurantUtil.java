package com.harmonic.util;

import com.harmonic.model.Restaurant;
import com.harmonic.to.RestaurantTo;

import java.util.ArrayList;
import java.util.List;

public class RestaurantUtil {

    public static RestaurantTo asTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getVotesCount());
    }

    public static List<RestaurantTo> asTo(List<Restaurant> restaurants) {
        final List<RestaurantTo> tos = new ArrayList<>();
        restaurants.forEach(restaurant -> tos.add(asTo(restaurant)));
        return tos;
    }

    public static Restaurant createFromTo(RestaurantTo restaurantTo) {
        if (restaurantTo.getVoteCount() == null) {
            restaurantTo.setVoteCount(0);
        }
        return new Restaurant(restaurantTo.getId(), restaurantTo.getName(), restaurantTo.getVoteCount());
    }

}
