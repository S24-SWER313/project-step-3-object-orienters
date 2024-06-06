package object_orienters.techspot.content_service.exceptions;

public class CommentNotFoundException extends Exception{

    public CommentNotFoundException(long commentId) {
        super("Comment with id " + commentId + " not found");
    }
}
