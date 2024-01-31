package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Transfer;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer,Long> {

    List<Transfer> findTransfersBySource_Id(Long id);
}
