package tg.iai.ega.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.AccountType;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;
    LocalDate dateCreation;
    AccountType type;
    double balance;
    LocalDate creationDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    List<Operation> operations;
    @OneToMany(mappedBy = "source",cascade =CascadeType.ALL )
    List<Transfer> transfers;
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumber(String number) {
        this.number=number;
    }
}
