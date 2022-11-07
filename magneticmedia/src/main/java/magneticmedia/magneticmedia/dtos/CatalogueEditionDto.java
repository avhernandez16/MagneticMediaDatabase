package magneticmedia.magneticmedia.dtos;

import lombok.Getter;
import magneticmedia.magneticmedia.models.MonthWeekNumber;
import magneticmedia.magneticmedia.models.enums.Cycle;
import magneticmedia.magneticmedia.models.enums.Program;
import magneticmedia.magneticmedia.models.enums.Tecnology;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Valid
public class CatalogueEditionDto {
    @NotBlank(message = "Console field can't be empty or null in the boddy json")
    @Length(min = 4, max = 10, message = "console field should have between 4 and 10 characters length")
    private String console;
    @NotNull(message = "Cycle field can't be empty or null in the boddy json")
    private Cycle cycle;
    @NotNull(message = "Program field can't be empty or null in the boddy json")
    private Program program;
    @NotNull(message = "Tecnology field can't be empty or null in the boddy json")
    private Tecnology tecnology;
    @NotNull(message = "Week number of the Month field can't be empty or null in the boddy json")
    private MonthWeekNumber monthWeekNumber;
}
