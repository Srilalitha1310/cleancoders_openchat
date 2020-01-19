package org.openchat.registration;

import org.junit.jupiter.api.Test;
import org.openchat.common.exceptions.FourHundredException;
import org.openchat.common.models.User;
import org.openchat.common.repository.UserRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegisterNewUserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private RegisterNewUserService registerNewUserService = new RegisterNewUserService(userRepository);

    @Test
    void shouldRegisterTheGivenUser() {
        String idOfNewUser = "550e8400-e29b-41d4-a716-446655440000";
        RegisterNewUserCommand command = new RegisterNewUserCommand("john", "password", "about john");
        when(userRepository.find(command.getUsername())).thenReturn(null);
        when(userRepository.registerUser(command)).thenReturn(UUID.fromString(idOfNewUser));

        UUID actual = registerNewUserService.registerNewUser(command);

        assertThat(actual.toString()).isEqualTo(idOfNewUser);
    }

    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() throws Exception{
        String idOfNewUser = "550e8400-e29b-41d4-a716-446655440000";
        RegisterNewUserCommand command = new RegisterNewUserCommand("john", "password", "about john");
        User user = mock(User.class);
        when(userRepository.find(command.getUsername())).thenReturn(user);
        when(userRepository.registerUser(command)).thenReturn(UUID.fromString(idOfNewUser));

        assertThrows(FourHundredException.class, () -> registerNewUserService.registerNewUser(command));
    }
}
