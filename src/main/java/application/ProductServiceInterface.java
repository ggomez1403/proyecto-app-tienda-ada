package application;

import domain.Product;

import java.util.ArrayList;

public interface ProductServiceInterface {
    void addProduct(Product product);
    void removeProduct(int id);
    Product findProductById(int id);
    ArrayList<Product> getAllProducts();
}
