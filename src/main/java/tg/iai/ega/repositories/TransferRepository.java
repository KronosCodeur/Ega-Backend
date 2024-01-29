package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
