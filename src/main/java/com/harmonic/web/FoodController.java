package com.harmonic.web;

import com.harmonic.model.Food;
import com.harmonic.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restaurants/{name}/{restId}/menu")
public class FoodController {

    private FoodService service;

    @Autowired
    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping()
    public String listFood(Model model, @PathVariable int restId, @PathVariable String name) {
        model.addAttribute("mealList", service.getAll(restId));
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", restId);
        return "foodList";
    }

    @GetMapping("/delete/{foodId}")
    public String deleteFood(@PathVariable String name, @PathVariable int restId, @PathVariable int foodId) {
        service.delete(foodId);
        return "redirect:/restaurants/" + name + "/" + restId + "/" + "menu";
    }

    @GetMapping("/edit/{foodId}")
    public String editFood(Model model, @PathVariable String name, @PathVariable int restId, @PathVariable int foodId) {
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", restId);
        model.addAttribute("food", service.get(foodId));
        return "foodForm";
    }

    @GetMapping("/create")
    public String createFood(Model model, @PathVariable String name, @PathVariable int restId) {
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", restId);
        model.addAttribute("food", new Food());
        return "foodForm";
    }

    @PostMapping("/create_or_edit_food")
    public String createOrEditFood(HttpServletRequest request, @PathVariable String name, @PathVariable int restId) {
        String description = request.getParameter("description");
        String foodId = request.getParameter("foodId");
        Food food = new Food(description);

        if (foodId.length() != 0) {
            food.setId(Integer.parseInt(foodId));
        }

        service.save(food, restId);
        return "redirect:/restaurants/" + name + "/" + restId + "/" + "menu";
    }
}
