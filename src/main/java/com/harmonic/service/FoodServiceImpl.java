package com.harmonic.service;

import com.harmonic.model.Food;
import com.harmonic.repository.FoodRepository;
import com.harmonic.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repository;

    @Autowired
    public FoodServiceImpl(FoodRepository repository) {
        this.repository = repository;
    }

    public Food save(Food food, int restaurantId) {
        return repository.save(food, restaurantId);
    }

    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public Food get(int id) {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    public List<Food> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }
}
