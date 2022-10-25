package magneticmedia.magneticmedia.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Valid
public class LogInUserDto {

    @NotBlank(message = "User Number field can't be null or empty in the body json")
    private String userNumber;
    @NotBlank(message = "Password field can't be null or empty in the body json")
    private String password;
}
