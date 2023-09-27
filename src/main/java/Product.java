public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{ 'name':" + name + ", price:" + price + ", stock:" + stock + "}";
    }

    public boolean hasStock(){
        return this.stock != 0;
    }

    public boolean productPriceIsGreater(double productPrice){
        return this.price > productPrice;
    }

    public boolean productPriceIsLess(double productPrice){
        return this.price < productPrice;
    }

    public boolean productContainKeyWord(String keyWord){
        String lowerCaseName = this.name.toLowerCase();
        return lowerCaseName.contains(keyWord.toLowerCase());
    }


}
