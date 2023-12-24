package tg.iai.ega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.iai.ega.dto.ClientDTO;
import tg.iai.ega.entities.Client;
import tg.iai.ega.repositories.ClientRepository;

import java.util.List;
@Service
public class ClientService implements  IClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> showAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(ClientDTO clientDTO) {
        Client client = ClientDTO.toEntity(clientDTO);
        return clientRepository.save(client);
    }

    @Override
    public Client getOneClient(Long id) {

        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
