package object_orienters.techspot.content_service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//, url = "localhost:8082"
@FeignClient(name = "security-service")
public interface SecurityServiceProxy {

    @GetMapping(value = "/auth/verify")
    public ResponseEntity<Map<String, ?>> verifyUser();

}
