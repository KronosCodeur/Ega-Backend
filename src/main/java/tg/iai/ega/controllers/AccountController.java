package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.entities.Account;
import tg.iai.ega.entities.Client;
import tg.iai.ega.services.AccountService;
import tg.iai.ega.services.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    public List<Account> showAllAccounts(){
        return accountService.showAllAccounts();
    }
    @PostMapping("/accounts")
    public Account getOneAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }
    @GetMapping("/accounts/{id}")
    public Account getOneAccount(@PathVariable Long id){
        return accountService.getOneAccount(id);
    }
    @PutMapping("/accounts/{id}")
    public Account updateClient(@RequestBody Account account, @PathVariable Long id){
        account.setId(id);
        return accountService.saveAccount(account);
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
    @GetMapping("/accounts/{number}")
    public Account getAccountByNumber(@PathVariable String number){
        return accountService.getAccountByNumber(number);
    }
}
