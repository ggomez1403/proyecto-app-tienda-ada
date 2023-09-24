public class Tienda {
    public static void main(String[] args) {
        System.out.println("\nBienvenido a la tienda!");
        String productName = "Leche Entera Alpina";
        String productDescription = "Bolsa X 1.100 ml";
        String productCategory = "Lacteo/Huevos y refrigerados";
        String productTag = "Leches";
        double productPrice = 3.100;

        String priceFormat = String.format("%.3f", productPrice);


        System.out.println("\n-------------------------------------");
        System.out.println("Detalle de producto");
        System.out.println("-------------------------------------");
        System.out.println("Categoria: " + productCategory);
        System.out.println("Etiquetas: " + productTag);
        System.out.println("-------------------------------------");
        System.out.println("Nombre: " + productName);
        System.out.println("Descripción: " + productDescription);
        System.out.println("Precio: $" + priceFormat);
        System.out.println("-------------------------------------");
    }
}
