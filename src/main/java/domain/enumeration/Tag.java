package domain.enumeration;

public enum Tag {
    AMBIENTADORES(1, "Ambientadores"),
    BLANQUEADORES(2, "Blanqueadores"),
    CERA(3, "Cera"),
    DESINFECTANTE(4, "Desinfectante"),
    INSECTICIDAS(5, "Insecticidas"),
    LIMPIEZA_SUPERFICIE(6, "Limpieza de superficie"),
    AGUA(7, "Bebidas"),
    ENERGIZANTES(8, "Energizantes"),
    GASEOSAS(9, "Gaseosas"),
    HIDRATANTES(10, "Hidratantes"),
    JUGOS_REFRESCOS_MALTAS(11, "Jugos, refescos y maltas"),
    TE_LIQUIDO(12, "Te liquido"),
    CONGELADOS(13, "Congelados"),
    EMPANADAS(14, "Empadadas"),
    PAPAS_YUCAS_Y_PATACONES(15, "Papas, yucas y patacones"),
    CIGARRILLOS(16, "Cigarrillos"),
    ALIMENTACION(17, "Alimentacion"),
    PAÑALES(18, "Pañales"),
    PAÑITOS(19, "Pañitos"),
    AFEITADO(20, "Afeitado"),
    CREMAS_CORPORALES(21, "Cremas corporales"),
    CUIDADO_ORAL(22, "Cuidado oral"),
    DESODORANTES(23, "Desodorantes"),
    GEL(24, "Gel"),
    JABONES_TOCADOR(25, "Jabones de tocador"),
    PAPEL_HIGIENICO(26, "Papel higienico"),
    PROTECCION_FEMENINA(27, "Proteccion Femenina"),
    SHAMPOO(28, "Shampoo"),
    DETERGENTES(29, "Detergentes"),
    JABONES_BARRA(30, "Jabones en barra"),
    ACEITES(31, "Aceites"),
    ARROZ_Y_GRANOS(32, "Arroz y granos"),
    AVENA(33, "Avena"),
    AZUCAR_Y_PANELAS(34, "Azucar y panelas"),
    BASES_CREMAS_Y_SOPAS(35, "Bases, remas y sopas"),
    BEBIDAS_ACHOCOLADATAS_EN_POLVO(36, "Bebidas achocolatadas en polvo"),
    CAFE(37, "Cafe"),
    CEREALES(38, "Cereales"),
    CHOCOLATES_DE_MESA(39, "Chocolates de mesa"),
    CONDIMIENTOS_CALDOS_Y_SAL(40, "Condimentos, caldos y sal"),
    ENLATADOS_Y_CONSERVAS(41, "Enlatados y conservas"),
    HARINAS_Y_MEZCLAS(42, "Harinas y mezclas"),
    PASTAS(43, "Pastas"),
    SALSAS_Y_VINAGRES(44, "Salsas y vinagres"),
    TE_INFUSIONES_E_INSTANTANEOS(45, "Te, infusiones e instantaneos"),
    SALUD_Y_BIENESTAR(46, "Salud y bienestar"),
    AREQUIPE(47, "Arequipe"),
    CHOCOLATERIA(48, "Chocolateria"),
    CONFETIS_Y_DULCES(49, "Confetis y dulces"),
    CREMA_DE_LECHE_Y_LECHE_CONDENSADA(50, "Crema de leche y leche condensada"),
    DULCES_TIPICOS(51, "Dulces tipicos"),
    GELATINAS_FLANES_Y_PUDINES(52, "Gelatinas, flanes y pudines"),
    REPOSTERIA(53, "Reposteria"),
    ELECTRODOMESTICOS(54, "Electrodomesticos"),
    HELADOS(55, "Helados"),
    DESECHABLES(56, "Desechables"),
    BOMBILLOS(57, "Bombillos"),
    PILAS(58, "Pilas"),
    ALPINETTE(59, "Alpinette"),
    ALPINITO(60, "Alpinito"),
    AREPAS(61, "Arepas"),
    CARNES_FRIAS_Y_EMBUTIDOS(62, "Carnes frias y embutidos"),
    HUEVOS(63, "Huevos"),
    KUMIS(64, "Kumis"),
    LECHE(65, "Leche"),
    LECHES_EN_POLVO(66, "Leches en polvo"),
    MANTEQUILLA(67, "Mantequilla"),
    MARGARINAS(68, "Margarinas"),
    QUESOS(69, "Quesos"),
    YOGURT(70, "Yogurt"),
    BOLSAS_DE_BASURA(71, "Bolsas de basura"),
    ESPONJAS_Y_FIBRAS(72, "Esponjas y fibras"),
    LAVALOZA(73, "Lavaloza"),
    SERVILLETAS(74, "Servilletas"),
    TRAPEROS_Y_ESCOBAS(75, "Traperos y escobas"),
    AVES(76, "Aves"),
    GATOS(77, "Gatos"),
    HAMSTERS(78, "Hamsters"),
    PERRO(79, "Perro"),
    PEZ(80, "Pez"),
    PANADERIA_EMPACADA(81, "Panaderia empacada"),
    GALLETAS_DULCES(82, "Galletas dulces"),
    GALLETAS_SALADAS(83, "Galletas saladas"),
    GALLETAS_SALUDABLES(84, "Galletas saludables"),
    PAPAS_FRITAS_Y_PAQUETES(85, "Papas fritas y paquetes"),
    AGUARDIENTE(86, "Aguardiente"),
    BRANDY(87, "Brandy"),
    CERVEZA(88, "Cerveza"),
    GINEBRA(89, "Ginebra"),
    LICOR(90, "Licor"),
    RON(91, "Ron"),
    VINOS(92, "Vinos"),
    VODKA(93, "Vodka"),
    WHISKY(94, "Whisky");

    private final String tagValue;
    private int id;

    Tag(int id, String tagValue) {
        this.tagValue = tagValue;
        this.id = id;
    }

    public String getTagValue() {
        return tagValue;
    }

    public int getId() {
        return id;
    }

    public static Tag getTagById(int tagId) {
        for (Tag tag : Tag.values()) {
            if (tag.getId() == tagId) {
                return tag;
            }
        }
        return null;
    }
}

