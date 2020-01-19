package org.openchat.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterNewUserController {

    RegisterNewUserService registerNewUserService;

    public RegisterNewUserController(RegisterNewUserService registerNewUserService) {
        this.registerNewUserService = registerNewUserService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public RegisterNewUserResponse registerNewUser(@RequestBody RegisterNewUserCommand command) {
        return new RegisterNewUserResponse(registerNewUserService.registerNewUser(command).toString(),
                command.getUsername(),
                command.getAbout());
    }
}
