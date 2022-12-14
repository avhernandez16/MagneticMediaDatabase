package magneticmedia.magneticmedia;

import magneticmedia.magneticmedia.dtos.errorDtos.GenericErrorResponseDto;
import magneticmedia.magneticmedia.dtos.errorDtos.ValidationErrorResponseDTO;
import magneticmedia.magneticmedia.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(InexistentUserException.class)
    public ResponseEntity<GenericErrorResponseDto> handleInexistentUserException(InexistentUserException inexistentUserException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericErrorResponseDto(inexistentUserException.getMessage()));
    }

    @ExceptionHandler(CatalogueException.class)
    public ResponseEntity<GenericErrorResponseDto> handleCatalogueException(CatalogueException catalogueException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericErrorResponseDto(catalogueException.getMessage()));
    }

    @ExceptionHandler(InvalidJwtException.class)
    public ResponseEntity<GenericErrorResponseDto> handleInvalidJwtException(InvalidJwtException invalidJwtException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericErrorResponseDto(invalidJwtException.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GenericErrorResponseDto> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericErrorResponseDto(httpRequestMethodNotSupportedException.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GenericErrorResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericErrorResponseDto(httpMessageNotReadableException.getMessage().split(":")[0]));
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
