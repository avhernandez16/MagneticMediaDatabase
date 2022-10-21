package magneticmedia.magneticmedia.controllers;

import magneticmedia.magneticmedia.dtos.RegisterUserDTO;
import magneticmedia.magneticmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<RegisterUserDTO> registerUser(@RequestBody RegisterUserDTO registerUserDTO){
        userService.registerUser(registerUserDTO);
        return ResponseEntity.ok().build();
    }
}
