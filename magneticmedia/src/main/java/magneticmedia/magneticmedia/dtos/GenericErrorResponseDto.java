package magneticmedia.magneticmedia.dtos;

public class GenericErrorResponseDto extends ErrorResponseDto<String> {
    public GenericErrorResponseDto(String mssg) {
        super(mssg);
    }
}
