package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Operation;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {

    List<Operation> findAllByAccount_Id(Long account_id);
}
