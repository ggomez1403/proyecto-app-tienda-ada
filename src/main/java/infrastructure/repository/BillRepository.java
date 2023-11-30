package infrastructure.repository;

import infrastructure.dao.BillDAO;
import infrastructure.dto.BillDTO;
import domain.model.Bill;
import domain.model.BillDetail;
import domain.model.Client;

import java.util.List;

public class BillRepository {
    private BillDAO billDAO;

    public BillRepository(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    public void insertBillDetail(int billId, BillDetail billDetail){
        billDAO.insertBillDetail(billId, billDetail);
    }

    public void insertBill(Bill bill){
        billDAO.insertBill(bill);
    }

    public List<Bill> getBillsByClient(Client client){
       return billDAO.getBillsByClient(client);
    }

    public List<BillDTO> getAllBills(){
        return billDAO.getAllBills();
    }
}
