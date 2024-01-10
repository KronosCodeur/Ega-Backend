package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {


    Optional<Client> findClientByEmail(String email);
}
