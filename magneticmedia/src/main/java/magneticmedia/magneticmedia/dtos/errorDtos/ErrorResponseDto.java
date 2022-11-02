package magneticmedia.magneticmedia.dtos.errorDtos;

import lombok.Getter;

@Getter
public class ErrorResponseDto<T> {

    private T message;

    public ErrorResponseDto(T message){
        this.message = message;
    }
}
