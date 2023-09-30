import model.Product;
import model.ProductsArray;

import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        ProductsArray productsList = new ProductsArray();
        productsList.fillProductsList();
        productsList.showProductsByLetter("Y");
        productsList.printProductsAlphabeticalOrder();
//        runMenu();
    }

    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Menu.displayMenu();
            choice = scanner.nextInt();
            Menu.handleUserChoice(choice);
        }while(choice != 8);
    }
}
