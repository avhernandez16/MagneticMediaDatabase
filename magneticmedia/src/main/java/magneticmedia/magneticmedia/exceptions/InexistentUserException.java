package magneticmedia.magneticmedia.exceptions;

public class InexistentUserException extends RuntimeException {
    public InexistentUserException(String mssg) {
        super(mssg);
    }
}
