package object_orienters.techspot.security_service;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import object_orienters.techspot.security_service.security.model.UpdateProfile;
import object_orienters.techspot.security_service.security.payload.request.SignupRequest;

@FeignClient(name = "content-service", url = "localhost:8080")
public interface ContentServiceProxy {

    @PostMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProf(@RequestBody SignupRequest request) throws IOException;

    @DeleteMapping("/profiles/{username}")
    public ResponseEntity<?> deleteProfile(@PathVariable String username);

    @PutMapping("/profiles/{username}")
    // @PreAuthorize("#username == authentication.principal.username")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UpdateProfile newUser, @PathVariable String username);
}