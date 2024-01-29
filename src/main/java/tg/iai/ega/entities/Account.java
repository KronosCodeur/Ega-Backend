package tg.iai.ega.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tg.iai.ega.enums.AccountType;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private  LocalDate dateCreation;
    private AccountType type;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Operation> operations;
    @OneToMany(mappedBy = "source",cascade =CascadeType.ALL )
    private List<Transfer> transfers;

}
