package tg.iai.ega.services;

import tg.iai.ega.dto.ClientDTO;
import tg.iai.ega.entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> showAllClients();
    Client getOneClient(Long id);

    Client UpdateClient(Long id, Client client);

    void deleteClient(Long id);
}
