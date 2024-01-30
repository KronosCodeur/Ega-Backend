package tg.iai.ega.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.Gender;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    Long id;
    String firstName;
    String lastName;
    String phone;
    String email;
    LocalDate birthday;
    String address;
    Gender gender;
    String token;
}