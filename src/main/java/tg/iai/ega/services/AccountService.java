package tg.iai.ega.services;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.iai.ega.dto.AccountDto;
import tg.iai.ega.entities.Account;
import tg.iai.ega.entities.Client;
import tg.iai.ega.entities.Operation;
import tg.iai.ega.entities.Transfer;
import tg.iai.ega.enums.OperationType;
import tg.iai.ega.repositories.AccountRepository;
import tg.iai.ega.repositories.ClientRepository;
import tg.iai.ega.repositories.OperationRepository;
import tg.iai.ega.repositories.TransferRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AccountService implements  IAccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Override
    public List<Account> showAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account saveAccount(AccountDto accountDto) {
        String number = Iban.random(CountryCode.FR).toString();
        Account account = new Account();
        account.setNumber(number);
        account.setType(accountDto.getType());
        Client client = clientRepository.getById(accountDto.getClientId());
        account.setClient(client);
        account.setBalance(0);
        account.setDateCreation(LocalDate.now());
        return accountRepository.save(account);
    }

    @Override
    public Account getOneAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account getAccountByNumber(String number) {
        return accountRepository.findAccountByNumber(number);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    public boolean makeDeposit(String accountNumber, float amount) {

        Account account = accountRepository.findAccountByNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            Operation operation = new Operation();
            operation.setAccount(account);
            operation.setMakedAt(LocalDateTime.now());
            operation.setType(OperationType.DEPOT);
            operation.setAmount(amount);
            operationRepository.save(operation);
            accountRepository.save(account);
            return  true;
        }
        return  false;
    }

    public void makeWithdrawal(String accountNumber, float amount) {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            Operation operation = new Operation();
            operation.setAccount(account);
            operation.setMakedAt(LocalDateTime.now());
            operation.setType(OperationType.RETRAIT);
            operation.setAmount(amount);
            operationRepository.save(operation);
            accountRepository.save(account);
        }
    }

    public void makeTransfer(String sourceAccountNumber, String destinationAccountNumber, float amount) {
        Account sourceAccount = accountRepository.findAccountByNumber(sourceAccountNumber);
        Account destinationAccount = accountRepository.findAccountByNumber(destinationAccountNumber);

        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            Transfer transfer = new Transfer();
            transfer.setMakedAt(LocalDateTime.now());
            transfer.setDestination(destinationAccount);
            transfer.setSource(sourceAccount);
            transfer.setAmount(amount);
            transferRepository.save(transfer);
            accountRepository.save(sourceAccount);
            accountRepository.save(destinationAccount);
        }
    }
}
