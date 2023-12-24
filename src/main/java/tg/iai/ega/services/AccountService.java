package tg.iai.ega.services;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.iai.ega.entities.Account;
import tg.iai.ega.repositories.AccountRepository;

import java.util.List;
@Service
public class AccountService implements  IAccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> showAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        String number = Iban.random(CountryCode.FR).toString();
        account.setNumber(number);
        return accountRepository.save(account);
    }

    @Override
    public Account getOneAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account getAccountByNumber(String number) {
        return accountRepository.getAccountByNumber(number);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
