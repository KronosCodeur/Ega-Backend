package tg.iai.ega.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.OperationType;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
    float amount;
    OperationType type;
    LocalDateTime makedAt;
}