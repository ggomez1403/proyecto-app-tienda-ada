package domain.model;

import domain.service.ProductService;
import infrastructure.dao.ProductDAO;
import domain.service.interfaces.ProductServiceInterface;
import infrastructure.repository.ProductRepository;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private int category;
    private int tag;
    private String photoUrl;

    public Product(String name, String description, double price, int stock, int category, int tag, String photoUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.tag = tag;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean hasStock() {
        return this.stock != 0;
    }

    public boolean productPriceIsGreater(double productPrice) {
        return this.price > productPrice;
    }

    public boolean productPriceIsLess(double productPrice) {
        return this.price < productPrice;
    }

    public boolean productContainKeyWord(char letter) {
        return name.toLowerCase().contains(Character.toString(letter).toLowerCase());
    }

    public void discountStock(int quantity) {
        if (hasStock()) {
            stock -= quantity;
        }
    }

    static ProductDAO productDAO = new ProductDAO();
    static ProductRepository productRepository = new ProductRepository(productDAO);
    static ProductServiceInterface productService = new ProductService(productRepository);

    @Override
    public String toString() {
        return String.format(
                "%-5s | %-25s | %-7s | %-30s | %-40s | %-43s | %-7.3f | %s",
                getId(),
                getName(),
                getStock(),
                getDescription(),
                productService.getCategoryNameById(getCategory()),
                productService.getTagNameById(getTag()),
                getPrice(),
                getPhotoUrl()
        );
    }
}
