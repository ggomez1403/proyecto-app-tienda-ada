package infrastructure.repository;

import infrastructure.dao.ProductDAO;
import domain.model.Product;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;

    public ProductRepository(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        productDAO.insertProduct(product);
    }

    public void deleteProduct(int productId){
        productDAO.deleteProduct(productId);
    }

    public void updateProduct(int productId, String fieldName, Object newValue){
        productDAO.updateProduct(productId, fieldName, newValue);
    }

    public List<Product> searchProductByName(String name){
        return productDAO.searchProductByName(name);
    }

    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId){
        return productDAO.getProductById(productId);
    }

    public List<Product> getProductsByCategoryId(int categoryId){
        return productDAO.getProductsByCategoryId(categoryId);
    }

    public String getCategoryNameById(int categoryId){
        return productDAO.getCategoryNameById(categoryId);
    }

    public String getTagNameById(int tagId){
        return productDAO.getTagNameById(tagId);
    }
}
