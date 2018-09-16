package com.harmonic.web.controllers;

import com.harmonic.AuthorizedUser;
import com.harmonic.to.UserTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController extends AbstractUserController {

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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", true);
        model.addAttribute("userTo", new UserTo());
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(UserTo user, BindingResult result) {
        super.saveNewUser(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal AuthorizedUser authUser) {
        model.addAttribute("userTo", authUser.getUserTo());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(UserTo userTo, BindingResult result, @AuthenticationPrincipal AuthorizedUser authUser) {
        super.updateUser(userTo, authUser.getId());
        authUser.update(userTo);
        return "redirect:/restaurants";
    }

}
