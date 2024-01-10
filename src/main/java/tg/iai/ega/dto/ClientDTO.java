package tg.iai.ega.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.entities.Account;
import tg.iai.ega.entities.Client;
import tg.iai.ega.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    Long id;
    String firstName;
    String lastName;
    String phone;
    String email;
    LocalDate birthday;
    String address;
    String password;
    Gender gender;
    @JsonIgnore
    private List<Account> accounts;
    public static Client toEntity(ClientDTO clientDTO){
        if(clientDTO==null){
            return  null;
        }
        Client client = new  Client();
        client.setId(clientDTO.getId());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());
        client.setBirthday(clientDTO.getBirthday());
        client.setPassword(clientDTO.getPassword());
        client.setGender(clientDTO.getGender());
        client.setPhone(clientDTO.getPhone());
        return  client;
    }
}
