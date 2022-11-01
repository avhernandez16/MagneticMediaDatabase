package magneticmedia.magneticmedia.dtos;

import lombok.Getter;

@Getter
public class ErrorResponseDto<T> {

    private T message;

    public ErrorResponseDto(T message){
        this.message = message;
    }
}
