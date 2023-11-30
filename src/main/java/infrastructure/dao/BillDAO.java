package infrastructure.dao;

import infrastructure.dto.BillDTO;
import infrastructure.dto.BillDetailDTO;
import domain.model.Bill;
import domain.model.BillDetail;
import domain.model.Client;
import infrastructure.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    public void insertBill(Bill bill) {
        String INSERT_BILL_SQL = "INSERT INTO bill (date, client_id) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDate(1, java.sql.Date.valueOf(bill.getDate()));
            preparedStatement.setInt(2, bill.getClient().getId());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    bill.setId(generatedKeys.getInt(1));
                }
            }

            for (BillDetail billDetail : bill.getBillDetails()) {
                insertBillDetail(bill.getId(), billDetail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBillDetail(int billId, BillDetail billDetail) {
        String INSERT_BILL_DETAIL_SQL = "INSERT INTO bill_detail (bill_id, product_id, quantity, total) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_DETAIL_SQL)) {

            preparedStatement.setInt(1, billId);
            preparedStatement.setInt(2, billDetail.getProduct().getId());
            preparedStatement.setInt(3, billDetail.getQuantity());

            double total = billDetail.getTotal();
            preparedStatement.setDouble(4, total);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bill> getBillsByClient(Client client) {
        List<Bill> bills = new ArrayList<>();
        String SELECT_BILLS_BY_CLIENT_SQL = "SELECT * FROM bill WHERE client_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILLS_BY_CLIENT_SQL)) {

            preparedStatement.setInt(1, client.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Bill bill = new Bill(client);
                    bill.setId(resultSet.getInt("client_id"));
                    bill.setDate(resultSet.getDate("date").toLocalDate());

                    bills.add(bill);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }

    public List<BillDTO> getAllBills() {
        List<BillDTO> bills = new ArrayList<>();
        String SELECT_ALL_BILLS_SQL = "SELECT * FROM bill LEFT JOIN bill_detail on bill.bill_id = bill_detail.bill_id LEFT JOIN client on bill.client_id = client.client_id ORDER BY bill.bill_id";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILLS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                BillDTO billDTO = new BillDTO();
                billDTO.setBillId(resultSet.getInt("bill_id"));
                billDTO.setDate(resultSet.getDate("date").toLocalDate());
                billDTO.setClientId(resultSet.getInt("client_id"));
                billDTO.setClientName(resultSet.getString("name"));

                List<BillDetailDTO> billDetails = new ArrayList<>();
                do {
                    BillDetailDTO billDetailDTO = new BillDetailDTO();
                    billDetailDTO.setProductId(resultSet.getInt("product_id"));
                    billDetailDTO.setProductName(resultSet.getString("name"));
                    billDetailDTO.setQuantity(resultSet.getInt("quantity"));
                    billDetailDTO.setTotal(resultSet.getDouble("total"));

                    billDetails.add(billDetailDTO);
                } while (resultSet.next() && resultSet.getInt("bill_id") == billDTO.getBillId());

                billDTO.setBillDetails(billDetails);
                bills.add(billDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bills;
    }


    public Client getClientById(int clientId) {
        String SELECT_CLIENT_BY_ID_SQL = "SELECT * FROM client WHERE client_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL)) {

            preparedStatement.setInt(1, clientId);

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
