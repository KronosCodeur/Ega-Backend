package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
