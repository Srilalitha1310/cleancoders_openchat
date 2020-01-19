package org.openchat.registration;

import org.openchat.common.exceptions.FourHundredException;
import org.openchat.common.models.User;
import org.openchat.common.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class RegisterNewUserService {
    private UserRepository userRepository;

    public RegisterNewUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID registerNewUser(RegisterNewUserCommand command) {
        User user = userRepository.find(command.getUsername());
        if (!isNull(user)) {
            throw new FourHundredException(400, "Username already in use");
        }
        User newUser = User.build(command);
        return userRepository.registerUser(newUser);
    }
}
