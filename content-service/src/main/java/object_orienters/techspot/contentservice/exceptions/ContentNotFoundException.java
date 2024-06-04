package object_orienters.techspot.contentservice.exceptions;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(Long contentId) {
        super("Content not found with ID: " + contentId);
    }
}
