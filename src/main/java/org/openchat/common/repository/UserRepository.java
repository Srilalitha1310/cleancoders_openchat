package org.openchat.common.repository;

import org.openchat.common.models.User;
import org.openchat.registration.RegisterNewUserCommand;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository {

    public UUID registerUser(RegisterNewUserCommand command) {
        return null;
    }

    public User find(String username) {
        return null;
    }
}
