package infrastructure.dao;

import domain.model.Product;
import infrastructure.util.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void insertProduct(Product product) {
        String INSERT_PRODUCT_SQL = "INSERT INTO product (name, description, price, stock, photo_url, category_id, tag_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, BigDecimal.valueOf(product.getPrice()));
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setString(5, product.getPhotoUrl());
            preparedStatement.setInt(6, product.getCategory());
            preparedStatement.setInt(7, product.getTag());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId){
        String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE product_id = ?";
        try(Connection connection = DatabaseConnection.connect();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)){
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateProduct(int productId, String fieldName, Object newValue) {
        String UPDATE_PRODUCT_SQL = String.format("UPDATE product SET %s=? WHERE product_id=?", fieldName);

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            if (newValue instanceof String) {
                preparedStatement.setString(1, (String) newValue);
            } else if (newValue instanceof Integer) {
                preparedStatement.setInt(1, (Integer) newValue);
            } else if (newValue instanceof Double) {
                preparedStatement.setBigDecimal(1, BigDecimal.valueOf((Double) newValue));
            }

            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> searchProductByName(String name){
        String SEARCH_PRODUCT_BY_NAME_SQL = "SELECT * FROM product WHERE name LIKE ?";
        List<Product> productList = new ArrayList<>();

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME_SQL)){
            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Product product = extractProductFromResultSet(resultSet);
                productList.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }

    public List<Product> getAllProducts(){
        String SELECT_ALL_PRODUCTS_SQL = "SELECT * FROM product ORDER BY product_id";

        List<Product> productList = new ArrayList<>();

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                Product product = extractProductFromResultSet(resultSet);
                productList.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return  productList;
    }

    public Product getProductById(int productId) {
        String SELECT_PRODUCT_SQL = "SELECT * FROM product WHERE product_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_SQL)) {
            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Product product = extractProductFromResultSet(resultSet);
                    return product;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> getProductsByCategoryId(int categoryId){
        List<Product> productList = new ArrayList<>();

        String SELECT_PRODUCTS_BY_CATEGORY_ID_SQL = "SELECT * FROM product WHERE category_id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY_ID_SQL)) {
            preparedStatement.setInt(1, categoryId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = extractProductFromResultSet(resultSet);
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public String getCategoryNameById(int categoryId){
        String SELECT_CATEGORY_NAME_SQL = "SELECT name FROM category WHERE category_id = ?";
        String categoryName = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_NAME_SQL)) {
            preparedStatement.setInt(1, categoryId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    categoryName = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryName;
    }

    public String getTagNameById(int tagId) {
        String SELECT_TAG_NAME_SQL = "SELECT name FROM tag WHERE tag_id = ?";
        String tagName = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAG_NAME_SQL)) {
            preparedStatement.setInt(1, tagId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    tagName = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tagName;
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("product_id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        double price = resultSet.getDouble("price");
        int stock = resultSet.getInt("stock");
        String photoUrl = resultSet.getString("photo_url");
        int category = resultSet.getInt("category_id");
        int tag = resultSet.getInt("tag_id");

        Product product = new Product(name, description, price, stock, category, tag, photoUrl);

        product.setId(id);

        return product;
    }
}
