package object_orienters.techspot.security_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
public class User  {

    @Id
    @NotBlank
    @NotNull(message = "Username shouldn't be null.")
    @Size(min = 4, max = 20, message = "Username size should be between 4 and 20 characters.")
    private String username;

    @NotNull(message = "Email shouldn't be null.")
    @Email
    @NotBlank
    @Size(max = 50)
    private String email;

    @Size(max = 120)
    private String password;

    private Timestamp lastLogin;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    private String providerId;

    public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
            @NotBlank @Size(max = 120) String password) {
        this.setUsername(username);
        this.setEmail(email);
        this.password = password;
        provider = Provider.LOCAL;
    }

    public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
           Provider provider, String providerId) {
        this.setUsername(username);
        this.setEmail(email);
        this.provider = provider;
        this.providerId = providerId;
    }

    public String toString() {
        return "User [email=" + getEmail() + ", password=" + password + ", username=" + getUsername() + "]";
    }

}
