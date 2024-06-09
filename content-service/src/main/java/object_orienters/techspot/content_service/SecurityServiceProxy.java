package object_orienters.techspot.content_service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "security-service", url = "localhost:8082")
public interface SecurityServiceProxy {

    @GetMapping("/auth/verify")
    public ResponseEntity<Map<String, ?>> verifyUser();

}
