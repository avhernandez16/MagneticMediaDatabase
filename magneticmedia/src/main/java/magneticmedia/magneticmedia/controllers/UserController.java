package magneticmedia.magneticmedia.controllers;

import magneticmedia.magneticmedia.dtos.LogInUserDto;
import magneticmedia.magneticmedia.dtos.RegisterUserDto;
import magneticmedia.magneticmedia.dtos.UpdateUserDto;
import magneticmedia.magneticmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<RegisterUserDto> registerUser(@Valid @RequestBody RegisterUserDto registerUserDTO){
        userService.registerUser(registerUserDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/login")
    public ResponseEntity<LogInUserDto> registerUser(@Valid @RequestBody LogInUserDto logInUserDto){
        userService.loginUser(logInUserDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{userNumber}/edit")
    public ResponseEntity<RegisterUserDto> updateUserData(@PathVariable String userNumber, @Valid @RequestBody UpdateUserDto updateUserDto){
        userService.updateUserData(userNumber, updateUserDto);
        return ResponseEntity.ok().build();
    }
}
