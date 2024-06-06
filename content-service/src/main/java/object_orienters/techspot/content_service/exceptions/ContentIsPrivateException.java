package object_orienters.techspot.content_service.exceptions;

public class ContentIsPrivateException extends Exception {
    public ContentIsPrivateException() {
        super("Content is private");
    }
}
