package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByNumber(String number);
}
