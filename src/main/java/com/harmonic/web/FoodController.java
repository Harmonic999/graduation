package com.harmonic.web;

import com.harmonic.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    private FoodService service;

    @Autowired
    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping("/foodList")
    public String listFood(Model model) {
        //model.addAttribute("mealList", service.getAll());
        return "foodList";
    }
}
