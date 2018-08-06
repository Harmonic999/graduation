package com.harmonic.repository;

import com.harmonic.model.Food;

import java.util.List;

public interface FoodRepository {

    // null if updated meal do not belong to userId
    Food save(Food food);

    // false if meal do not belong to userId
    boolean delete(int id);

    // null if meal do not belong to userId
    Food get(int id);

    // ORDERED dateTime desc
    List<Food> getAll();
}
