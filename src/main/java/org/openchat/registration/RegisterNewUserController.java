package org.openchat.registration;

import org.openchat.common.models.ErrorResponse;
import org.openchat.common.exceptions.FourHundredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity registerNewUser(@RequestBody RegisterNewUserCommand command) {
        try {
            String id = registerNewUserService.registerNewUser(command).toString();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new RegisterNewUserResponse(id, command.getUsername(), command.getAbout()));
        }
        catch(FourHundredException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Username already in use"));
        }
    }
}
