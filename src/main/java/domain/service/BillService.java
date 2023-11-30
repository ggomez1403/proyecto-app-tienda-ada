package domain.service;

import infrastructure.dto.BillDTO;
import domain.model.Bill;
import domain.model.BillDetail;
import domain.model.Client;
import domain.service.interfaces.BillServiceInterface;
import infrastructure.repository.BillRepository;

import java.util.List;

public class BillService implements BillServiceInterface {
    private BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void insertBillDetail(int billId, BillDetail billDetail){
        billRepository.insertBillDetail(billId, billDetail);
    }

    public void insertBill(Bill bill){
        billRepository.insertBill(bill);
    }

    public List<Bill> getBillsByClient(Client client) {
        return billRepository.getBillsByClient(client);
    }

    public List<BillDTO> getAllBills(){
        return billRepository.getAllBills();
    }
}
