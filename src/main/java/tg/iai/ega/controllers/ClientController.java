package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.dto.ClientDTO;
import tg.iai.ega.entities.Client;
import tg.iai.ega.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/ega/api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<Client> showAllClients(){
        return  clientService.showAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getOneClient(@PathVariable Long id){
        return  clientService.getOneClient(id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public  Client updateClient(@RequestBody ClientDTO clientDTO,@PathVariable Long id){
        clientDTO.setId(id);
        return clientService.UpdateClient(id,ClientDTO.toEntity(clientDTO));
    }
}
