package org.openchat.common.models;

import org.openchat.registration.RegisterNewUserCommand;

import java.util.UUID;

public class User {

    private String id;
    private String username;
    private String about;
    private String password;

    public User(String id, String username, String password, String about) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.about = about;
    }

    public static User build(RegisterNewUserCommand command) {
        return new User(UUID.randomUUID().toString(),
                command.getUsername(),
                command.getPassword(),
                command.getAbout());
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAbout() {
        return about;
    }

    public String getPassword() {
        return password;
    }
}
