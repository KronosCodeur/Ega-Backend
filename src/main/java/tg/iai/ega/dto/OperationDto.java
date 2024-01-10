package tg.iai.ega.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.entities.Account;
import tg.iai.ega.entities.Operation;
import tg.iai.ega.enums.OperationType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDto {
    @JsonIgnore
    Long Id;
    @JsonIgnore
    Account account;
    String accountNumber;
    float amount;
    OperationType type;
    LocalDateTime makedAt;

    public static Operation toEntity(OperationDto operationDto) {
        if (operationDto == null) {
            return null;
        }
        Operation operation = new Operation();
        operation.setAccount(operationDto.getAccount());
        operation.setAmount(operationDto.getAmount());
        operation.setMakedAt(operationDto.getMakedAt());
        operation.setType(operationDto.getType());
        return operation;
    }
}
