package tg.iai.ega.dto;

import lombok.*;
import tg.iai.ega.entities.Account;
import tg.iai.ega.entities.Operation;
import tg.iai.ega.entities.Transfer;
import tg.iai.ega.enums.AccountType;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountOutputDto {
    private Long id;
    private String number;
    private LocalDate dateCreation;
    private AccountType type;
    private double balance;
    private Long clientId;
    private List<Operation> operations;
    private List<Transfer> transfers;
    public AccountOutputDto entityToDto(Account account){
        AccountOutputDto accountOutputDto = new AccountOutputDto() ;
        accountOutputDto.id = account.getId();
        accountOutputDto.number = account.getNumber();
        accountOutputDto.dateCreation = account.getDateCreation();
        accountOutputDto.type = account.getType();
        accountOutputDto.balance = account.getBalance();
        accountOutputDto.clientId = account.getClient().getId();
        accountOutputDto.transfers = account.getTransfers();
        accountOutputDto.operations = account.getOperations();
        return  accountOutputDto;
    }
}
