# Oasis Spa

Aplicacion de consola en Java para administrar personas, clientes, empleados, productos, inventario, pagos, reservas y servicios. El proyecto organiza la entrada y salida de datos con puertos para que la logica del negocio no dependa directamente de una interfaz ni de un tipo concreto de almacenamiento.

## Estructura del proyecto

```text
src/
|-- Domain/       Modelos del negocio
|-- Port/         Contratos de entrada y salida
|-- Repository/   Adaptadores de persistencia en memoria
|-- Service/      Casos de uso y validaciones
|-- View/         Menus y presentacion en consola
`-- Main.java     Configuracion e inicio de la aplicacion
```

## Que hace cada puerto

- `Port/InputPort<T>` define las operaciones que la aplicacion puede solicitar: crear, buscar por ID, listar, actualizar y eliminar.
- `Port/OutputPort<T>` define las operaciones que un servicio necesita del almacenamiento para ejecutar esos casos de uso.
- Cada clase de `Service` implementa `InputPort` para su entidad y conserva sus validaciones.
- Cada clase de `Repository` implementa `OutputPort` para su entidad. Actualmente, los repositorios guardan los datos en listas en memoria.
- `Main` ensambla los servicios y expone las operaciones a los menus mediante `InputPort`, sin acoplar los menus a clases de servicio concretas.

## Flujo de una operacion

```text
View / Main -> InputPort -> Service -> OutputPort -> Repository en memoria
```

Por ejemplo, al crear un cliente, el menu recoge los datos y llama a `InputPort<Customer>.create`. `CustomersService` valida el cliente y solicita su almacenamiento mediante `OutputPort<Customer>`. `CustomersRepository` realiza la operacion sobre su lista.

## Paso a paso: como se agregaron los puertos

1. **Definir el contrato de entrada.** Se creo `src/Port/InputPort.java` con las operaciones CRUD comunes. El parametro generico `T` permite usar el mismo contrato con cada entidad.
2. **Definir el contrato de salida.** Se creo `src/Port/OutputPort.java`, que declara las operaciones de almacenamiento que necesita un caso de uso.
3. **Conectar los repositorios al puerto de salida.** Los ocho repositorios CRUD (`Person`, `Customer`, `Employees`, `Products`, `Inventory`, `Payment`, `Reservation` y `Service`) implementan `OutputPort` para su tipo.
4. **Conectar los servicios a ambos lados.** Cada servicio implementa `InputPort` y recibe un `OutputPort<T>` por constructor. El constructor sin parametros sigue creando el repositorio actual en memoria, para mantener la ejecucion existente; el constructor con puerto permite inyectar otra implementacion.
5. **Usar el puerto de entrada desde la aplicacion.** `Main` declara los servicios como `InputPort<T>` y pasa ese contrato a cada menu. La consola no necesita conocer el tipo concreto de servicio.
6. **Sustituir almacenamiento cuando sea necesario.** Para usar una base de datos en el futuro, se puede crear un nuevo adaptador que implemente `OutputPort<T>` e inyectarlo en el constructor del servicio, sin cambiar las operaciones del menu.

## Como ejecutar

Se requiere un JDK compatible con las expresiones `switch` usadas por el proyecto (Java 17 o posterior).

Desde la carpeta raiz del proyecto, compila:

```powershell
javac -encoding UTF-8 -d out -sourcepath src src\Main.java
```

Luego inicia la aplicacion:

```powershell
java -cp out Main
```

Los repositorios son en memoria; por lo tanto, los registros se pierden al cerrar el programa.
