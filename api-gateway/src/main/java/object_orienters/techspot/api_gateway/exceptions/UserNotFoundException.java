package object_orienters.techspot.api_gateway.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User With Username: " + username + " Could Not Be Found.");
    }
}
