package tg.iai.ega.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.Gender;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthday;
    private String address;
    private Gender gender;
    private String password;
    private String nationality;

}