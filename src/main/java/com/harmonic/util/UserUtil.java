package com.harmonic.util;

import com.harmonic.model.Role;
import com.harmonic.model.User;
import com.harmonic.to.UserTo;
import com.harmonic.util.exception.IllegalRequestDataException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

public class UserUtil {

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.isEmpty(password) ? password : passwordEncoder.encode(password));
        user.setEmail(user.getEmail().trim().toLowerCase());
        return user;
    }

    public static User createFromTo(UserTo userTo) {
        return new User(userTo.getId(), userTo.getName(), userTo.getEmail(), userTo.getPassword(), Role.ROLE_USER);
    }

    public static void checkId(UserTo userTo, int authUserId) {
        if (userTo.getId() == null) {
            userTo.setId(authUserId);
        } else if (userTo.getId() != authUserId) {
            throw new IllegalRequestDataException(userTo + " must be with id=" + authUserId);
        }
    }
}
