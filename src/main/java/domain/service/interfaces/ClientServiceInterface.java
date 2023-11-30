package domain.service.interfaces;

import domain.model.Client;

public interface ClientServiceInterface {
    void addClient(Client client);

    void deleteClient(int clientId);

    Client getClientByName(String name);
}
