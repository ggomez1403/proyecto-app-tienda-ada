# Diagrama UML || Aplicacion para la gestion de una tienda de barrio

**Clase Store:**

- Punto de entrada principal del programa.
- Inicializa un menú de la tienda y maneja las opciones del usuario.

**Clase Bill:**

- Modela una factura que incluye un número de factura, una fecha, un cliente y una lista de elementos de factura.
- Puede agregar elementos a la factura, calcular el total y proporcionar información sobre la factura.

**Clase BillItem:**

- Modela un elemento de factura que contiene un producto y una cantidad.

**Clase Client:**

- Modela a un cliente con un identificador, nombre y dirección.

**Clase Menu:**

- Proporciona un menú de texto para administrar la tienda.
- Muestra el menú en la consola.
- Gestiona las opciones del usuario y llama a los métodos correspondientes.
- Ofrece funcionalidades para agregar, eliminar, actualizar, buscar productos, crear facturas y ver historiales de facturas.

**Enum Category:**

- Enumeración que define las categorías de productos.
- Proporciona métodos para obtener valores de categorías y mostrar todas las categorías disponibles.

**Clase Product:**

- Modela un producto con propiedades como nombre, descripción, precio, stock, categorías, etiquetas y URL de la foto.
- Ofrece métodos para verificar el stock, comparar precios, buscar palabras clave y formatear la salida.

**Clase ProductsArray:**

- Administra una lista de productos.
- Permite agregar, eliminar, actualizar y buscar productos, así como mostrar productos por letra y orden alfabético.

## Diagrama UML

![Diagrama UML](./Diagrama%20Tienda.drawio.png)
