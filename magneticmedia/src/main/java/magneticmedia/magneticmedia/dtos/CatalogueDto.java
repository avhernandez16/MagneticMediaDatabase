package magneticmedia.magneticmedia.dtos;

import lombok.Getter;
import lombok.Setter;
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
}
