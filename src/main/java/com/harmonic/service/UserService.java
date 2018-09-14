package com.harmonic.service;

import com.harmonic.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();
}
