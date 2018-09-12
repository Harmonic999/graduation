package com.harmonic.web.controllers.food;

import com.harmonic.to.FoodTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/menu")
public class FoodAjaxController extends AbstractFoodController {

    @Override
    @GetMapping("/{restaurantId}")
    public List<FoodTo> getAll(@PathVariable int restaurantId) {
        return super.getAll(restaurantId);
    }

    @Override
    @GetMapping("/{restaurantId}/{id}")
    public FoodTo get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @PostMapping("/{restaurantId}")
    public void createOrUpdateFood(FoodTo foodTo, @PathVariable int restaurantId) {
        super.createOrUpdateFood(foodTo, restaurantId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id) {
        super.deleteFood(id);
    }
}
