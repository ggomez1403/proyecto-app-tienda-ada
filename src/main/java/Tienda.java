import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Product productMilk = new Product("Leche Alpina Deslactosada-Descremada", 3.500, 2);

        System.out.println("Producto: " + productMilk.getName());

        System.out.println("El producto tiene stock: " + productMilk.hasStock());
        System.out.println("El precio del producto es mayor al valor dado: " + productMilk.productPriceIsGreater(1.200));
        System.out.println("El precio del producto es menor al valor dado: " + productMilk.productPriceIsLess(5.300));
        System.out.println("El nombre del producto contiene la palabra dada: " + productMilk.productContainKeyWord("Deslactosada"));

        System.out.println("-----------------------------------------------------------");

        Product productYogurt = new Product("Yogurt Alpina Griego 0% Mandarina", 10.700, 0);

        System.out.println("Producto: " + productYogurt.getName());

        System.out.println("El producto tiene stock: " + productYogurt.hasStock());
        System.out.println("El precio del producto es mayor al valor dado: " + productYogurt.productPriceIsGreater(20.300));
        System.out.println("El precio del producto es menor al valor dado: " + productYogurt.productPriceIsLess(9.400));
        System.out.println("El nombre del producto contiene la palabra dada: " + productYogurt.productContainKeyWord("Fresa"));

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
