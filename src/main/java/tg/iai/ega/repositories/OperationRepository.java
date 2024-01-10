package tg.iai.ega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.iai.ega.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation,Long> {

}
