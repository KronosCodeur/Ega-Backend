package tg.iai.ega.services;


import tg.iai.ega.entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> showAllAccounts();
    Account saveAccount(Account account);
    Account getOneAccount(Long id);
    Account getAccountByNumber(String number);
    void deleteAccount(Long id);
    void effectuerDepot(String numeroCompte, float montant);
    void effectuerRetrait(String numeroCompte, float montant);
    void effectuerVirement(String sourceNumero, String destinationNumero, float montant);
}
