package com.harmonic;

import com.harmonic.model.User;
import com.harmonic.to.UserTo;

import static com.harmonic.util.UserUtil.*;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getName(), user.getPassword(), true, true, true, true, user.getRoles());
        this.userTo = asTo(user);
    }

    public int getId() {
        return userTo.getId();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }

}
