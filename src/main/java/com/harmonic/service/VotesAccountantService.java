package com.harmonic.service;

import com.harmonic.model.VotesAccountant;

import java.util.List;

public interface VotesAccountantService {

    void handleUserVote(int userId, int restaurantId);

    List<VotesAccountant> getAll();

}
