package tg.iai.ega.services;

import tg.iai.ega.dto.OperationDto;
import tg.iai.ega.entities.Operation;

import java.util.List;

public interface IOperationService {
    Operation saveOperation(OperationDto operationDto);

    List<Operation> getAllOperations();

    Operation getOperationById(Long id);

}
