package magneticmedia.magneticmedia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import magneticmedia.magneticmedia.dtos.RegisterUserDto;
import magneticmedia.magneticmedia.dtos.UpdateUserDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //constructor sin argumentos necesario para que springJPA pueda trabajar
public class User {

    @Id
    private String userNumber;

    private String name;
    private String password;
    private Boolean wantsAudit;
    private byte[] salt;

    public Boolean givenPasswordIsCorrect(String password){
        return this.password.equals(password);
    }

    public void updateFields(UpdateUserDto updateUserDto) {
        this.name = updateUserDto.getName();
        this.password = updateUserDto.getPassword();
        this.wantsAudit = updateUserDto.getWantsAudit();
    }
}
