package tg.iai.ega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.iai.ega.entities.Operation;
import tg.iai.ega.entities.Transfer;
import tg.iai.ega.repositories.OperationRepository;
import tg.iai.ega.repositories.TransferRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private TransferRepository transferRepository;

    public List<Operation> getAllOperations(Long id){
        return operationRepository.findAllByAccount_Id(id);
    }
    public List<Transfer> getAllTransfers(Long id){
        return transferRepository.findTransfersBySource_Id(id);
    }
}
