package com.harmonic.service;

import com.harmonic.model.Restaurant;
import com.harmonic.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Restaurant get(int id) {
        return repository.get(id);
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}
