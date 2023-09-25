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

    public static void addProduct(){
        System.out.println("\nProducto añadido\n");
    }

    public static void removeProduct(){
        System.out.println("\nProducto eliminado\n");
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
    }
}
