package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.LogInUserDto;
import magneticmedia.magneticmedia.dtos.RegisterUserDto;
import magneticmedia.magneticmedia.dtos.responseDto.TokenResponseDto;
import magneticmedia.magneticmedia.dtos.UpdateUserDto;
import magneticmedia.magneticmedia.exceptions.InexistentUserException;
import magneticmedia.magneticmedia.exceptions.LogInException;
import magneticmedia.magneticmedia.exceptions.RegisterException;
import magneticmedia.magneticmedia.helpers.InternalJwtHelper;
import magneticmedia.magneticmedia.helpers.PasswordHashingHelper;
import magneticmedia.magneticmedia.models.User;
import magneticmedia.magneticmedia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordHashingHelper passwordHashingHelper;
    @Autowired
    private InternalJwtHelper internalJwtHelper;

    public void registerUser(RegisterUserDto registerUserDTO) {
        Optional<User> userWithUserNumber = userRepository.findById(registerUserDTO.getUserNumber());
        if(userWithUserNumber.isPresent()){
            throw new RegisterException("Ya existe un usuario en el sistema usando el numero de usuario brindado");
        }

        byte[] randomSalt = passwordHashingHelper.generateRandomSalt();
        String hashedPassword = passwordHashingHelper.hashPassword(registerUserDTO.getPassword(), randomSalt);
        registerUserDTO.setPassword(hashedPassword);

        User newUser = new User(registerUserDTO.getUserNumber(), registerUserDTO.getName(), registerUserDTO.getPassword(), registerUserDTO.getWantsAudit(), randomSalt);
        userRepository.save(newUser);
    }

    public TokenResponseDto loginUser(LogInUserDto logInUserDto) {
        try {
            Optional<User> optionalUserWithUserNumber = userRepository.findById(logInUserDto.getUserNumber());
            User userWithUserNumber = optionalUserWithUserNumber.orElseThrow(NullPointerException::new);

            String hashedPassword = passwordHashingHelper.hashPassword(logInUserDto.getPassword(), userWithUserNumber.getSalt());
            if(!userWithUserNumber.givenPasswordIsCorrect(hashedPassword)){
                throw new LogInException("Numero de usuario o contraseña incorrecto");
            }

            String token = internalJwtHelper.getTokenFor(userWithUserNumber.getUserNumber());
            return new TokenResponseDto(token);
        }catch (NullPointerException e) {
            throw new LogInException("Numero de usuario o contraseña incorrecto");
        }
    }

    public void updateUserData(String userNumber, UpdateUserDto updateUserDto) {
        Optional<User> userWithUserNumber = userRepository.findById(userNumber);
        if(userWithUserNumber.isEmpty()){
            throw new InexistentUserException("No existe un usuario cuyo número de usuario sea el brindado");
        }
        User userToUpdate = userWithUserNumber.get();
        userToUpdate.updateFields(updateUserDto);
        userRepository.save(userToUpdate);
    }
}
