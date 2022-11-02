package magneticmedia.magneticmedia.dtos.errorDtos;

import magneticmedia.magneticmedia.dtos.errorDtos.ErrorResponseDto;

public class GenericErrorResponseDto extends ErrorResponseDto<String> {
    public GenericErrorResponseDto(String mssg) {
        super(mssg);
    }
}
