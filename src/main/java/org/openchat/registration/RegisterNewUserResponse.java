package org.openchat.registration;

public class RegisterNewUserResponse {
    private String id;
    private String username;
    private String about;

    public RegisterNewUserResponse(String id, String username, String about) {
        this.id = id;
        this.username = username;
        this.about = about;
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
}
