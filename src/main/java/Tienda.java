import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            displayMenu();
            choice = scanner.nextInt();
            handleUserChoice(choice);
        }while(choice != 8);
    }

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

    public static void addProduct(){
        System.out.println("Producto añadido");
    }

    public static void removeProduct(){
        System.out.println("Producto eliminado");
    }

    public static void updateProduct(){
        System.out.println("Producto actualizado");
    }

    public static void searchProduct(){
        System.out.println("Buscando producto");
    }

    public static void createProductSale() {
        System.out.println("Venta de producto creada");
    }

    public static void viewSalesHistory(){
        System.out.println("Historial de ventas");
    }

    public static void seeAllProducts(){
        System.out.println("Listado de todos los productos");
    }

}
