package magneticmedia.magneticmedia.dtos;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Valid
public class RegisterUserDTO {

    @NotBlank(message = "User Number field can't be null or empty in the body json")
    @Length(min = 8, max = 8, message = "User Number should have 8 characters length")
    @Pattern(regexp = "^[A-Z0-9]*$", message = "User Number should have only numbers and uppercase letters")
    private String userNumber;
    @NotBlank(message = "Name field can't be null or empty in the body json")
    @Length(min = 4, max = 20, message = "Name should have between 4 and 20 characters length")
    private String name;
    @NotBlank(message = "Password field can't be null or empty in the body json")
    @Length(min = 8, message = "Password should have at least 8 characters length")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$", message = "Password should has at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    private Boolean wantsAudit;
}
