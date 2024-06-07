package object_orienters.techspot.api_gateway.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Username " + username + " Already Exists");
    }
}
