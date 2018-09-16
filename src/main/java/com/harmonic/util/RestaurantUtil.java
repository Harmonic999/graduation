package com.harmonic.util;

import com.harmonic.model.Restaurant;
import com.harmonic.model.VotesAccountant;
import com.harmonic.to.RestaurantTo;

import java.util.ArrayList;
import java.util.List;

public class RestaurantUtil {

    public static RestaurantTo asTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName());
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
        return new Restaurant(restaurantTo.getId(), restaurantTo.getName());
    }

    public static void setVotes(List<RestaurantTo> tos, List<VotesAccountant> accountants) {
        // TODO: implement this another way with map - if map contains key(restaurant_id) set value(ids_count)
        for (RestaurantTo restaurantTo : tos) {
            for (VotesAccountant accountant : accountants) {
                if (restaurantTo.getId().equals(accountant.getRestaurantId())) {
                    restaurantTo.setVoteCount(restaurantTo.getVoteCount() + 1);
                }
            }
        }
    }


}
