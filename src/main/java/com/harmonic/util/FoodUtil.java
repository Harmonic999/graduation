package com.harmonic.util;

import com.harmonic.model.Food;
import com.harmonic.to.FoodTo;

import java.util.ArrayList;
import java.util.List;

public class FoodUtil {

    public static List<FoodTo> asTo(List<Food> list) {
        List<FoodTo> tos = new ArrayList<>();
        list.forEach(food -> tos.add(asTo(food)));
        return tos;
    }

    public static FoodTo asTo(Food food) {
        return new FoodTo(food.getId(), food.getDescription());
    }

    public static Food createFromTo(FoodTo foodTo) {
        return new Food(foodTo.getId(), foodTo.getDescription());
    }
}
