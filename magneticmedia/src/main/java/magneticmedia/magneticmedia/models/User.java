package magneticmedia.magneticmedia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private String userNumber;

    private String name;
    private String password;
    private Boolean wantsAudit;
}
