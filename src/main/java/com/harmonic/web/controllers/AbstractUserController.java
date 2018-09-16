package com.harmonic.web.controllers;

import com.harmonic.service.UserService;
import com.harmonic.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;

import static com.harmonic.util.UserUtil.*;

public abstract class AbstractUserController {

    @Autowired
    private UserService userService;

    void saveNewUser(UserTo userTo) {
        userService.save(createFromTo(userTo));
    }

    void updateUser(UserTo userTo, int authUserId) {
        checkId(userTo, authUserId);
        userService.save(createFromTo(userTo));
    }

}
