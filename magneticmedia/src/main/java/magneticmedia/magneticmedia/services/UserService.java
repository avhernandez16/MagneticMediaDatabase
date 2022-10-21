package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.RegisterUserDTO;
import magneticmedia.magneticmedia.models.User;
import magneticmedia.magneticmedia.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public void registerUser(RegisterUserDTO registerUserDTO) {
        User newUser = modelMapper.map(registerUserDTO, User.class);
        userRepository.save(newUser);
    }
}
