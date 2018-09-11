package com.harmonic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "";
    }

    @GetMapping("/restaurants")
    public String restaurantsPage() {
        return "restaurantList";
    }

    @GetMapping("/restaurants/{id}/menu")
    public String menuPage(@PathVariable("id") int id) {
        return "foodList";
    }

}
