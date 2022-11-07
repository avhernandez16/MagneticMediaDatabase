package magneticmedia.magneticmedia.models.enums;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.MonthWeekNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@SuperBuilder
@NoArgsConstructor
public class WeeklyCatalogue extends Catalogue {

    private MonthWeekNumber monthWeekNumber;
}
