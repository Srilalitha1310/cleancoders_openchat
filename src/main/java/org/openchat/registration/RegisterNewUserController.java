package org.openchat.registration;

import org.openchat.common.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterNewUserController {

    private RegisterNewUserService registerNewUserService;

    public RegisterNewUserController(RegisterNewUserService registerNewUserService) {
        this.registerNewUserService = registerNewUserService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ UserAlreadyExistsException.class })
    public ResponseEntity<RegisterNewUserResponse> registerNewUser(@RequestBody RegisterNewUserCommand command) {
            String id = registerNewUserService.registerNewUser(command).toString();
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new RegisterNewUserResponse(id, command.getUsername(), command.getAbout()));
    }
}
