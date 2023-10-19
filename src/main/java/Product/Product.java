package Product;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String categories;
    private String tags;

    private static int ultimoId;

    public Product(String name, String description, double price, int stock, String categories, String tags) {
        this.id = ++ultimoId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categories = categories;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "\nId: " + id +
                "\nNombre: " + name +
                "\nDescripcion: " + description +
                "\nPrecio: " + price +
                "\nStock: " + stock +
                "\nCategorias: " + categories +
                "\nTags: " + tags +
                "\n\n";
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

    public boolean productContainKeyWord(char letter){
        return name.toLowerCase().contains(Character.toString(letter).toLowerCase());
    }


}
