package object_orienters.techspot.security_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthDto {

    private Provider provider;
    private String id;
    private String username;

    public String toString() {
        return "OAuthDto(id=" + this.getId() + ", username=" + this.getUsername() + ", provider=" + this.getProvider() +")";
    }
}
