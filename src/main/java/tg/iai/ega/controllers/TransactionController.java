package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.entities.Operation;
import tg.iai.ega.entities.Transfer;
import tg.iai.ega.repositories.OperationRepository;
import tg.iai.ega.repositories.TransferRepository;
import tg.iai.ega.services.TransactionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ega/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @GetMapping("/getAllOperations/{id}")
    public List<Operation> getAllOperations(@PathVariable Long id){
        return transactionService.getAllOperations(id);
    }
    @GetMapping("/getAllTransfers/{id}")
    public List<Transfer> getAllTransfers(@PathVariable Long id){
        return transactionService.getAllTransfers(id);
    }
}
