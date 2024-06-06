package object_orienters.techspot.content_service.profile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import object_orienters.techspot.content_service.content.Post;
import object_orienters.techspot.content_service.dataTypes.DataType;

@Entity
@Data
@NoArgsConstructor
@Table(name = "profile")
@Valid
public class Profile {
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

    @NotNull(message = "Name shouldn't be null.")
    @NotBlank(message = "Name cannot be left blank.")
    @Size(min = 3, max = 30, message = "Name size should be between 3 and 30 characters.")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_pic_datatype_id", referencedColumnName = "datatype_id", nullable = true)
    private DataType profilePic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "background_img_datatype_id", referencedColumnName = "datatype_id", nullable = true)
    private DataType backgroundImg;

    private String profession;

    private String about;

    private Gender gender;

    @Past(message = "Date of Birth should be in the past.")
    private LocalDate dob;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "followship", joinColumns = @JoinColumn(name = "follower_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    @JsonIgnore
    private Set<Profile> following;

    @ManyToMany(mappedBy = "following", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Profile> followers;

    @JsonIgnore
    @OneToMany(mappedBy = "contentAuthor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> publishedPosts;

    public String toString() {
        return "Username: " + getUsername() + " Name: " + getName() + " Profession: " + profession + " Email: "
                + getEmail();
    }

    public Set<Profile> getFollowing() {
        if (this.following == null) {
            this.following = new HashSet<>();
        }
        return following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Profile))
            return false;
        return getUsername() != null && getUsername().equals(((Profile) o).getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUsername());
    }

    public enum Gender {
        MALE,
        FEMALE
    }

}
