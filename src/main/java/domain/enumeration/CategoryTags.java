package domain.enumeration;

import domain.enumeration.Category;

public enum CategoryTags {
    AMBIENTADORES("Ambientadores", Category.ASEO_HOGAR),
    BLANQUEADORES("Blanqueadores", Category.ASEO_HOGAR),
    CERA("Cera", Category.ASEO_HOGAR),
    DESINFECTANTE("Desinfectante", Category.ASEO_HOGAR),
    INSECTICIDAS("Insecticidas", Category.ASEO_HOGAR),
    LIMPIEZA_SUPERFICIE("Limpieza de superficie", Category.ASEO_HOGAR),
    AGUA("Bebidas", Category.BEBIDAS),
    ENERGIZANTES("Energizantes", Category.BEBIDAS),
    GASEOSAS("Gaseosas", Category.BEBIDAS),
    HIDRATANTES("Hidratantes", Category.BEBIDAS),
    JUGOS_REFRESCOS_MALTAS("Jugos, refescos y maltas", Category.BEBIDAS),
    TE_LIQUIDO("Te liquido", Category.BEBIDAS),
    CONGELADOS("Congelados", Category.PRODUCTOS_CONGELADOS),
    EMPANADAS("Empadadas", Category.PRODUCTOS_CONGELADOS),
    PAPAS_YUCAS_Y_PATACONES("Papas, yucas y patacones", Category.PRODUCTOS_CONGELADOS),
    CIGARRILLOS("Cigarrillos", Category.CIGARRILLOS),
    ALIMENTACION("Alimentacion", Category.CUIDADO_BEBE),
    PAÑALES("Pañales", Category.CUIDADO_BEBE),
    PAÑITOS("Pañitos", Category.CUIDADO_BEBE),
    AFEITADO("Afeitado", Category.CUIDADO_PERSONAL),
    CREMAS_CORPORALES("Cremas corporales", Category.CUIDADO_PERSONAL),
    CUIDADO_ORAL("Cuidado oral", Category.CUIDADO_PERSONAL),
    DESODORANTES("Desodorantes", Category.CUIDADO_PERSONAL),
    GEL("Gel", Category.CUIDADO_PERSONAL),
    JABONES_TOCADOR("Jabones de tocador", Category.CUIDADO_PERSONAL),
    PAPEL_HIGIENICO("Papel higienico", Category.CUIDADO_PERSONAL),
    PROTECCION_FEMENINA("Proteccion Femenina", Category.CUIDADO_PERSONAL),
    SHAMPOO("Shampoo", Category.CUIDADO_PERSONAL),
    DETERGENTES("Detergentes", Category.CUIDADO_ROPA),
    JABONES_BARRA("Jabones en barra", Category.CUIDADO_ROPA),
    ACEITES("Aceites", Category.DESPENSA),
    ARROZ_Y_GRANOS("Arroz y granos", Category.DESPENSA),
    AVENA("Avena", Category.DESPENSA),
    AZUCAR_Y_PANELAS("Azucar y panelas", Category.DESPENSA),
    BASES_CREMAS_Y_SOPAS("Bases, remas y sopas", Category.DESPENSA),
    BEBIDAS_ACHOCOLADATAS_EN_POLVO("Bebidas achocolatadas en polvo", Category.DESPENSA),
    CAFE("Cafe", Category.DESPENSA),
    CEREALES("Cereales", Category.DESPENSA),
    CHOCOLATES_DE_MESA("Chocolates de mesa", Category.DESPENSA),
    CONDIMIENTOS_CALDOS_Y_SAL("Condimentos, caldos y sal", Category.DESPENSA),
    ENLATADOS_Y_CONSERVAS("Enlatados y conservas", Category.DESPENSA),
    HARINAS_Y_MEZCLAS("Harinas y mezclas", Category.DESPENSA),
    PASTAS("Pastas", Category.DESPENSA),
    SALSAS_Y_VINAGRES("Salsas y vinagres", Category.DESPENSA),
    TE_INFUSIONES_E_INSTANTANEOS("Te, infusiones e instantaneos", Category.DESPENSA),
    SALUD_Y_BIENESTAR("Salud y bienestar", Category.DROGUERIA),
    AREQUIPE("Arequipe", Category.DULCES_Y_POSTRES),
    CHOCOLATERIA("Chocolateria", Category.DULCES_Y_POSTRES),
    CONFETIS_Y_DULCES("Confetis y dulces", Category.DULCES_Y_POSTRES),
    CREMA_DE_LECHE_Y_LECHE_CONDENSADA("Crema de leche y leche condensada", Category.DULCES_Y_POSTRES),
    DULCES_TIPICOS("Dulces tipicos", Category.DULCES_Y_POSTRES),
    GELATINAS_FLANES_Y_PUDINES("Gelatinas, flanes y pudines", Category.DULCES_Y_POSTRES),
    REPOSTERIA("Reposteria", Category.DULCES_Y_POSTRES),
    ELECTRODOMESTICOS("Electrodomesticos", Category.ELECTRODOMESTICOS),
    HELADOS("Helados", Category.HELADOS),
    DESECHABLES("Desechables", Category.HOGAR_Y_DECORACION),
    BOMBILLOS("Bombillos", Category.ILUMINACION_ELECTRICOS),
    PILAS("Pilas", Category.ILUMINACION_ELECTRICOS),
    ALPINETTE("Alpinette", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    ALPINITO("Alpinito", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    AREPAS("Arepas", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    CARNES_FRIAS_Y_EMBUTIDOS("Carnes frias y embutidos", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    HUEVOS("Huevos",Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    KUMIS("Kumis", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    LECHE("Leche", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    LECHES_EN_POLVO("Leches en polvo", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    MANTEQUILLA("Mantequilla", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    MARGARINAS("Margarinas", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    QUESOS("Quesos", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    YOGURT("Yogurt", Category.LACTEOS_HUEVOS_Y_REFRIGERADOS),
    BOLSAS_DE_BASURA("Bolsas de basura", Category.LIMPIEZA_COCINA),
    ESPONJAS_Y_FIBRAS("Esponjas y fibras", Category.LIMPIEZA_COCINA),
    LAVALOZA("Lavaloza", Category.LIMPIEZA_COCINA),
    SERVILLETAS("Servilletas", Category.LIMPIEZA_COCINA),
    TRAPEROS_Y_ESCOBAS("Traperos y escobas", Category.LIMPIEZA_COCINA),
    AVES("Aves", Category.MASCOTAS),
    GATOS("Gatos", Category.MASCOTAS),
    HAMSTERS("Hamsters", Category.MASCOTAS),
    PERRO("Perro", Category.MASCOTAS),
    PEZ("Pez", Category.MASCOTAS),
    PANADERIA_EMPACADA("Panaderia empacada", Category.PANADERIA_Y_PASTELERIA),
    GALLETAS_DULCES("Galletas dulces", Category.PASABOCAS),
    GALLETAS_SALADAS("Galletas saladas", Category.PASABOCAS),
    GALLETAS_SALUDABLES("Galletas saludables", Category.PASABOCAS),
    PAPAS_FRITAS_Y_PAQUETES("Papas fritas y paquetes", Category.PASABOCAS),
    AGUARDIENTE("Aguardiente", Category.VINOS_Y_LICORES),
    BRANDY("Brandy", Category.VINOS_Y_LICORES),
    CERVEZA("Cerveza", Category.VINOS_Y_LICORES),
    GINEBRA("Ginebra", Category.VINOS_Y_LICORES),
    LICOR("Licor", Category.VINOS_Y_LICORES),
    RON("Ron", Category.VINOS_Y_LICORES),
    VINOS("Vinos", Category.VINOS_Y_LICORES),
    VODKA("Vodka", Category.VINOS_Y_LICORES),
    WHISKY("Whisky", Category.VINOS_Y_LICORES);

    private final String tagValue;
    private final Category category;

    CategoryTags(String tagValue, Category category) {
        this.tagValue = tagValue;
        this.category = category;
    }

    public String getTagValue() {
        return tagValue;
    }

    public Category getCategory() {
        return category;
    }

    //enum de etiquetas
//excepciones
}

