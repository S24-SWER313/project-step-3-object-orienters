package object_orienters.techspot.api_gateway.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Email " + email + " Already exists");
    }
}
