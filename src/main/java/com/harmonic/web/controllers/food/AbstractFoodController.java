package com.harmonic.web.controllers.food;

import com.harmonic.service.FoodService;
import com.harmonic.to.FoodTo;
import com.harmonic.util.FoodUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.harmonic.util.FoodUtil.asTo;

public abstract class AbstractFoodController {

    @Autowired
    private FoodService foodService;

    public List<FoodTo> getAll(int id) {
        return asTo(foodService.getAll(id));
    }

    public FoodTo get(int id) {
        return asTo(foodService.get(id));
    }

    public void createOrUpdateFood(FoodTo foodTo, int restaurantId) {
        foodService.save(FoodUtil.createFromTo(foodTo), restaurantId);
    }

    public void deleteFood(int id) {
        foodService.delete(id);
    }

}
