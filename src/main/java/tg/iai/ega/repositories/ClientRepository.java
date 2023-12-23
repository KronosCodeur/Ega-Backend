package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    public List<Client>findAllByFirstNameOrLastName(String firstName, String lastName);
    public List<Client>findAllByPhone(String phone);
}
