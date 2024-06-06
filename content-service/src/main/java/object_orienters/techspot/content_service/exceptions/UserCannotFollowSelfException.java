package object_orienters.techspot.content_service.exceptions;

public class UserCannotFollowSelfException extends RuntimeException {
    public UserCannotFollowSelfException(String username) {
        super("Cannot follow this profile: " + username);
    }
}
