package org.openchat.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterNewUserController {
    public RegisterNewUserController(RegisterNewUserService registerNewUserService) {

    }

    @PostMapping("/FIXME")
    @ResponseStatus(HttpStatus.OK)
    public RegisterNewUserResponse registerNewUser(@RequestBody RegisterNewUserCommand command) {
        return null;
    }
}
