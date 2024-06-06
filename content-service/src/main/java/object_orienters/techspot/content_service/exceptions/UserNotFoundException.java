package object_orienters.techspot.content_service.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User With Username: " + username + " Could Not Be Found.");
    }
}
