package tg.iai.ega.services;

import tg.iai.ega.entities.Client;

import java.util.List;

public interface IClientService {
    public List<Client> showAllClients();
    public Client saveClient(Client client);
    public Client getOneClient(Long id);
    public void deleteClient(Long id);
}
