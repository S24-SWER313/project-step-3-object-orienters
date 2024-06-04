package object_orienters.techspot.contentservice.exceptions;

public class UserCannotFollowSelfException extends RuntimeException {
    public UserCannotFollowSelfException(String username) {
        super("Cannot follow this profile: " + username);
    }
}
