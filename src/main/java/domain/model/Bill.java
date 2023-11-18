package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private int id;
    private LocalDate date;
    private Client client;
    private ArrayList<BillItem> items;

    private static int lastId;

    public Bill(Client client) {
        this.id = ++lastId;
        this.date = LocalDate.now();
        this.client = client;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity){
        if(product.getStock() >= quantity){
            BillItem item = new BillItem(product, quantity);
            items.add(item);
            product.discountStock(quantity);
        } else{
            System.out.println("No hay suficiente stock para " + product.getName());
        }
    }

    public double calculateTotal(){
        double subTotal = 0.0;
        double ivaRate = 19.0;
        for (BillItem item:items){
            subTotal += item.calcularSubtotal();
        }
        double ivaTotal = (subTotal * ivaRate) / 100.0;
        return subTotal + ivaTotal;
    }

    public int getBillId() {
        return id;
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

    public ArrayList<BillItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BillItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String formattedNum = String.format("$%,.2f", calculateTotal());
        String productFormattedNum = Product.removeTrailingZeros(formattedNum);

        return "Numero de factura: " + getBillId() +
                "\nFecha: " + getDate() +
                "\nCliente : " + getClient().getName() +
                "\nTotal: " + productFormattedNum;

    }
}
