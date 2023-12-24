package tg.iai.ega.services;

import tg.iai.ega.entities.Client;

import java.util.List;

public interface IClientService {
    List<Client> showAllClients();
    Client saveClient(Client client);
    Client getOneClient(Long id);
    void deleteClient(Long id);
}
