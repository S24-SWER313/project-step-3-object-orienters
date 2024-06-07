package object_orienters.techspot.api_gateway.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import object_orienters.techspot.api_gateway.security.model.RefreshToken;
import object_orienters.techspot.api_gateway.security.model.User;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUser(User user);

    int deleteByUser(User user);
}
