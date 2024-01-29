package tg.iai.ega.services;


import tg.iai.ega.dto.AccountDto;
import tg.iai.ega.entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> showAllAccounts();
    Account saveAccount(AccountDto account);
    Account getOneAccount(Long id);
    Account getAccountByNumber(String number);
    void deleteAccount(Long id);
}
