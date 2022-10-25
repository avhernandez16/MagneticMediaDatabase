package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.RegisterUserDTO;
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

    public void registerUser(RegisterUserDTO registerUserDTO) {
        Optional<User> userWithUserNumber = userRepository.findById(registerUserDTO.getUserNumber());
        if(userWithUserNumber.isPresent()){
            throw new RegisterException("ya existe un usuario en el sistema usando el numero de usuario brindado");
        }

        User newUser = modelMapper.map(registerUserDTO, User.class);
        userRepository.save(newUser);
    }
}
