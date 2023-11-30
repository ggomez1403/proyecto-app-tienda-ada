package domain.model;

public class BillDetail {
    private int id;
    private Product product;
    private int quantity;
    private double total;

    public BillDetail(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
        this.total = calcularSubtotal() + (calcularSubtotal() * 0.19);
    }

    public double calcularSubtotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
