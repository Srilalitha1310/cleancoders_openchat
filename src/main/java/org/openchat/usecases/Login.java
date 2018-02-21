package org.openchat.usecases;

import org.openchat.entities.User;

public class Login {
  public boolean validate(String username, String password) {
    User user = UseCaseContext.repository.getUser(username);
    return user != null && user.password.equals(password);
  }
}