# Exposicion: registro de clientes con SQLite

## Problema que se resuelve

Antes, `CustomersRepository` guardaba los clientes en una lista (`ArrayList`). Esa lista existe solamente mientras el programa esta abierto: al cerrar la aplicacion, los datos desaparecen. Por eso, al volver a ejecutarla, el listado podia aparecer vacio.

Ademas, `out` contenia archivos `.class`, que son resultados compilados de los archivos fuente. El codigo que se debe editar esta en `src`; los archivos de `out` no son otra version del proyecto y se pueden volver a generar.

## Arquitectura

```text
Main -> CustomersView -> CustomersService -> CustomersRepository -> SQLite
                                                            |
                                                            v
                                                     data/oasis-spa.db
```

- **Main:** muestra el menu y coordina las clases.
- **CustomersView:** presenta las opciones y el listado en la consola.
- **CustomersService:** valida los datos del cliente antes de guardarlos.
- **CustomersRepository:** ejecuta las consultas SQL para crear, buscar, listar, actualizar y eliminar clientes.
- **DatabaseConfig:** configura la ubicacion del archivo de la base de datos.
- **SQLite:** almacena los registros en `data/oasis-spa.db`, sin necesitar un servidor de base de datos.

## Recorrido al registrar un cliente

1. En el menu, se elige **Clientes** y despues **Registrar cliente**.
2. Se ingresan el ID, nombre, genero, edad, telefono y direccion.
3. `CustomersService` verifica que el ID sea positivo, que el nombre y el telefono no esten vacios, que la edad este entre 1 y 120, y que no exista ya un cliente con el mismo ID.
4. `CustomersRepository` ejecuta un `INSERT` con parametros. La tabla se crea automaticamente la primera vez que se inicia el programa.
5. Al listar clientes, el repositorio consulta SQLite y muestra los registros. Los datos permanecen despues de cerrar y volver a abrir la aplicacion.

Las operaciones de busqueda, actualizacion y eliminacion tambien consultan la base de datos, no una copia en memoria. Si ocurre un error SQL, se informa en lugar de presentarlo como un registro exitoso.

## Como demostrarlo

1. Abre o recarga el proyecto Maven en IntelliJ y espera a que descargue `sqlite-jdbc`.
2. Ejecuta `Main`.
3. Entra a **Clientes -> Registrar cliente** y guarda un cliente con un ID que no se haya usado.
4. Usa **Listar clientes** para mostrar el registro.
5. Cierra el programa, ejecutalo de nuevo y vuelve a listar. El mismo cliente debe seguir apareciendo.
6. Explica que la base se encuentra en `data/oasis-spa.db` y que `out` no se necesita para conservar el codigo fuente.

Para compilar y ejecutar desde PowerShell, en la carpeta del proyecto:

```powershell
mvn clean compile
mvn exec:java
```

## Guion breve para presentar

> El problema era que los clientes se guardaban en una lista de Java. La lista se borraba al cerrar el programa, por eso los registros no aparecian al iniciarlo otra vez. Mantuvimos la organizacion por capas: la vista recibe la opcion, el servicio valida los datos y el repositorio los guarda con JDBC en SQLite. SQLite crea un archivo local, por lo que no hace falta levantar un servidor. Para comprobar la persistencia, registro un cliente, cierro la aplicacion y la vuelvo a abrir; el cliente sigue en el listado. La carpeta `src` contiene el codigo fuente y `out` eran copias compiladas que no hace falta conservar.

## Alcance actual

SQLite se conecto unicamente al modulo de clientes. Personas, empleados, productos, inventario, pagos, reservas y servicios todavia usan sus repositorios en memoria, por lo que sus datos no persisten al cerrar el programa.
