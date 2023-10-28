package Product;

public enum Category {
    LACTEOS_HUEVOS_Y_REFRIGERADOS("Lacteos, huevos y refrigerados"),
    PASABOCAS("Pasabocas"),
    DULCES_Y_POSTRES("Dulces y postres"),
    BEBIDAS("Bebidas"),
    PRODUCTOS_CONGELADOS("Productos congelados"),
    HELADOS("Helados"),
    VINOS_Y_LICORES("Vino y licores"),
    CIGARRILLOS("Cigarrillos"),
    DESPENSA("Despensa"),
    CUIDADO_BEBE("Cuidado de bebe"),
    DROGUERIA("Drogueria"),
    PANADERIA_Y_PASTELERIA("Panaderia y pasteleria"),
    HOGAR_Y_DECORACION("Hogar y decoracion"),
    ASEO_HOGAR("Aseo y hogar"),
    LIMPIEZA_COCINA("Limpieza y cocina"),
    MASCOTAS("Mascotas"),
    CUIDADO_PERSONAL("Cuidado personal"),
    CUIDADO_ROPA("Cuidado de ropa"),
    ILUMINACION_ELECTRICOS("Iluminacion y electricos"),
    ELECTRODOMESTICOS("Electrodomesticos");

    private String categoryValue;

    Category(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public static String getCategoryByNumber(int choice){
        switch (choice){
            case 1 -> {
                return LACTEOS_HUEVOS_Y_REFRIGERADOS.getCategoryValue();
            }
            case 2 -> {
                return PASABOCAS.getCategoryValue();
            }
            case 3 -> {
                return DULCES_Y_POSTRES.getCategoryValue();
            }
            case 4 -> {
                return BEBIDAS.getCategoryValue();
            }
            case 5 -> {
                return PRODUCTOS_CONGELADOS.getCategoryValue();
            }
            case 6 -> {
                return HELADOS.getCategoryValue();
            }
            case 7 -> {
                return VINOS_Y_LICORES.getCategoryValue();
            }
            case 8 -> {
                return CIGARRILLOS.getCategoryValue();
            }
            case 9 -> {
                return DESPENSA.getCategoryValue();
            }
            case 10 -> {
                return CUIDADO_BEBE.getCategoryValue();
            }
            case 11 -> {
                return DROGUERIA.getCategoryValue();
            }
            case 12 -> {
                return PANADERIA_Y_PASTELERIA.getCategoryValue();
            }
            case 13 -> {
                return HOGAR_Y_DECORACION.getCategoryValue();
            }
            case 14 -> {
                return ASEO_HOGAR.getCategoryValue();
            }
            case 15 -> {
                return LIMPIEZA_COCINA.getCategoryValue();
            }
            case 16 -> {
                return MASCOTAS.getCategoryValue();
            }
            case 17 -> {
                return CUIDADO_PERSONAL.getCategoryValue();
            }
            case 18 -> {
                return CUIDADO_ROPA.getCategoryValue();
            }
            case 19 -> {
                return ILUMINACION_ELECTRICOS.getCategoryValue();
            }
            case 20 -> {
                return ELECTRODOMESTICOS.getCategoryValue();
            }
            default -> {
                return null;
            }
        }
    }

    public static String getAllCategories(){
        return "Categorias disponibles" +
        "\n1. Lacteos, huevos y refrigerados" +
        "\n2. Pasabocas" +
        "\n3. Dulces y postres" +
        "\n4. Bebidas" +
        "\n5. Productos Congelados" +
        "\n6. Helados" +
        "\n7. Vinos y licores" +
        "\n8. Cigarrillos" +
        "\n9. Despensa" +
        "\n10. Cuidado de bebe" +
        "\n11. Drogueria" +
        "\n12. Panaderia y pasteleria" +
        "\n13. Hogar y decoracion" +
        "\n14. Aseo y Hogar" +
        "\n15. Limpieza y cocina" +
        "\n16. Mascotas" +
        "\n17. Cuidado personal" +
        "\n18. Cuidado de ropa" +
        "\n19. Iluminacion electricos" +
        "\n20. Electrodomesticos";
    }
}
