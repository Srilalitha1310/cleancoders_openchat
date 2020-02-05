package org.openchat.common.repository;

import org.openchat.common.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    public HashMap<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<String, User>();
    }

    public UserRepository(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public Optional<User> find(String username) {
        return Optional.ofNullable(this.userMap.get(username));
    }

    public UUID registerUser(User user) {
        userMap.put(user.getUsername(), user);
        return UUID.fromString(user.getId());
    }
}
