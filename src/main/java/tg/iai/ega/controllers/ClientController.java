package tg.iai.ega.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.entities.Client;
import tg.iai.ega.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<Client> showAllClients(){
        return  clientService.showAllClients();
    }
    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        return  clientService.saveClient(client);
    }
    @GetMapping("/clients/{id}")
    public Client getOneClient(@PathVariable Long id){
        return  clientService.getOneClient(id);
    }
    @GetMapping("/clients/info")
    public Client get(@PathVariable Long id){
        return  clientService.getOneClient(id);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public  Client updateClient(@RequestBody Client client,@PathVariable Long id){
        client.setId(id);
        return clientService.saveClient(client);
    }
}
