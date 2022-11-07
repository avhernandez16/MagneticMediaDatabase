package magneticmedia.magneticmedia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Server {
    
    @Id
    private String serverIpV4;
    @Column(unique = true)
    private String serverName;
}
