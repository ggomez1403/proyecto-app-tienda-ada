package domain.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Category {
    LACTEOS_HUEVOS_Y_REFRIGERADOS(1,"Lacteos, huevos y refrigerados", Arrays.asList(Tag.ALPINETTE, Tag.ALPINITO, Tag.AREPAS, Tag.CARNES_FRIAS_Y_EMBUTIDOS, Tag.HUEVOS, Tag.KUMIS, Tag.LECHE, Tag.LECHES_EN_POLVO, Tag.MANTEQUILLA, Tag.MARGARINAS, Tag.QUESOS, Tag.YOGURT)),
    PASABOCAS(2,"Pasabocas", Arrays.asList(Tag.GALLETAS_DULCES, Tag.GALLETAS_SALADAS, Tag.GALLETAS_SALUDABLES, Tag.PAPAS_FRITAS_Y_PAQUETES)),
    DULCES_Y_POSTRES(3,"Dulces y postres", Arrays.asList(Tag.AREQUIPE, Tag.CHOCOLATERIA, Tag.CONFETIS_Y_DULCES, Tag.CREMA_DE_LECHE_Y_LECHE_CONDENSADA, Tag.DULCES_TIPICOS, Tag.GELATINAS_FLANES_Y_PUDINES, Tag.REPOSTERIA)),
    BEBIDAS(4,"Bebidas", Arrays.asList(Tag.AGUA, Tag.ENERGIZANTES, Tag.GASEOSAS, Tag.HIDRATANTES, Tag.JUGOS_REFRESCOS_MALTAS, Tag.TE_LIQUIDO)),
    PRODUCTOS_CONGELADOS(5,"Productos congelados", Arrays.asList(Tag.CONGELADOS, Tag.EMPANADAS, Tag.PAPAS_YUCAS_Y_PATACONES)),
    HELADOS(6,"Helados", Arrays.asList(Tag.HELADOS)),
    VINOS_Y_LICORES(7,"Vino y licores", Arrays.asList(Tag.AGUARDIENTE, Tag.BRANDY, Tag.CERVEZA, Tag.GINEBRA, Tag.LICOR, Tag.RON, Tag.VINOS, Tag.VODKA, Tag.WHISKY)),
    CIGARRILLOS(8,"Cigarrillos", Arrays.asList(Tag.CIGARRILLOS)),
    DESPENSA(9,"Despensa", Arrays.asList(Tag.ACEITES, Tag.ARROZ_Y_GRANOS, Tag.AVENA, Tag.AZUCAR_Y_PANELAS, Tag.BASES_CREMAS_Y_SOPAS, Tag.BEBIDAS_ACHOCOLADATAS_EN_POLVO, Tag.CAFE, Tag.CEREALES, Tag.CHOCOLATES_DE_MESA, Tag.CONDIMIENTOS_CALDOS_Y_SAL, Tag.ENLATADOS_Y_CONSERVAS, Tag.HARINAS_Y_MEZCLAS, Tag.PASTAS, Tag.SALSAS_Y_VINAGRES, Tag.TE_INFUSIONES_E_INSTANTANEOS)),
    CUIDADO_BEBE(10,"Cuidado de bebe", Arrays.asList(Tag.ALIMENTACION, Tag.PAÑALES, Tag.PAÑITOS)),
    DROGUERIA(11,"Drogueria", Arrays.asList(Tag.SALUD_Y_BIENESTAR)),
    PANADERIA_Y_PASTELERIA(12,"Panaderia y pasteleria", Arrays.asList(Tag.PANADERIA_EMPACADA)),
    HOGAR_Y_DECORACION(13,"Hogar y decoracion", Arrays.asList(Tag.DESECHABLES)),
    ASEO_HOGAR(14,"Aseo y hogar", Arrays.asList(Tag.AMBIENTADORES, Tag.BLANQUEADORES, Tag.CERA, Tag.DESINFECTANTE, Tag.INSECTICIDAS, Tag.LIMPIEZA_SUPERFICIE)),
    LIMPIEZA_COCINA(15,"Limpieza y cocina", Arrays.asList(Tag.BOLSAS_DE_BASURA, Tag.ESPONJAS_Y_FIBRAS, Tag.LAVALOZA, Tag.SERVILLETAS, Tag.TRAPEROS_Y_ESCOBAS)),
    MASCOTAS(16,"Mascotas", Arrays.asList(Tag.AVES, Tag.GATOS, Tag.HAMSTERS, Tag.PERRO, Tag.PEZ)),
    CUIDADO_PERSONAL(17,"Cuidado personal", Arrays.asList(Tag.AFEITADO, Tag.CREMAS_CORPORALES, Tag.CUIDADO_ORAL, Tag.DESODORANTES, Tag.GEL, Tag.JABONES_TOCADOR, Tag.PAPEL_HIGIENICO, Tag.PROTECCION_FEMENINA, Tag.SHAMPOO)),
    CUIDADO_ROPA(18,"Cuidado de ropa", Arrays.asList(Tag.DETERGENTES, Tag.JABONES_BARRA)),
    ILUMINACION_ELECTRICOS(19,"Iluminacion y electricos", Arrays.asList(Tag.BOMBILLOS, Tag.PILAS)),
    ELECTRODOMESTICOS(20,"Electrodomesticos", Arrays.asList(Tag.ELECTRODOMESTICOS));

    private String categoryValue;
    private List<Tag> tags;
    private int id;

    Category(int id, String categoryValue, List<Tag> tags) {
        this.categoryValue = categoryValue;
        this.tags = tags;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public static String getAllCategories(){
        String categories = "";
        for (int i = 0; i < Category.values().length; i++) {
            categories += (i+1) + ". " + (Category.values()[i].getCategoryValue() + "\n");
        }

        return categories;
    }

    public static Category getCategoryById(int categoryId) {
        for (Category category : Category.values()) {
            if (category.getId() == categoryId) {
                return category;
            }
        }
        return null;
    }
}
