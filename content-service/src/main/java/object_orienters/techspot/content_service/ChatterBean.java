package object_orienters.techspot.content_service;

public class ChatterBean {
    private String username;
    private String fullName;
    private Status status;


    public ChatterBean() {
    }
    
    public ChatterBean(String username, String fullName, Status status) {
        this.username = username;
        this.status = status;
        this.fullName = fullName;
    }


    public enum Status {
        ONLINE,
        OFFLINE
    }

}


