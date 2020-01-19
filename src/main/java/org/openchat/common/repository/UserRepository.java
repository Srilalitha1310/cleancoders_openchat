package org.openchat.common.repository;

import org.openchat.common.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepository {

    public Map userMap;

    public UserRepository() {
        this.userMap = new HashMap<String, User>();
    }

    public void setUserMap(Map userMap) {
        this.userMap = userMap;
    }

    public User find(String username) {
        return (User)this.userMap.get(username);
    }

    public UUID registerUser(User user) {
        userMap.put(user.getUsername(), user);
        return UUID.fromString(user.getId());
    }
}
