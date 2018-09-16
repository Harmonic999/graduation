package com.harmonic.repository;

import com.harmonic.model.VotesAccountant;

import java.util.List;

public interface VotesAccountantRepository {

    VotesAccountant get(int id);

    VotesAccountant save(VotesAccountant accountant);

    boolean delete(int id);

    List<VotesAccountant> getAll();
}
