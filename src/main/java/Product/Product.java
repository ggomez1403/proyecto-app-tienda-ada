package Product;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String categories;
    private String tags;
    private String photoUrl;

    private static int ultimoId;

    public Product(String name, String description, double price, int stock, String categories, String tags, String photoUrl) {
        this.id = ++ultimoId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categories = categories;
        this.tags = tags;
        this.photoUrl = photoUrl;
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

    public void discountStock(int quantity){
        if(hasStock()){
            stock -= quantity;
        }
    }

    public static String removeTrailingZeros(String formattedNumber) {
        if (formattedNumber.contains(".")) {
            formattedNumber = formattedNumber.replaceAll("0*$", "");
            formattedNumber = formattedNumber.replaceAll(",$", "");
        }
        return formattedNumber;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        String formattedNum = String.format("$%,.2f", price);
        String productFormattedNum = Product.removeTrailingZeros(formattedNum);

        return  "*******************************" +
                "\nId: " + id +
                "\n-------------------------------" +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nPrice: " + productFormattedNum +
                "\n-------------------------------" +
                "\nStock: " + stock +
                "\nCategories: " + categories +
                "\nTags: " + tags +
                "\nPhoto Url: " + photoUrl +
                "\n*******************************" +
                "\n\n";
    }
}
