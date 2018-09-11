package com.harmonic.web.controllers.food;

import com.harmonic.service.FoodService;
import com.harmonic.to.FoodTo;
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

}
