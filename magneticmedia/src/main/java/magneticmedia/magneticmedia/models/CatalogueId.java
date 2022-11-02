package magneticmedia.magneticmedia.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueId implements Serializable {

    private String serverIpV4;
    private String serverName;
    private String catalogueName;
}
