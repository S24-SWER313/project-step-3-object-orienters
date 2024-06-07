package object_orienters.techspot.api_gateway.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import object_orienters.techspot.api_gateway.security.model.UserOAuthTemp;

@Repository
public interface UserOAuthTempRepository extends JpaRepository<UserOAuthTemp, String>{

}
