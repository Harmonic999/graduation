package com.harmonic.service;

import com.harmonic.model.Food;

import java.util.List;

public interface FoodService {

    Food save(Food food, int restaurantId);

    void delete(int id);

    Food get(int id);

    List<Food> getAll(int restaurantId);

}
