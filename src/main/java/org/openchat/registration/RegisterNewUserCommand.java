package org.openchat.registration;

public class RegisterNewUserCommand {
    private String username;
    private String password;
    private String about;

    public RegisterNewUserCommand(String username, String password, String about) {
        this.username = username;
        this.password = password;
        this.about = about;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAbout() {
        return about;
    }
}
