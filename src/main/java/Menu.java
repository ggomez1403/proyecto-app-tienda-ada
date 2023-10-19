import model.Product;
import model.ProductsArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void displayMenu(){
        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Buscar producto                       |");
        System.out.println("6. Crear venta de producto               |");
        System.out.println("7. Ver historial de ventas               |");
        System.out.println("8. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 8)  ");
    }

    public static void handleUserChoice(int choice){
        switch (choice){
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> seeAllProducts();
            case 5 -> searchProduct();
            case 6 -> createProductSale();
            case 7 -> viewSalesHistory();
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }
    }

    static ProductsArray productsArray = new ProductsArray();

    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la descripcion del producto: ");
        String desc = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese la cantidad de stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la categoria del producto: ");
        String categories = scanner.nextLine();
        System.out.print("Ingrese las etiquetas del producto: ");
        String tags = scanner.nextLine();

        productsArray.addProduct(new Product(name, desc, price, stock, categories, tags));

        System.out.println("\n******Producto añadido con exito******\n");
    }

    public static void removeProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre del producto a eliminar: ");
        String productName = scanner.nextLine();
        productsArray.removeProduct(productName);
        System.out.println("\n******Producto eliminado******\n");
    }

    public static void updateProduct(){
        System.out.println("\nProducto actualizado\n");
    }

    public static void searchProduct(){
        System.out.println("\nBuscando producto\n");
    }

    public static void createProductSale() {
        System.out.println("\nVenta de producto creada\n");
    }

    public static void viewSalesHistory(){
        System.out.println("\nHistorial de ventas\n");
    }

    public static void seeAllProducts(){
        System.out.println("\nListado de todos los productos\n");
        ArrayList<Product> allProducts = productsArray.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
