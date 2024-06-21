package object_orienters.techspot.messages_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

//", url="localhost:8080
@FeignClient(name="content-service")
public interface ContentServiceProxy {

    @GetMapping("/profiles/{username}/followers")
    public ResponseEntity<?> Followers(@PathVariable String username, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);

    @GetMapping("/profiles/{username}/following")
    public ResponseEntity<?> Following(@PathVariable String username, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
}
