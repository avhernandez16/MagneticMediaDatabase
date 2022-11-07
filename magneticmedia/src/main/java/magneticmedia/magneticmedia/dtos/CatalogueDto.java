package magneticmedia.magneticmedia.dtos;

import lombok.Getter;
import lombok.Setter;
import magneticmedia.magneticmedia.models.MonthWeekNumber;
import magneticmedia.magneticmedia.models.enums.Cycle;
import magneticmedia.magneticmedia.models.enums.Program;
import magneticmedia.magneticmedia.models.enums.Tecnology;
import magneticmedia.magneticmedia.security.ValidateIpAddress;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@Valid
public class CatalogueDto {

    @NotBlank(message = "Server IP field can't be empty or null in the boddy json")
    @ValidateIpAddress
    private String serverIpV4;
    @NotBlank(message = "Server Name field can't be empty or null in the boddy json")
    @Length (min = 4, max = 30, message = "Server name should have between 4 and 30 characters length")
    private String serverName;
    @NotBlank(message = "Catalogue name field can't be empty or null in the boddy json")
    @Length(min = 4, max = 30, message = "Catalog name should have between 4 and 30 characters length")
    private String catalogueName;
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
