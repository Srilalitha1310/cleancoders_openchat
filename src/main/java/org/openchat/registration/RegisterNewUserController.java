package org.openchat.registration;

import org.openchat.common.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterNewUserController {

    private RegisterNewUserService registerNewUserService;

    public RegisterNewUserController(RegisterNewUserService registerNewUserService) {
        this.registerNewUserService = registerNewUserService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler({ UserAlreadyExistsException.class })
    public RegisterNewUserResponse registerNewUser(@RequestBody RegisterNewUserCommand command) {
            String id = registerNewUserService.registerNewUser(command).toString();
            return (new RegisterNewUserResponse(id, command.getUsername(), command.getAbout()));
    }
}
