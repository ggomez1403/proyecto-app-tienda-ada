package domain.service.interfaces;

import infrastructure.dto.BillDTO;
import domain.model.Bill;
import domain.model.BillDetail;
import domain.model.Client;

import java.util.List;

public interface BillServiceInterface {

    void insertBillDetail(int billId, BillDetail billDetail);

    void insertBill(Bill bill);

    List<Bill> getBillsByClient(Client client);

    List<BillDTO> getAllBills();
}
