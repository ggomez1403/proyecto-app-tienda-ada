package model;

import java.util.Arrays;
import java.util.Scanner;

public class ProductsArray {
    String[] products = new String[20];

    public void fillProductsList(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < products.length; i++) {
            System.out.print("Ingrese producto No. " + (i + 1) + " : ");
            products[i] = scanner.nextLine();
        }
    }

    public void showProductsList(){
        for (int i = 0; i < products.length; i++) {
            System.out.println("Producto No." + (i+1) + ": " + products[i]);
        }
    }
    public void showProductsByLetter(String letter){
        System.out.println("\nProductos que empiezan por la letra: " + letter);
        for (String product:products){
            if(product.startsWith(letter)){
                System.out.println(product);
            }
        }
    }

    public void printProductsAlphabeticalOrder(){
        System.out.println("\nProductos en orden alfabetico");
        Arrays.sort(products);
        for(String product:products){
            System.out.println(product);
        }
    }
}
