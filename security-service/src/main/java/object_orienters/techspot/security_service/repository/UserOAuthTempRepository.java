package object_orienters.techspot.security_service.repository;

import object_orienters.techspot.security_service.model.UserOAuthTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOAuthTempRepository extends JpaRepository<UserOAuthTemp, String>{

}
