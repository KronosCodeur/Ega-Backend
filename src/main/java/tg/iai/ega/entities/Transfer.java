package tg.iai.ega.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "destination")
    @JsonIgnore
    private Account destination;
    @ManyToOne
    @JoinColumn(name = "source")
    @JsonIgnore
    private Account source;
    private float amount;
    private LocalDateTime makedAt;
}
