package com.harmonic.web.controllers.food;

import com.harmonic.to.FoodTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
