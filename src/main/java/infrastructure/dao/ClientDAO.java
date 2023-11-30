package infrastructure.dao;

import domain.model.Client;
import infrastructure.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    public void insertClient(Client client) {
        String INSERT_CLIENT_SQL = "INSERT INTO client (name, address) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getAddress());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId) {
        String DELETE_CLIENT_SQL = "DELETE FROM client WHERE client_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientByName(String name) {
        String SELECT_CLIENT_BY_NAME_SQL = "SELECT * FROM client WHERE LOWER(name) LIKE ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_NAME_SQL)) {

            preparedStatement.setString(1, "%" + name.toLowerCase() + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client(resultSet.getString("name"), resultSet.getString("address"));
                    client.setId(resultSet.getInt("client_id"));
                    return client;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
