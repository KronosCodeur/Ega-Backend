package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.dto.AccountDto;
import tg.iai.ega.dto.AccountOutputDto;
import tg.iai.ega.dto.TransactionResponse;
import tg.iai.ega.entities.Account;
import tg.iai.ega.services.AccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ega/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")

    public List<AccountOutputDto> showAllAccounts(){
        var accounts = accountService.showAllAccounts();
        List<AccountOutputDto> accountOutputDtoList = new ArrayList<>();
        for (var account : accounts) {
            accountOutputDtoList.add(new AccountOutputDto().entityToDto(account));
        }
        return  accountOutputDtoList;
    }
    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody AccountDto account){
        return accountService.saveAccount(account);
    }
    @GetMapping("/accounts/{id}")
    public AccountOutputDto getOneAccount(@PathVariable Long id){
        return new AccountOutputDto().entityToDto(accountService.getOneAccount(id));
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
    @PostMapping("/accounts/getAccountByNumber")
    public AccountOutputDto getAccountByNumber(@RequestParam String number){
        return new AccountOutputDto().entityToDto(accountService.getAccountByNumber(number));
    }
    @GetMapping("/deposit")
    public TransactionResponse makeDeposit(@RequestParam String number, @RequestParam float amount) {
        accountService.makeDeposit(number, amount);
        return TransactionResponse.builder().success(true).message("Depot effectuer avec success").build();
    }

    @GetMapping("/withdrawal")
    public TransactionResponse makeWithdrawal(@RequestParam String number, @RequestParam float amount) {
        boolean result = accountService.makeWithdrawal(number, amount);
        return TransactionResponse.builder().message(result?"Retrait effectué avec succès.":"Solde insuffissant").success(result).build();
    }

    @GetMapping("/transfer")
    public TransactionResponse makeTransfer(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam float amount) {
        var result = accountService.makeTransfer(source, destination, amount);
        return TransactionResponse.builder().message(result?"Virement effectué avec succès.":"Solde insuffissant").success(result).build();
    }
}
