package tg.iai.ega.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.Gender;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String phone;
    String email;
    Date birthday;
    String address;
    Gender gender;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    List<Account> accounts;
}
