package domain.service.interfaces;

import domain.enumeration.Category;
import domain.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductServiceInterface {
    void addProduct(Product product);

    void deleteProduct(int productId);

    void updateProduct(int productId, String fieldName, Object newValue);
    List<Product> searchProductByName(String name);

    List<Product> getAllProducts();

    List<Category> getAllCategories();

    Product getProductById(int productId);

    List<Product> getProductsByCategoryId(int categoryId);

    String getCategoryNameById(int categoryId);

    String getTagNameById(int tagId);
}
