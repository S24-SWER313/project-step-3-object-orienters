package object_orienters.techspot.security_service.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Username " + username + " Already Exists");
    }
}
