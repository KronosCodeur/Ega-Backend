package tg.iai.ega.services;

import tg.iai.ega.dto.ClientDTO;
import tg.iai.ega.entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> showAllClients();
    Client saveClient(ClientDTO clientDTO);
    Client getOneClient(Long id);
    void deleteClient(Long id);
}
