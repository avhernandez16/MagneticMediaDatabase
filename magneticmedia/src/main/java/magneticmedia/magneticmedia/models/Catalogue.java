package magneticmedia.magneticmedia.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import magneticmedia.magneticmedia.models.enums.Ciclo;
import magneticmedia.magneticmedia.models.enums.Programa;
import magneticmedia.magneticmedia.models.enums.Tecnologia;

import javax.persistence.*;

@Entity
@Table(name = "catalogues")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="catalogue_type",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Catalogue {

    @Id
    private String catalogueName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "server_id", referencedColumnName = "serverIpV4")
    private Server server;

    private Ciclo ciclo;
    private Tecnologia tecnologia;
    private Programa programa;

    private String consola;
}
