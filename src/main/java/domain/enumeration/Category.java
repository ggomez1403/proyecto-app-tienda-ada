package domain.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Category {
    LACTEOS_HUEVOS_Y_REFRIGERADOS("Lacteos, huevos y refrigerados", Arrays.asList(CategoryTags.ALPINETTE, CategoryTags.ALPINITO, CategoryTags.AREPAS, CategoryTags.AVENA, CategoryTags.CARNES_FRIAS_Y_EMBUTIDOS, CategoryTags.GELATINAS_FLANES_Y_PUDINES, CategoryTags.HUEVOS, CategoryTags.KUMIS, CategoryTags.LECHE, CategoryTags.LECHES_EN_POLVO, CategoryTags.MANTEQUILLA, CategoryTags.MARGARINAS, CategoryTags.QUESOS, CategoryTags.YOGURT)),
    PASABOCAS("Pasabocas", Arrays.asList(CategoryTags.GALLETAS_DULCES, CategoryTags.GALLETAS_SALADAS, CategoryTags.GALLETAS_SALUDABLES, CategoryTags.PAPAS_FRITAS_Y_PAQUETES)),
    DULCES_Y_POSTRES("Dulces y postres", Arrays.asList(CategoryTags.AREQUIPE, CategoryTags.CHOCOLATERIA, CategoryTags.CONFETIS_Y_DULCES, CategoryTags.CREMA_DE_LECHE_Y_LECHE_CONDENSADA, CategoryTags.DULCES_TIPICOS, CategoryTags.GELATINAS_FLANES_Y_PUDINES, CategoryTags.REPOSTERIA)),
    BEBIDAS("Bebidas", Arrays.asList(CategoryTags.AGUA, CategoryTags.ENERGIZANTES, CategoryTags.GASEOSAS, CategoryTags.HIDRATANTES, CategoryTags.JUGOS_REFRESCOS_MALTAS, CategoryTags.TE_LIQUIDO)),
    PRODUCTOS_CONGELADOS("Productos congelados", Arrays.asList(CategoryTags.CONGELADOS, CategoryTags.EMPANADAS, CategoryTags.PAPAS_YUCAS_Y_PATACONES)),
    HELADOS("Helados", Arrays.asList(CategoryTags.HELADOS)),
    VINOS_Y_LICORES("Vino y licores", Arrays.asList(CategoryTags.AGUARDIENTE, CategoryTags.BRANDY, CategoryTags.CERVEZA, CategoryTags.GINEBRA, CategoryTags.LICOR, CategoryTags.RON, CategoryTags.VINOS, CategoryTags.VODKA, CategoryTags.WHISKY)),
    CIGARRILLOS("Cigarrillos", Arrays.asList(CategoryTags.CIGARRILLOS)),
    DESPENSA("Despensa", Arrays.asList(CategoryTags.ACEITES, CategoryTags.ARROZ_Y_GRANOS, CategoryTags.AVENA, CategoryTags.AZUCAR_Y_PANELAS, CategoryTags.BASES_CREMAS_Y_SOPAS, CategoryTags.BEBIDAS_ACHOCOLADATAS_EN_POLVO, CategoryTags.CAFE, CategoryTags.CEREALES, CategoryTags.CHOCOLATES_DE_MESA, CategoryTags.CONDIMIENTOS_CALDOS_Y_SAL, CategoryTags.ENLATADOS_Y_CONSERVAS, CategoryTags.HARINAS_Y_MEZCLAS, CategoryTags.PASTAS, CategoryTags.SALSAS_Y_VINAGRES, CategoryTags.TE_INFUSIONES_E_INSTANTANEOS)),
    CUIDADO_BEBE("Cuidado de bebe", Arrays.asList(CategoryTags.ALIMENTACION, CategoryTags.PAÑALES, CategoryTags.PAÑITOS)),
    DROGUERIA("Drogueria", Arrays.asList(CategoryTags.SALUD_Y_BIENESTAR)),
    PANADERIA_Y_PASTELERIA("Panaderia y pasteleria", Arrays.asList(CategoryTags.PANADERIA_EMPACADA)),
    HOGAR_Y_DECORACION("Hogar y decoracion", Arrays.asList(CategoryTags.DESECHABLES)),
    ASEO_HOGAR("Aseo y hogar", Arrays.asList(CategoryTags.AMBIENTADORES, CategoryTags.BLANQUEADORES, CategoryTags.CERA, CategoryTags.DESINFECTANTE, CategoryTags.INSECTICIDAS, CategoryTags.LIMPIEZA_SUPERFICIE)),
    LIMPIEZA_COCINA("Limpieza y cocina", Arrays.asList(CategoryTags.BOLSAS_DE_BASURA, CategoryTags.ESPONJAS_Y_FIBRAS, CategoryTags.LAVALOZA, CategoryTags.SERVILLETAS, CategoryTags.TRAPEROS_Y_ESCOBAS)),
    MASCOTAS("Mascotas", Arrays.asList(CategoryTags.AVES, CategoryTags.GATOS, CategoryTags.HAMSTERS, CategoryTags.PERRO, CategoryTags.PEZ)),
    CUIDADO_PERSONAL("Cuidado personal", Arrays.asList(CategoryTags.AFEITADO, CategoryTags.CREMAS_CORPORALES, CategoryTags.CUIDADO_ORAL, CategoryTags.DESODORANTES, CategoryTags.GEL, CategoryTags.JABONES_TOCADOR, CategoryTags.PAPEL_HIGIENICO, CategoryTags.PROTECCION_FEMENINA, CategoryTags.SHAMPOO)),
    CUIDADO_ROPA("Cuidado de ropa", Arrays.asList(CategoryTags.DETERGENTES, CategoryTags.JABONES_BARRA)),
    ILUMINACION_ELECTRICOS("Iluminacion y electricos", Arrays.asList(CategoryTags.BOMBILLOS, CategoryTags.PILAS)),
    ELECTRODOMESTICOS("Electrodomesticos", Arrays.asList(CategoryTags.ELECTRODOMESTICOS));

    private String categoryValue;
    private List<CategoryTags> tags;

    Category(String categoryValue, List<CategoryTags> tags) {
        this.categoryValue = categoryValue;
        this.tags = tags;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public List<CategoryTags> getTags() {
        return tags;
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
        String categories = "";
        for (int i = 0; i < Category.values().length; i++) {
            categories += (i+1) + ". " + (Category.values()[i].getCategoryValue() + "\n");
        }

        return categories;
    }
}
