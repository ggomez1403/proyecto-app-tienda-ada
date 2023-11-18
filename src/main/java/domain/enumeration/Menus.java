package domain.enumeration;

public enum Menus {
    MAIN_MENU("""
        |o|                         /////////////\\\\\\
        |o|                        (((((((((((((   \\\\\\
        |o|                        ))) ~~      ~~   (((
        |o|                        ((( (*)     (*)  )))
        |o|                        )))     <        (((\s
        |o|                        ((( '\\______/`   )))\s
        |o|                        )))\\___________/(((\s
        |o|                        (((   _)  (_    )))\s\s
        |o|                              /\\__/\\);
        ±----------------------------------------±
        |   Administrador Mi Tienda de Barrio    |
        ±----------------------------------------±
        | 1. Gestionar de productos              |
        | 2. Gestionar ventas y facturas         |
        | 3. Salir                               |
        ±----------------------------------------±
           Ingresa tu opción:    (1 - 3):
       """),

    UPDATE_PRODUCT_MENU("""
        ±------------------------------------------------±
        |   Seleccione el campo que desea actualizar:    |
        ±------------------------------------------------±
        | 1. Nombre                                      |
        | 2. Descripcion                                 |
        | 3. Precio                                      |
        | 4. Cantidad de stock                           |
        | 5. Categoria y etiqueta                        |
        | 6. URL de la foto                              |
        | 7. Cancelar                                    |
        ±------------------------------------------------±
                Select the value to update (1 - 7):
            """),

    MANAGE_PRODUCTS_MENU("""
        ±----------------------------------------±
        |   Gestionar productos de la tienda     |
        ±----------------------------------------±
        | 1. Agregar producto                    |
        | 2. Eliminar producto                   |
        | 3. Actualizar producto                 |
        | 4. Ver todos los productos             |
        | 5. Buscar producto por nombre          |
        | 6. Buscar producto por categoria       |
        | 7. Regresar                            |
        ±----------------------------------------±
           Ingresa tu opción:    (1 - 7):
            """),

    MANAGE_BILLS_MENU("""
        ±----------------------------------------±
        |      Gestionar facturas de venta       |
        ±----------------------------------------±
        | 1. Crear factura de producto           |
        | 2. Buscar factura por cliente          |
        | 3. Ver historial de facturas           |
        | 4. Regresar                            |
        ±----------------------------------------±
           Ingresa tu opción:    (1 - 4):
            """);

    private final String value;

    Menus(String value) {
        this.value = value;
    }

    public void getValue() {
        System.out.println(value);
    }
}
