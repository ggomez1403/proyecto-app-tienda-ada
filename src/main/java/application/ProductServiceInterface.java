package application;

import domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductServiceInterface {
    void addProduct(Product product);
    void removeProduct(int id);
    Product findProductById(int id);
    ArrayList<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
