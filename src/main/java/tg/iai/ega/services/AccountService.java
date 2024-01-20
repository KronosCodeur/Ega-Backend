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
    public void effectuerDepot(String numeroCompte, float montant) {
        Account account = accountRepository.getAccountByNumber(numeroCompte);
        if (account != null) {
            account.setBalance(account.getBalance() + montant);
            accountRepository.save(account);
        }
    }

    public void effectuerRetrait(String numeroCompte, float montant) {
        Account account = accountRepository.getAccountByNumber(numeroCompte);
        if (account != null && account.getBalance() >= montant) {
            account.setBalance(account.getBalance() - montant);
            accountRepository.save(account);
        }
    }

    public void effectuerVirement(String sourceNumero, String destinationNumero, float montant) {
        Account sourceAccount = accountRepository.getAccountByNumber(sourceNumero);
        Account destinationAccount = accountRepository.getAccountByNumber(destinationNumero);

        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= montant) {
            sourceAccount.setBalance(sourceAccount.getBalance() - montant);
            destinationAccount.setBalance(destinationAccount.getBalance() + montant);

            accountRepository.save(sourceAccount);
            accountRepository.save(destinationAccount);
        }
    }
}
