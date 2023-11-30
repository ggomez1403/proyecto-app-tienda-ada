package infrastructure.repository;

import infrastructure.dao.ClientDAO;
import domain.model.Client;

public class ClientRepository {
    private ClientDAO clientDAO;

    public ClientRepository(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void addClient(Client client) {
        clientDAO.insertClient(client);
    }

    public void deleteClient(int clientId) {
        clientDAO.deleteClient(clientId);
    }

    public Client getClientByName(String name) {
        return clientDAO.getClientByName(name);
    }
}
