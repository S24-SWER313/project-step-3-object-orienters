package object_orienters.techspot.contentservice.exceptions;

public class ContentIsPrivateException extends Exception {
    public ContentIsPrivateException() {
        super("Content is private");
    }
}
