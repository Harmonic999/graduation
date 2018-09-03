package com.harmonic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "";
    }

    @GetMapping("/restaurants")
    public String restaurants() {
        return "restaurantList";
    }

}
