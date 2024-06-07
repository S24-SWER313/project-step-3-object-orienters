package object_orienters.techspot.api_gateway.security.blacklist;

import org.springframework.stereotype.Service;

@Service
public interface TokenBlackListService {

    void blacklistToken(String token);

    boolean isTokenBlacklisted(String token);
}
