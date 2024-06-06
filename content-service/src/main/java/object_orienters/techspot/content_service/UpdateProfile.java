package object_orienters.techspot.content_service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateProfile {
    private LocalDate dob;
    private String name;
    private String about;
    private String profession;
    private Profile.Gender gender;
    private String password;
}
