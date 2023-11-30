package domain.service;

import domain.enumeration.Category;
import domain.model.Product;
import domain.service.interfaces.ProductServiceInterface;
import infrastructure.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;

public class ProductService implements ProductServiceInterface {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void deleteProduct(int productId){
        productRepository.deleteProduct(productId);
    }

    public void updateProduct(int productId, String fieldName, Object newValue){
        productRepository.updateProduct(productId, fieldName, newValue);
    }

    public List<Product> searchProductByName(String name){
        return productRepository.searchProductByName(name);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Product getProductById(int productId){
        return productRepository.getProductById(productId);
    }

    public List<Product> getProductsByCategoryId(int categoryId){
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }

    public String getCategoryNameById(int categoryId){
        return productRepository.getCategoryNameById(categoryId);
    }

    public String getTagNameById(int tagId) {
        return productRepository.getTagNameById(tagId);
    }
}