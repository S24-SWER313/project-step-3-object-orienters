package object_orienters.techspot.security_service.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import object_orienters.techspot.security_service.security.model.Provider;
import object_orienters.techspot.security_service.security.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Optional<User> findByProviderAndProviderId(Provider provider, String id);
}
