# Oasis Spa

 practicar clases, objetos, herencia y enumeraciones. Permite registrar personas, clientes, empleados, productos, inventario, pagos, reservas y servicios.

## Carpetas del proyecto

```text
src/
|-- Domain/       Clases que representan cosas del negocio
|-- Port/         Operaciones que usan los servicios y repositorios
|-- Repository/   Guarda y busca los datos
|-- Service/      Revisa los datos antes de guardarlos
|-- View/         Muestra los menus de la consola
|-- Config/       Configuracion de la base de datos SQLite
`-- Main.java     Inicia el programa y conecta las clases
```

Los clientes se guardan en SQLite mediante este recorrido:

```text
Main -> Service -> Repository -> SQLite (data/oasis-spa.db)
```

El resto de las entidades todavia se guarda en listas mientras el programa esta abierto.

## Paso a paso: crear una clase del dominio

Una clase de `Domain` representa un elemento del negocio. Por ejemplo, `Service` representa un servicio que ofrece el spa.

1. Crea un archivo `Service.java` dentro de `src/Domain`.
2. Escribe `package Domain;` en la primera linea. Esto indica en que paquete esta la clase.
3. Declara la clase y sus datos como privados para que se consulten y cambien por medio de metodos.
4. Agrega un constructor para crear objetos y metodos `get` y `set` para trabajar con sus datos.
5. Usa la clase en otro paquete con un `import`, por ejemplo `import Domain.Service;`.

Ejemplo reducido:

```java
package Domain;

public class Service {
    private int id;
    private String description;

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
```

`private` protege los datos. `getId` permite leer el identificador y `setId` permite cambiarlo. `this.id` se refiere al dato guardado dentro del objeto.

## Paso a paso: crear y usar un enum

Un `enum` se usa cuando un dato solo puede tener unas opciones conocidas. El estado de un servicio, por ejemplo, puede ser disponible, ocupado o en mantenimiento.

1. Crea `ServiceStatus.java` dentro de `src/Domain`.
2. Escribe su paquete y declara las opciones permitidas.
3. Importa `Domain.ServiceStatus` donde se necesite el estado.
4. Declara el campo con ese tipo. Asi Java no acepta palabras inventadas como estado.
5. Al pedirlo en la consola, muestra las opciones y guarda la opcion elegida.

En este proyecto, el enum queda asi:

```java
package Domain;

public enum ServiceStatus {
    DISPONIBLE,
    OCUPADO,
    MANTENIMIENTO
}
```

La clase `Service` guarda el estado como `ServiceStatus`, y `Main` convierte la opcion del menu en uno de esos tres valores.

## Como funcionan los paquetes y los imports

- `package Domain;` va al principio de un archivo y declara a que carpeta logica pertenece.
- `import Domain.Service;` permite usar la clase `Service` que esta en `Domain`.
- `import java.util.Date;` permite usar una clase que viene con Java.
- No se necesita un `import` para clases que estan en el mismo paquete.
- El nombre del paquete debe coincidir con el que declaran los archivos. Por eso cada vista, incluida `ServiceView`, empieza con `package View;`.

## Como ejecutar

Se requiere Java 17 o posterior y Maven. Desde la carpeta principal del proyecto, compila y ejecuta:

```powershell
mvn clean compile
mvn exec:java
```

Maven descarga el controlador JDBC de SQLite. En IntelliJ, abre o recarga el proyecto como proyecto Maven y ejecuta `Main`; el controlador debe estar en el classpath. La base se crea automaticamente en `data/oasis-spa.db` y los clientes permanecen guardados al cerrar el programa. Para cambiar la ubicacion, define la propiedad Java `-Doasis.db.path=ruta/a/archivo.db`.
