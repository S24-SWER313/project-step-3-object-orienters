package object_orienters.techspot.messages_service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;

    public void setId(String id) {
        this.id = id;
    }
}
