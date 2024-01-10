package tg.iai.ega.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @ManyToOne
    @JoinColumn(name = "destination")
    Account destination;
    @ManyToOne
    @JoinColumn(name = "source")
    Account source;
    float amount;
    LocalDateTime makedAt;
}
