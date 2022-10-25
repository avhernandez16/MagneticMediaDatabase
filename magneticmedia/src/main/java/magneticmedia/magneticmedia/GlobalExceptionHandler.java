package magneticmedia.magneticmedia;

import magneticmedia.magneticmedia.dtos.GenericErrorResponseDto;
import magneticmedia.magneticmedia.dtos.ValidationErrorResponseDTO;
import magneticmedia.magneticmedia.exceptions.LogInException;
import magneticmedia.magneticmedia.exceptions.RegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegisterException.class)
    public ResponseEntity<GenericErrorResponseDto> handleRegisterException(RegisterException registerException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericErrorResponseDto(registerException.getMessage()));
    }

    @ExceptionHandler(LogInException.class)
    public ResponseEntity<GenericErrorResponseDto> handleLogInException(LogInException logInException)  {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericErrorResponseDto(logInException.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GenericErrorResponseDto> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericErrorResponseDto(httpRequestMethodNotSupportedException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(400).body(new ValidationErrorResponseDTO(errors));
    }
}
