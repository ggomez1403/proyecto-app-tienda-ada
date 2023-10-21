package Menu;

import Bill.Bill;
import Client.Client;
import Product.Product;
import Product.ProductsArray;

import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("6. Crear factura de producto             |");
        System.out.println("7. Ver historial de facturas             |");
        System.out.println("8. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 8): ");
    }

    public static void handleUserChoice(int choice){
        switch (choice){
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> seeAllProducts();
            case 5 -> searchProduct();
            case 6 -> createBill();
            case 7 -> viewAllBills(productsArray);
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }
    }

    private static ProductsArray productsArray = new ProductsArray();
    private static ArrayList<Bill> bills = new ArrayList<>();

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
        System.out.print("Ingrese la url de la imagen del producto: ");
        String url = scanner.nextLine();

        productsArray.addProduct(new Product(name, desc, price, stock, categories, tags, url));

        System.out.println("\n******PRODUCTO AÑADIDO CON EXITO******\n");
    }

    public static void removeProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del producto que desea eliminar: ");
        int productId = scanner.nextInt();
        productsArray.removeProduct(productId);
        System.out.println("\n******PRODUCTO ELIMINADO CON EXITO******\n");
    }

    public static void updateProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Actualizar un producto");
        System.out.print("Ingrese el id del producto que desea actualizar: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String newName = scanner.nextLine();

        System.out.print("Nueva descripcion: ");
        String newDesc = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double newPrice = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Nueva cantidad en stock: ");
        int newStock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevas categorías: ");
        String newCategories = scanner.nextLine();

        System.out.print("Nuevas etiquetas: ");
        String newTags = scanner.nextLine();

        System.out.print("Nuevas url de foto: ");
        String newUrl = scanner.nextLine();

        productsArray.updateProduct(productId, newName, newDesc, newPrice, newStock, newCategories, newTags, newUrl);
    }

    public static void searchProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Búsqueda de productos");
        System.out.print("Ingrese el nombre del producto: ");
        String criteria = scanner.nextLine();

        ArrayList<Product> foundProducts = productsArray.searchProduct(criteria);

        if (foundProducts.isEmpty()) {
            System.out.println("No se encontraron productos que coincidan con el criterio de búsqueda.");
        } else {
            System.out.println("\nProductos encontrados:");
            for (Product product : foundProducts) {
                System.out.println(product);
            }
        }
    }

    public static void createBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creación de una nueva factura");

        System.out.print("Nombre del cliente: ");
        String clientName = scanner.nextLine();
        System.out.print("Dirección del cliente: ");
        String clientAddress = scanner.nextLine();

        Client cliente = new Client(clientName, clientAddress);
        Bill bill = new Bill(new Date(), cliente);

        boolean addMoreProducts = true;

        while (addMoreProducts) {
            System.out.println("Productos disponibles:");
            seeAllProducts();

            System.out.print("Ingrese el id del producto a agregar: ");
            int productId = scanner.nextInt();
            System.out.print("Cantidad: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Product producto = productsArray.getProductById(productId);

            if (producto != null) {
                bill.addItem(producto, quantity);
                System.out.println("******PRODUCTO AGREGADO A LA FACTURA******");
            } else {
                System.out.println("******PRODUCTO NO ENCONTRADO******");
            }

            System.out.print("¿Desea agregar otro producto? (Sí/No): ");
            String continuar = scanner.nextLine();
            addMoreProducts = continuar.equalsIgnoreCase("si");
        }
        bills.add(bill);
    }

    public static void viewAllBills(ProductsArray productsArray){
        System.out.println("Listado de todas las facturas:");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    public static void seeAllProducts(){
        System.out.println("\nListado de todos los productos\n");
        ArrayList<Product> allProducts = productsArray.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
