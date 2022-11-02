package magneticmedia.magneticmedia.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "catalogues")
@AllArgsConstructor
@NoArgsConstructor
public class Catalogue {

    @EmbeddedId
    private CatalogueId catalogueId;
    private Ciclo ciclo;
}
