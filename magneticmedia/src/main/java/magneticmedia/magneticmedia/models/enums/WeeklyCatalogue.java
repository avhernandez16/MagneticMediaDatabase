package magneticmedia.magneticmedia.models.enums;

import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.MonthWeekNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class WeeklyCatalogue extends Catalogue {

    private MonthWeekNumber nroSemanaDelMes;
}
