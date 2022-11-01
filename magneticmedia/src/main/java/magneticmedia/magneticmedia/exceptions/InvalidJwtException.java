package magneticmedia.magneticmedia.exceptions;

public class InvalidJwtException extends RuntimeException {
    public InvalidJwtException() {
        super("You don't have permission to make this request");
    }
}
