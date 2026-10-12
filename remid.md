# Proyecto Oasis Spa




## se Organiza uml de la siguiente manera
- Domain: modelos y clases de negocio
- Repository: almacenamiento en memoria y operaciones CRUD
- Service: validaciones y lógica de negocio
- View: menús y visualización
- ✅ Compila correctamente
- ✅ Se ejecuta con menú interactivo
- ✅ Tiene CRUD básico en las entidades principales
- ✅ Incluye validaciones simples por entidad

## Entidades principales
- Person
- Customer
- Employees
- Products
- Inventory
- Payment
- Reservation
- Service

## Capas del proyecto
- Domain: modelos y clases de negocio
- Repository: almacenamiento en memoria y operaciones CRUD
- Service: validaciones y lógica de negocio
- View: menús y visualización
- Main: punto de entrada del programa

## Cómo ejecutar
1. Abrir una terminal en la carpeta del proyecto.
2. Verificar que el JDK esté instalado.
3. Ejecutar el siguiente comando:

```bash
java -cp out Main
```

## Menú principal disponible
- Personas
- Clientes
- Empleados
- Productos
- Inventario
- Pagos
- Reservas
- Servicios

## Funcionalidades implementadas
- Crear registros
- Listar registros
- Buscar por ID
- Actualizar datos
- Eliminar registros
- Validaciones mínimas de entrada

## Observación
La carpeta `out` se genera automáticamente al compilar y puede eliminarse sin afectar el código fuente, ya que contiene archivos compilados de Java.

## Siguiente paso recomendado
Si quieres, se puede continuar con:
- mejoras visuales del menú,
- base de datos real,
- interfaz gráfica,
- o una versión todavía más cercana al UML original.
