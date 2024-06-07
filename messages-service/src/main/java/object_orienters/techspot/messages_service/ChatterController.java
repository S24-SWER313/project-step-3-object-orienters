package object_orienters.techspot.messages_service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ChatterController {

    @Autowired
    private ChatterService chatterService;

    // @Autowired
    // ContentServiceProxy proxy;

    @MessageMapping("/user.add")
    @SendTo("/user/public")
    public Chatter addChatter(@Payload Chatter chatter) {
        chatterService.saveChatter(chatter);
        return chatter;
    }

    @PostMapping("/chatter/add")
    public ResponseEntity<?> addChatter1(@RequestParam String name, @RequestParam String username,
            @RequestParam String status) {
        Chatter chatter = new Chatter(username, name, Status.valueOf(status));
        chatterService.saveChatter(chatter);
        return ResponseEntity.ok(chatter);
    }

    @MessageMapping("/user.disconnect")
    @SendTo("/user/public")
    public Chatter disconnectChatter(@Payload Chatter chatter) {
        chatterService.disconnectChatter(chatter);
        return chatter;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Chatter>> getConnectedChatters(@RequestParam String username) {
        System.out.println("ChatterController.getConnectedChatters username = " + username);
        return ResponseEntity.ok(chatterService.getConnectedChatters(username));
    }
}
