package application;

import domain.Product;

import persistence.ProductsArray;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductServiceInterface {
    private ProductsArray productsArray;

    public ProductService(ProductsArray productsArray) {
        this.productsArray = productsArray;
    }

    @Override
    public void addProduct(Product product) {
        productsArray.addProduct(product);
    }

    @Override
    public void removeProduct(int id) {
        productsArray.removeProduct(id);
    }

    @Override
    public Product findProductById(int id) {
        return productsArray.getProductById(id);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return productsArray.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productsArray.getProductsByCategory(category);
    }
}