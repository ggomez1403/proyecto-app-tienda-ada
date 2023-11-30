package ui;

import infrastructure.dao.ProductDAO;
import domain.model.Bill;
import domain.model.Product;
import domain.enumeration.Category;
import domain.enumeration.Tag;
import domain.enumeration.Menus;
import domain.service.ProductService;
import domain.service.interfaces.ProductServiceInterface;
import input.SuperKeyBoard;
import infrastructure.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ManageProducts {
    static ProductDAO productDAO = new ProductDAO();
    static ProductRepository productRepository = new ProductRepository(productDAO);
    static ProductServiceInterface productService = new ProductService(productRepository);

    public static void MenuProductsOptions() {
        boolean manageMoreProducts = true;

        while (manageMoreProducts) {
            Menus.MANAGE_PRODUCTS_MENU.getValue();

            int choice = SuperKeyBoard.readNumber();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> deleteProduct();
                case 3 -> updateProduct();
                case 4 -> getAllProducts();
                case 5 -> searchProductByName();
                case 6 -> getProductsByCategory();
                case 7 -> {
                    manageMoreProducts = false;
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

            Category selectedCategory = Category.getCategoryById(categoryChoice);

            if (selectedCategory != null) {
                System.out.println("Etiquetas disponibles para la categoría '" + selectedCategory.getCategoryValue() + "':");

                for (int i = 0; i < selectedCategory.getTags().size(); i++) {
                    System.out.println((i + 1) + ". " + selectedCategory.getTags().get(i).getTagValue());
                }

                System.out.print("Ingrese el número de la etiqueta del producto: ");
                int tagIndex = SuperKeyBoard.readNumber();

                if (tagIndex > 0 && tagIndex <= selectedCategory.getTags().size()) {
                    Tag selectedTag = selectedCategory.getTags().get(tagIndex - 1);

                    System.out.print("Ingrese la URL de la imagen del producto: ");
                    String url = SuperKeyBoard.readText();

                    productService.addProduct(new Product(name, desc, price, stock, selectedCategory.getId(), selectedTag.getId(), url));

                    System.out.println("\n******PRODUCTO AÑADIDO CON ÉXITO******\n");
                    return;
                }
            }

            System.out.println("Índices ingresados no válidos para la categoría o la etiqueta seleccionada.");
        } else {
            System.out.println("El precio y el stock no pueden ser negativos. Por favor, inténtelo de nuevo.");
        }
    }


    public static void deleteProduct() {
        getAllProducts();
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        int productId = SuperKeyBoard.readNumber();

        productService.deleteProduct(productId);

        System.out.println("\n******PRODUCTO ELIMINADO CON ÉXITO******\n");
    }

    public static void updateProduct() {
        getAllProducts();
        System.out.print("Ingrese el id del producto que desea actualizar: ");
        int productId = SuperKeyBoard.readNumber();

        do {
            Menus.UPDATE_PRODUCT_MENU.getValue();
            int fieldNumber = SuperKeyBoard.readNumber();

            String fieldName = getFieldNameByNumber(fieldNumber);

            if (fieldName != null) {
                if (fieldName.equals("category_id")) {
                    System.out.print(Category.getAllCategories() + "\nIngrese un número para seleccionar la nueva categoría del producto: ");
                    int categoryChoice = SuperKeyBoard.readNumber();

                    Category selectedCategory = Category.getCategoryById(categoryChoice);

                    if (selectedCategory != null) {
                        System.out.println("Etiquetas disponibles para la categoría '" + selectedCategory.getCategoryValue() + "':");

                        for (int i = 0; i < selectedCategory.getTags().size(); i++) {
                            System.out.println((i + 1) + ". " + selectedCategory.getTags().get(i).getTagValue());
                        }

                        System.out.print("Ingrese un número para seleccionar la nueva etiqueta del producto: ");
                        int tagChoice = SuperKeyBoard.readNumber();

                        Tag selectedTag = selectedCategory.getTags().get(tagChoice - 1);

                        productService.updateProduct(productId, "category_id", selectedCategory.getId());
                        productService.updateProduct(productId, "tag_id", selectedTag.getId());
                    } else {
                        System.out.println("Número de categoría no válido.");
                    }
                } else {
                    System.out.println("Ingrese el nuevo valor del campo seleccionado:");
                    Object newValue;
                    if (fieldName.equals("price")) {
                        newValue = SuperKeyBoard.readDecimalNumber();
                    } else if (fieldName.equals("stock")) {
                        newValue = SuperKeyBoard.readNumber();
                    } else {
                        newValue = SuperKeyBoard.readText();
                    }
                    productService.updateProduct(productId, fieldName, newValue);
                }
                System.out.println("\n******PRODUCTO ACTUALIZADO CON ÉXITO******\n");

                System.out.print("¿Desea actualizar otro campo? (Sí/No): ");
                String answer = SuperKeyBoard.readText().toLowerCase();

                if(!answer.equals("si")) break;
            } else {
                System.out.println("Número de campo no válido.");
            }
        } while (true);
    }

    public static void getAllProducts(){
        List<Product> productList = productService.getAllProducts();

        if(productList.isEmpty()){
            System.out.println("No hay productos disponibles");
        } else{
            System.out.println("Lista de productos");
            productList.forEach(System.out::println);
        }
    }

    public static void searchProductByName(){
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String name = SuperKeyBoard.readText();

        List<Product> productList = productService.searchProductByName(name);

        if (!productList.isEmpty()) {
            System.out.println("Productos encontrados:");
            productList.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron productos con ese nombre.");
        }
    }

    public static void getProductsByCategory(){
        List<Category> categories = productService.getAllCategories();

        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryValue());
        }

        System.out.print("Ingrese el número de la categoría: ");
        int categoryChoice = SuperKeyBoard.readNumber();

        if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
            int categoryId = categories.get(categoryChoice - 1).getId();

            List<Product> productList = productService.getProductsByCategoryId(categoryId);

            if (!productList.isEmpty()) {
                productList.forEach(System.out::println);
            } else {
                System.out.println("No se encontraron productos en la categoría especificada.");
            }
        } else {
            System.out.println("Número de categoría no válido.");
        }
    }

    private static String getFieldNameByNumber(int fieldNumber){
        switch (fieldNumber){
            case 1 -> {
                return "name";
            }
            case 2 -> {
                return "description";
            }
            case 3 -> {
                return "price";
            }
            case 4 -> {
                return "stock";
            }
            case 5 -> {
                return "photo_url";
            }
            case 6 -> {
                return "category_id";
            }
            default -> {
                return null;
            }
        }
    }
}
