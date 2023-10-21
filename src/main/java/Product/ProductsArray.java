package Product;

import Bill.Bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductsArray {
    private ArrayList<Product> products;

    public ProductsArray(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int id){
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void updateProduct(int id, String name, String desc, double price, int stock, String categories, String tags, String photoUrl){
        Product productToUpdate = this.getProductById(id);
        if (productToUpdate != null) {
            productToUpdate.setName(name);
            productToUpdate.setDescription(desc);
            productToUpdate.setPrice(price);
            productToUpdate.setStock(stock);
            productToUpdate.setCategories(categories);
            productToUpdate.setTags(tags);
            productToUpdate.setPhotoUrl(photoUrl);
            System.out.println("******PRODUCTO ACTUALIZADO CON EXITO******");
        }
        else{
            System.out.println("******PRODUCTO NO ENCONTRADO******");
        }
    }

    public ArrayList<Product> searchProduct(String name) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public ArrayList<Product> getAllProducts(){
        return products;
    }

    public void showProductsByLetter(char letter) {
        System.out.println("Productos cuyos nombres empiezan con la letra '" + letter + "':");
        for (Product product : products) {
            if (product.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                System.out.println(product);
            }
        }
    }

    public void printProductsInAlphabeticalOrder() {
        if (products.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            Collections.sort(products, Comparator.comparing(p -> p.getName().toLowerCase()));
            System.out.println("Productos en orden alfabético:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
