package org.openchat.registration;

import org.openchat.common.exceptions.UserAlreadyExistsException;
import org.openchat.common.models.User;
import org.openchat.common.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterNewUserService {
    private UserRepository userRepository;

    public RegisterNewUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID registerNewUser(RegisterNewUserCommand command) {
        Optional<User> optionalUser = userRepository.find(command.getUsername());
        optionalUser.ifPresent(user -> { throw new UserAlreadyExistsException(); });
        return userRepository.registerUser(User.build(command));
    }
}
