package magneticmedia.magneticmedia.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {

    private String userNumber;
    private String name;
    private String password;
    private Boolean wantsAudit;
}
