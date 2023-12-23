package tg.iai.ega.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.AccountType;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;
    Date dateCreation;
    AccountType type;
    double balance;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
}
