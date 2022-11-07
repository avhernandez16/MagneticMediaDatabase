package magneticmedia.magneticmedia.models.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.MonthWeekNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class WeeklyCatalogue extends Catalogue {

    private MonthWeekNumber monthWeekNumber;
}
