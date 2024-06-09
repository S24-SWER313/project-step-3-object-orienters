package object_orienters.techspot.security_service.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import object_orienters.techspot.security_service.security.model.UserOAuthTemp;

@Repository
public interface UserOAuthTempRepository extends JpaRepository<UserOAuthTemp, String>{

}
