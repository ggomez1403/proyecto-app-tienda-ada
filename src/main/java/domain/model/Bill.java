package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int id;
    private LocalDate date;
    private Client client;
    private List<BillDetail> billDetails;

    public Bill(Client client) {
        this.date = LocalDate.now();
        this.client = client;
        this.billDetails = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-25s |%-15s", getId(), getDate(), getClient().getName());
    }
}
