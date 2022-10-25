package magneticmedia.magneticmedia.dtos;

import java.util.Map;

public class ValidationErrorResponseDTO extends ErrorResponseDto<Map<String, String>> {
    public ValidationErrorResponseDTO(Map<String, String> errors) {
        super(errors);
    }
}
