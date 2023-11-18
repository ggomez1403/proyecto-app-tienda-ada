package application;

import domain.model.Bill;
import domain.model.Product;
import domain.enumeration.Category;
import domain.enumeration.CategoryTags;
import domain.enumeration.Menus;
import domain.service.ProductServiceInterface;
import persistence.ProductsArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageProducts {

    static ProductsArray productsArray = new ProductsArray();
    static ArrayList<Bill> billsArray = new ArrayList<>();
    static ProductServiceInterface productService = new ProductService(productsArray);
    public static void MenuProductsOptions() {
        boolean manageMoreProducts = true;

        while (manageMoreProducts) {
            Menus.MANAGE_PRODUCTS_MENU.getValue();

            int choice = SuperKeyBoard.readNumber();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> updateProduct();
                case 4 -> seeAllProducts();
                case 5 -> searchProduct();
                case 6 -> getProductsByCategory(productsArray);
                case 7 -> {
                    manageMoreProducts = false;  // Salir del bucle
                }
                default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
            }

            if (manageMoreProducts) {
                System.out.println("\nDesea gestionar mas productos (Si/No)");
                String answer = SuperKeyBoard.readText();
                manageMoreProducts = answer.equalsIgnoreCase("si");
            }
        }
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String name = SuperKeyBoard.readText();

        System.out.print("Ingrese la descripción del producto: ");
        String desc = SuperKeyBoard.readText();

        System.out.print("Ingrese el precio del producto: ");
        double price = SuperKeyBoard.readDecimalNumber();

        System.out.print("Ingrese la cantidad de stock del producto: ");
        int stock = SuperKeyBoard.readNumber();

        if (price >= 0 && stock >= 0) {
            System.out.print(Category.getAllCategories() + "\nIngrese un número para seleccionar la categoría del producto: ");
            int categoryChoice = SuperKeyBoard.readNumber();
            Category selectedCategory = Category.values()[categoryChoice - 1];

            String tags = getAvailableTagForCategory(selectedCategory);

            if (tags != null) {
                System.out.print("Ingrese la URL de la imagen del producto: ");
                String url = SuperKeyBoard.readText();

                productService.addProduct(new Product(name, desc, price, stock, selectedCategory.getCategoryValue(), tags, url));

                System.out.println("\n******PRODUCTO AÑADIDO CON ÉXITO******\n");
            } else {
                System.out.println("Índices ingresados no válidos para las etiquetas de la categoría seleccionada.");
            }
        } else {
            System.out.println("El precio y el stock no pueden ser negativos. Por favor, inténtelo de nuevo.");
        }
    }

    public static void removeProduct(){
        System.out.print("Ingrese el id del producto que desea eliminar: ");
        int productId = SuperKeyBoard.readNumber();
        productService.removeProduct(productId);
        System.out.println("\n******PRODUCTO ELIMINADO CON EXITO******\n");
    }

    public static void updateProduct() {
        System.out.println("Actualizar un producto");
        System.out.print("Ingrese el id del producto que desea actualizar: ");
        int productId = SuperKeyBoard.readNumber();

        Product productToUpdate = productsArray.getProductById(productId);

        if (productToUpdate != null) {
            Category selectedCategory = null;

            do {
                Menus.UPDATE_PRODUCT_MENU.getValue();

                int choice = SuperKeyBoard.readNumber();

                switch (choice) {
                    case 1 -> {

                        System.out.print("Nuevo nombre: ");
                        productToUpdate.setName(SuperKeyBoard.readText());
                    }
                    case 2 -> {

                        System.out.print("Nueva descripción: ");
                        productToUpdate.setDescription(SuperKeyBoard.readText());
                    }
                    case 3 -> {
                        System.out.print("Nuevo precio: ");
                        double newPrice = SuperKeyBoard.readDecimalNumber();
                        if (newPrice >= 0) {
                            productToUpdate.setPrice(newPrice);
                        } else {
                            System.out.println("El precio no puede ser negativo. Por favor, inténtelo de nuevo.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Nueva cantidad en stock: ");
                        int newStock = SuperKeyBoard.readNumber();
                        if (newStock >= 0) {
                            productToUpdate.setStock(newStock);
                        } else {
                            System.out.println("La cantidad en stock no puede ser negativa. Por favor, inténtelo de nuevo.");
                        }
                    }
                    case 5 -> {
                        System.out.print(Category.getAllCategories() + "\nIngrese un número para seleccionar la nueva categoría del producto: ");
                        int categoryChoice = SuperKeyBoard.readNumber();
                        selectedCategory = Category.values()[categoryChoice - 1];
                        productToUpdate.setCategories(selectedCategory.getCategoryValue());

                        String newTags = getAvailableTagForCategory(selectedCategory);
                        productToUpdate.setTags((newTags != null) ? newTags : "");
                    }
                    case 6 -> {
                        System.out.print("Nueva URL de la foto: ");
                        productToUpdate.setPhotoUrl(SuperKeyBoard.readText());
                    }
                    case 7 ->{
                        System.out.println("Operación cancelada.");
                        return;
                    }
                    default -> {
                        System.out.println("Opción no válida.");
                        return;
                    }
                }
                System.out.println("******PRODUCTO ACTUALIZADO CON ÉXITO******");

                System.out.print("¿Desea actualizar otro campo? (Sí/No): ");
                String answer = SuperKeyBoard.readText().toLowerCase();

                if (!answer.equals("si")) {
                    break;
                }
            } while (true);
        } else {
            System.out.println("******PRODUCTO NO ENCONTRADO******");
        }
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

    public static void seeAllProducts(){
        System.out.println("\nListado de todos los productos\n");
        ArrayList<Product> allProducts = productService.getAllProducts();
        if (allProducts.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            for (Product product : allProducts) {
                System.out.println(product);
            }
        }
    }

    private static String getAvailableTagForCategory(Category selectedCategory) {
        List<CategoryTags> tagsForCategory = selectedCategory.getTags();

        if (!tagsForCategory.isEmpty()) {
            System.out.println("Etiquetas disponibles para la categoría '" + selectedCategory.getCategoryValue() + "':");

            for (int i = 0; i < tagsForCategory.size(); i++) {
                System.out.println((i + 1) + ". " + tagsForCategory.get(i).getTagValue());
            }

            System.out.print("Ingrese el número de la etiqueta del producto: ");
            int tagIndex = SuperKeyBoard.readNumber();

            if (tagIndex > 0 && tagIndex <= tagsForCategory.size()) {
                return tagsForCategory.get(tagIndex - 1).getTagValue();
            }
        }
        return null;
    }

    public static void getProductsByCategory(ProductsArray productsArray){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la categoria para consultar los productos: ");
        String category = scanner.nextLine();

        List<Product> products = productsArray.getProductsByCategory(category);

        if(products.isEmpty()){
            System.out.println("No se encontraron products en la categoria especificada");
        } else{
            System.out.println("\nProductos en la categoria '" + category + "': ");
            for(Product product : products){
                System.out.println(product);
            }
        }
    }
}
