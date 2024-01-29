package tg.iai.ega.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.iai.ega.enums.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private AccountType type;
    private Long clientId;
}
