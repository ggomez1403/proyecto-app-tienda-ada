package infrastructure.dto;

import java.time.LocalDate;
import java.util.List;

public class BillDTO {
    private int billId;
    private LocalDate date;
    private int clientId;
    private String clientName;
    private List<BillDetailDTO> billDetails;

    public BillDTO() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<BillDetailDTO> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetailDTO> billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-5s|%-25s |%-25s", billId, date, clientName));

        if (billDetails != null && !billDetails.isEmpty()) {
            for (BillDetailDTO billDetailDTO : billDetails) {
                stringBuilder.append(String.format(" | %-5s|%-25s |%-15s |%-15s",
                        billDetailDTO.getProductId(), billDetailDTO.getProductName(),
                        billDetailDTO.getQuantity(), billDetailDTO.getTotal()));
            }
        }

        return stringBuilder.toString();
    }
}
