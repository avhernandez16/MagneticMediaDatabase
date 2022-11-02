package magneticmedia.magneticmedia.dtos.errorDtos;

import magneticmedia.magneticmedia.dtos.errorDtos.ErrorResponseDto;

import java.util.Map;

public class ValidationErrorResponseDTO extends ErrorResponseDto<Map<String, String>> {
    public ValidationErrorResponseDTO(Map<String, String> errors) {
        super(errors);
    }
}
