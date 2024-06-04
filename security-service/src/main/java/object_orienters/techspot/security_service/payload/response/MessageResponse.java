package object_orienters.techspot.security_service.payload.response;

public class MessageResponse {
  private String messages_service;

  public MessageResponse(String messages_service) {
    this.messages_service = messages_service;
  }

  public String getMessage() {
    return messages_service;
  }

  public void setMessage(String messages_service) {
    this.messages_service = messages_service;
  }
}
