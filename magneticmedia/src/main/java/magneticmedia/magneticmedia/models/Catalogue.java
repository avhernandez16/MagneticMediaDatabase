package magneticmedia.magneticmedia.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import magneticmedia.magneticmedia.models.enums.Cycle;
import magneticmedia.magneticmedia.models.enums.Program;
import magneticmedia.magneticmedia.models.enums.Tecnology;

import javax.persistence.*;

@Entity
@Table(name = "catalogues")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="catalogue_type",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Catalogue {

    @Id
    private String catalogueName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "server_id", referencedColumnName = "serverIpV4")
    private Server server;

    private Cycle cycle;
    private Tecnology tecnology;
    private Program program;

    private String console;
}
