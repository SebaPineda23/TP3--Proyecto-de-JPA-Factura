# TP Venta de Artículos

# Proyecto de Gestión de Ventas de Artículos

Este proyecto es una aplicación de gestión de ventas de artículos que utiliza una base de datos H2 en memoria y está desarrollado únicamente con Gradle como herramienta de construcción.

## Descripción

La aplicación permite gestionar entidades como `Cliente`, `Domicilio`, `Factura`, `Categoria`, `Articulo`, y `DetalleFactura`. El proceso de persistencia de estas entidades se realiza utilizando JPA con Hibernate como proveedor de persistencia. La base de datos H2 se utiliza como base de datos en memoria, lo que facilita la ejecución y prueba del proyecto sin necesidad de configurar una base de datos externa.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- **Entidad `Domicilio`**: Representa la dirección de un cliente.
- **Entidad `Cliente`**: Contiene la información del cliente y su relación con un domicilio.
- **Entidad `Factura`**: Almacena la información de una venta, incluyendo el cliente y los detalles de la factura.
- **Entidad `Categoria`**: Representa la categoría de los artículos.
- **Entidad `Articulo`**: Define los productos con sus precios y categorías.
- **Entidad `DetalleFactura`**: Registra la cantidad y subtotal de los artículos incluidos en una factura.

## Implementación del Servicio

En lugar de implementar la lógica de negocio en el método `main`, se ha creado un servicio dedicado que maneja toda la lógica de persistencia. Este servicio se encuentra en la clase `MyService` y está anotado con `@Service` para indicar que es un componente de Spring.

El método `run()` de `MyService` realiza las siguientes acciones:

1. **Persistir el Domicilio**: Se crea y persiste una instancia de `Domicilio`.
2. **Persistir el Cliente**: Se crea una instancia de `Cliente`, se asocia con el `Domicilio` previamente creado, y luego se persiste.
3. **Persistir la Factura**: Se crea una instancia de `Factura` y se asocia con el `Cliente`.
4. **Persistir Categorías y Artículos**: Se crean y persisten instancias de `Categoria` y `Articulo`, estableciendo las relaciones necesarias.
5. **Persistir Detalles de Factura**: Se crean y persisten los detalles de la factura, asociando artículos y cantidades.
6. **Persistir la Factura**: Finalmente, se persiste la `Factura` completa con todos sus detalles.

Este enfoque modulariza el código, facilita su mantenimiento y aprovecha las características transaccionales de Spring, manejadas automáticamente por la anotación `@Transactional`.

## Base de Datos H2

La aplicación utiliza H2, una base de datos en memoria que es extremadamente útil para pruebas y desarrollo. La configuración predeterminada en el proyecto permite ejecutar la aplicación sin necesidad de ninguna configuración adicional de la base de datos.

### Acceso a la Consola de H2

Puedes acceder a la consola web de H2 para visualizar las tablas y datos creados durante la ejecución de la aplicación. La URL de acceso es la siguiente:

http://localhost:8080/h2-console

Las credenciales de acceso y el URL de la base de datos suelen estar configurados en el archivo `application.properties` de Spring Boot.

## Construcción y Ejecución

Este proyecto está configurado y construido usando **solo Gradle**. Para ejecutar la aplicación, sigue los siguientes pasos:

1. Clona el repositorio.
2. Navega a la carpeta del proyecto.
3. Ejecuta el comando `./gradlew bootRun` en la terminal.

Esto iniciará la aplicación y configurará la base de datos H2 en memoria.

## Conclusión

Este proyecto demuestra cómo implementar una aplicación básica de gestión de ventas utilizando Spring Boot, JPA, Hibernate, H2, y Gradle. La lógica de persistencia se ha encapsulado dentro de un servicio para promover una arquitectura más limpia y manejable.



