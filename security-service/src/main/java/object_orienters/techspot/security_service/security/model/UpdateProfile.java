package object_orienters.techspot.security_service.security.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateProfile {
    private LocalDate dob;
    private String name;
    private String about;
    private String profession;
    private Gender gender;
    private String password;

    enum Gender {
        MALE,
        FEMALE
    }
}
