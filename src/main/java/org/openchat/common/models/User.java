package org.openchat.common.models;

public class User {

    private final String id;
    private final String username;
    private final String about;
    private final String password;

    User(String id, String username, String password, String about) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.about = about;
    }
}
