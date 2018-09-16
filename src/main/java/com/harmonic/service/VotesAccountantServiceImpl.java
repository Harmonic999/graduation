package com.harmonic.service;

import com.harmonic.model.VotesAccountant;
import com.harmonic.repository.VotesAccountantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesAccountantServiceImpl implements VotesAccountantService {

    private final VotesAccountantRepository repository;

    @Autowired
    public VotesAccountantServiceImpl(VotesAccountantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleUserVote(int userId, int restaurantId) {
        repository.save(new VotesAccountant(userId, restaurantId));
    }

    @Override
    public List<VotesAccountant> getAll() {
        return repository.getAll();
    }
}
