package Product;

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

    public void removeProduct(String productName){
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
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
}
