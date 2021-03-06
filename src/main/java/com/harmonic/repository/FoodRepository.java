package com.harmonic.repository;

import com.harmonic.model.Food;

import java.util.List;

public interface FoodRepository {

    Food save(Food food, int restaurantId);

    boolean delete(int id);

    Food get(int id);

    List<Food> getAll(int restaurantId);
}
