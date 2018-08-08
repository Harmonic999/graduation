package com.harmonic.web;

import com.harmonic.model.Food;
import com.harmonic.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FoodController {

    private FoodRepository repository;

    @Autowired
    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/foodList")
    public String listFood(Model model) {
        model.addAttribute("mealList", repository.getAll());
        return "foodList";
    }

    @GetMapping("/foodList/vote_for/{id}")
    public String handleVoteFor(@PathVariable int id) {
        Food current = repository.get(id).plusVote();
        repository.save(current);
        return "redirect:/foodList";
    }

    @GetMapping("/foodList/vote_against/{id}")
    public String handleVoteAgainst(@PathVariable int id) {
        Food current = repository.get(id).minusVote();
        repository.save(current);
        return "redirect:/foodList";
    }
}
