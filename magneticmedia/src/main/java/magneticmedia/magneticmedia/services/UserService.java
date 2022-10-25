package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.LogInUserDto;
import magneticmedia.magneticmedia.dtos.RegisterUserDto;
import magneticmedia.magneticmedia.exceptions.LogInException;
import magneticmedia.magneticmedia.exceptions.RegisterException;
import magneticmedia.magneticmedia.models.User;
import magneticmedia.magneticmedia.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public void registerUser(RegisterUserDto registerUserDTO) {
        Optional<User> userWithUserNumber = userRepository.findById(registerUserDTO.getUserNumber());
        if(userWithUserNumber.isPresent()){
            throw new RegisterException("ya existe un usuario en el sistema usando el numero de usuario brindado");
        }

        User newUser = modelMapper.map(registerUserDTO, User.class);
        userRepository.save(newUser);
    }

    public void loginUser(LogInUserDto logInUserDto) {
        Optional<User> userWithUserNumber = userRepository.findById(logInUserDto.getUserNumber());
        if(userWithUserNumber.isEmpty() || !userWithUserNumber.get().givenPasswordIsCorrect(logInUserDto.getPassword())){
            throw new LogInException("numero de usuario o contraseña incorrecto");
        }
    }
}
