package object_orienters.techspot.content_service.exceptions;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(long postId) {
        super("Post With ID:" + postId + " Could Not Be Found.");
    }
}
