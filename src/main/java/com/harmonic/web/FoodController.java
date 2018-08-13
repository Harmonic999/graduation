package com.harmonic.web;

import com.harmonic.model.Food;
import com.harmonic.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FoodController {

    private FoodService service;

    @Autowired
    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping("/restaurants/{name}/{id}/menu")
    public String listFood(Model model, @PathVariable int id, @PathVariable String name) {
        model.addAttribute("mealList", service.getAll(id));
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", id);
        return "foodList";
    }

    @GetMapping("restaurants/{name}/{restId}/menu/delete/{foodId}")
    public String deleteFood(@PathVariable String name, @PathVariable int restId, @PathVariable int foodId) {
        service.delete(foodId);
        return "redirect:/restaurants/" + name + "/" + restId + "/" + "menu";
    }

    @GetMapping("restaurants/{name}/{restId}/menu/edit/{foodId}")
    public String editFood(Model model, @PathVariable String name, @PathVariable int restId, @PathVariable int foodId) {
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", restId);
        model.addAttribute("food", service.get(foodId));
        return "foodForm";
    }

    @GetMapping("restaurants/{name}/{restId}/menu/create/")
    public String createFood(Model model, @PathVariable String name, @PathVariable int restId) {
        model.addAttribute("restaurantName", name);
        model.addAttribute("restaurantId", restId);
        model.addAttribute("food", new Food());
        return "foodForm";
    }

    @PostMapping("restaurants/{restName}/{restId}/menu/create_or_edit_food")
    public String createOrEditFood(HttpServletRequest request, @PathVariable String restName, @PathVariable int restId) {
        String description = request.getParameter("description");
        String foodId = request.getParameter("foodId");
        Food food = new Food(description);

        if (foodId.length() != 0) {
            food.setId(Integer.parseInt(foodId));
        }

        service.save(food, restId);
        return "redirect:/restaurants/" + restName + "/" + restId + "/" + "menu";
    }
}
