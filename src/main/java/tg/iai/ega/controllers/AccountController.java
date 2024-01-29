package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.dto.AccountDto;
import tg.iai.ega.dto.AccountOutputDto;
import tg.iai.ega.entities.Account;
import tg.iai.ega.services.AccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
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
    @PostMapping("/deposit/{number}")
    public ResponseEntity<String> makeDeposit(@PathVariable String number, @RequestParam float amount) {
        accountService.makeDeposit(number, amount);
        return ResponseEntity.ok("Dépôt effectué avec succès.");
    }

    @PostMapping("/withdrawal/{number}")
    public ResponseEntity<String> makeWithdrawal(@PathVariable String number, @RequestParam float amount) {
        accountService.makeWithdrawal(number, amount);
        return ResponseEntity.ok("Retrait effectué avec succès.");
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> makeTransfer(
            @RequestParam String sourceNumber,
            @RequestParam String destinationNumber,
            @RequestParam float amount) {
        accountService.makeTransfer(sourceNumber, destinationNumber, amount);
        return ResponseEntity.ok("Virement effectué avec succès.");
    }
}
