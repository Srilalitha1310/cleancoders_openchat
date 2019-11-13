package org.openchat.registration;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterNewUserControllerTest {

    private RegisterNewUserService service = mock(RegisterNewUserService.class);
    private RegisterNewUserController controller = new RegisterNewUserController(service);

    @Test void
    register_a_new_user() throws Exception {
        String idOfNewUser = "550e8400-e29b-41d4-a716-446655440000";
        RegisterNewUserCommand command = new RegisterNewUserCommand("john", "password", "about john");
        when(service.registerNewUser(command)).thenReturn(UUID.fromString(idOfNewUser));

        RegisterNewUserResponse response = controller.registerNewUser(command);

        assertThat(response.getId()).isEqualTo(idOfNewUser);
        assertThat(response.getUsername()).isEqualTo("john");
        assertThat(response.getAbout()).isEqualTo("about john");
    }
}
