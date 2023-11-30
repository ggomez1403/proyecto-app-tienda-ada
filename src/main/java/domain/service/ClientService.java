package domain.service;

import domain.model.Client;
import domain.service.interfaces.ClientServiceInterface;
import infrastructure.repository.ClientRepository;

public class ClientService implements ClientServiceInterface {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public void deleteClient(int clientId) {
        clientRepository.deleteClient(clientId);
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name);
    }
}
