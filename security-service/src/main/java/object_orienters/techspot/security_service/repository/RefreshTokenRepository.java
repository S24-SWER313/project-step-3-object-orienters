package object_orienters.techspot.security_service.repository;

import object_orienters.techspot.security_service.model.RefreshToken;
import object_orienters.techspot.security_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUser(User user);

    int deleteByUser(User user);
}
