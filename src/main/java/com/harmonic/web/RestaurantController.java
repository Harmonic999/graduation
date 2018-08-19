package com.harmonic.web;


import com.harmonic.model.Restaurant;
import com.harmonic.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    public String restaurantList(Model model) {
        model.addAttribute("restaurantList", service.getAll());
        return "restaurantList";
    }

    @GetMapping("/create")
    public String restaurantsEditOrCreate(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurantForm";
    }

    @GetMapping("/edit/{id}")
    public String editRestaurant(HttpServletRequest request, @PathVariable int id) {
        Restaurant current = service.get(id);
        request.setAttribute("restaurant", current);
        return "restaurantForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable int id) {
        service.delete(id);
        return "redirect:/restaurants";
    }

    @PostMapping("/createOrUpdate")
    public String addOrEditRestaurant(HttpServletRequest request) {
        String name = request.getParameter("name");
        String stringId = request.getParameter("id");
        Restaurant restaurant = new Restaurant(name);

        if (stringId.length() != 0) {
            restaurant.setId(Integer.parseInt(stringId));
        }

        service.save(restaurant);
        return "redirect:/restaurants";
    }

}
