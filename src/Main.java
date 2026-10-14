import Domain.Customer;
import Domain.Employees;
import Domain.Inventory;
import Domain.Payment;
import Domain.Person;
import Domain.Products;
import Domain.Reservation;
import Domain.Service;
import Port.InputPort;
import Service.CustomersService;
import Service.EmployeesService;
import Service.InventoryService;
import Service.PaymetnService;
import Service.PersonService;
import Service.ProductsService;
import Service.ReservationService;
import Service.ServiceService;
import View.CustomersView;
import View.EmployeesView;
import View.InventoryView;
import View.PaymetnView;
import View.PersonView;
import View.ProductsView;
import View.ReservationView;
import View.ServiceView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Bienvenido a Oasis Spa ===");

        InputPort<Person> personService = new PersonService();
        InputPort<Customer> customersService = new CustomersService();
        InputPort<Employees> employeesService = new EmployeesService();
        InputPort<Products> productsService = new ProductsService();
        InputPort<Inventory> inventoryService = new InventoryService();
        InputPort<Payment> paymetnService = new PaymetnService();
        InputPort<Reservation> reservationService = new ReservationService();
        InputPort<Service> serviceService = new ServiceService();

        PersonView personView = new PersonView();
        CustomersView customersView = new CustomersView();
        EmployeesView employeesView = new EmployeesView();
        ProductsView productsView = new ProductsView();
        InventoryView inventoryView = new InventoryView();
        PaymetnView paymetnView = new PaymetnView();
        ReservationView reservationView = new ReservationView();
        ServiceView serviceView = new ServiceView();

        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int option = readInt("Selecciona una opciÃ³n: ");
            switch (option) {
                case 1 -> managePeople(personService, personView);
                case 2 -> manageCustomers(customersService, customersView);
                case 3 -> manageEmployees(employeesService, employeesView);
                case 4 -> manageProducts(productsService, productsView);
                case 5 -> manageInventory(inventoryService, inventoryView);
                case 6 -> managePayments(paymetnService, paymetnView);
                case 7 -> manageReservations(reservationService, reservationView);
                case 8 -> manageServices(serviceService, serviceView);
                case 0 -> { System.out.println("Gracias por usar Oasis Spa."); exit = true; }
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== MenÃº principal ===");
        System.out.println("1. Personas");
        System.out.println("2. Clientes");
        System.out.println("3. Empleados");
        System.out.println("4. Productos");
        System.out.println("5. Inventario");
        System.out.println("6. Pagos");
        System.out.println("7. Reservas");
        System.out.println("8. Servicios");
        System.out.println("0. Salir");
    }

    private static void managePeople(InputPort<Person> service, PersonView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n personas: ");
            switch (option) {
                case 1 -> {
                    Person person = new Person();
                    person.setId(readInt("ID: "));
                    person.setName(readString("Nombre: "));
                    person.setGender(readString("GÃ©nero: "));
                    person.setAge(readInt("Edad: "));
                    try { service.create(person); System.out.println("Persona creada correctamente."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showPeople(service.selectAll());
                case 3 -> {
                    Person found = service.selectById(readInt("ID a buscar: "));
                    System.out.println(found != null ? found : "No se encontrÃ³ la persona.");
                }
                case 4 -> {
                    Person person = service.selectById(readInt("ID a actualizar: "));
                    if (person == null) { System.out.println("No existe la persona."); break; }
                    person.setName(readString("Nuevo nombre: "));
                    person.setGender(readString("Nuevo gÃ©nero: "));
                    person.setAge(readInt("Nueva edad: "));
                    System.out.println(service.update(person) ? "Persona actualizada." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Persona eliminada." : "No se encontrÃ³ la persona.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageCustomers(InputPort<Customer> service, CustomersView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n clientes: ");
            switch (option) {
                case 1 -> {
                    Customer customer = new Customer();
                    customer.setId(readInt("ID: "));
                    customer.setName(readString("Nombre: "));
                    customer.setGender(readString("GÃ©nero: "));
                    customer.setAge(readInt("Edad: "));
                    customer.setPhone(readString("TelÃ©fono: "));
                    customer.setAddress(readString("DirecciÃ³n: "));
                    try { service.create(customer); System.out.println("Cliente registrado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showCustomers(service.selectAll());
                case 3 -> {
                    Customer customer = service.selectById(readInt("ID a buscar: "));
                    System.out.println(customer != null ? customer : "No se encontrÃ³ el cliente.");
                }
                case 4 -> {
                    Customer customer = service.selectById(readInt("ID a actualizar: "));
                    if (customer == null) { System.out.println("No existe el cliente."); break; }
                    customer.setName(readString("Nuevo nombre: "));
                    customer.setGender(readString("Nuevo gÃ©nero: "));
                    customer.setAge(readInt("Nueva edad: "));
                    customer.setPhone(readString("Nuevo telÃ©fono: "));
                    customer.setAddress(readString("Nueva direcciÃ³n: "));
                    System.out.println(service.update(customer) ? "Cliente actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Cliente eliminado." : "No se encontrÃ³ el cliente.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageEmployees(InputPort<Employees> service, EmployeesView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n empleados: ");
            switch (option) {
                case 1 -> {
                    Employees employee = new Employees();
                    employee.setId(readInt("ID: "));
                    employee.setName(readString("Nombre: "));
                    employee.setGender(readString("GÃ©nero: "));
                    employee.setAge(readInt("Edad: "));
                    employee.setIdService(readString("ID del servicio: "));
                    try { service.create(employee); System.out.println("Empleado creado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showEmployees(service.selectAll());
                case 3 -> {
                    Employees employee = service.selectById(readInt("ID a buscar: "));
                    System.out.println(employee != null ? employee : "No se encontrÃ³ el empleado.");
                }
                case 4 -> {
                    Employees employee = service.selectById(readInt("ID a actualizar: "));
                    if (employee == null) { System.out.println("No existe el empleado."); break; }
                    employee.setName(readString("Nuevo nombre: "));
                    employee.setGender(readString("Nuevo gÃ©nero: "));
                    employee.setAge(readInt("Nueva edad: "));
                    employee.setIdService(readString("Nuevo servicio: "));
                    System.out.println(service.update(employee) ? "Empleado actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Empleado eliminado." : "No se encontrÃ³ el empleado.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageProducts(InputPort<Products> service, ProductsView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n productos: ");
            switch (option) {
                case 1 -> {
                    Products product = new Products();
                    product.setId(readInt("ID: "));
                    product.setIdCustomer(readInt("ID Cliente: "));
                    product.setName(readString("Nombre: "));
                    product.setBrand(readString("Marca: "));
                    try { service.create(product); System.out.println("Producto creado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showProducts(service.selectAll());
                case 3 -> {
                    Products product = service.selectById(readInt("ID a buscar: "));
                    System.out.println(product != null ? product : "No se encontrÃ³ el producto.");
                }
                case 4 -> {
                    Products product = service.selectById(readInt("ID a actualizar: "));
                    if (product == null) { System.out.println("No existe el producto."); break; }
                    product.setName(readString("Nuevo nombre: "));
                    product.setBrand(readString("Nueva marca: "));
                    System.out.println(service.update(product) ? "Producto actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Producto eliminado." : "No se encontrÃ³ el producto.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageInventory(InputPort<Inventory> service, InventoryView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n inventario: ");
            switch (option) {
                case 1 -> {
                    Inventory inventory = new Inventory();
                    inventory.setId(readInt("ID: "));
                    inventory.setQuantity(readInt("Cantidad: "));
                    inventory.setMinimumStock(readInt("Stock mÃ­nimo: "));
                    inventory.setIdProduct(readInt("ID Producto: "));
                    inventory.setLastUpdate(new Date());
                    try { service.create(inventory); System.out.println("Inventario registrado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showInventory(service.selectAll());
                case 3 -> {
                    Inventory inventory = service.selectById(readInt("ID a buscar: "));
                    System.out.println(inventory != null ? inventory : "No se encontrÃ³ el registro.");
                }
                case 4 -> {
                    Inventory inventory = service.selectById(readInt("ID a actualizar: "));
                    if (inventory == null) { System.out.println("No existe el registro."); break; }
                    inventory.setQuantity(readInt("Nueva cantidad: "));
                    inventory.setMinimumStock(readInt("Nuevo mÃ­nimo: "));
                    System.out.println(service.update(inventory) ? "Inventario actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Registro eliminado." : "No se encontrÃ³ el registro.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void managePayments(InputPort<Payment> service, PaymetnView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n pagos: ");
            switch (option) {
                case 1 -> {
                    Payment payment = new Payment();
                    payment.setId(readInt("ID: "));
                    payment.setAmount(readDouble("Monto: "));
                    payment.setPaymentMethod(readString("MÃ©todo de pago: "));
                    payment.setPaymentDate(new Date());
                    payment.setStatus(readString("Estado: "));
                    try { service.create(payment); System.out.println("Pago registrado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showPayments(service.selectAll());
                case 3 -> {
                    Payment payment = service.selectById(readInt("ID a buscar: "));
                    System.out.println(payment != null ? payment : "No se encontrÃ³ el pago.");
                }
                case 4 -> {
                    Payment payment = service.selectById(readInt("ID a actualizar: "));
                    if (payment == null) { System.out.println("No existe el pago."); break; }
                    payment.setAmount(readDouble("Nuevo monto: "));
                    payment.setPaymentMethod(readString("Nuevo mÃ©todo: "));
                    payment.setStatus(readString("Nuevo estado: "));
                    System.out.println(service.update(payment) ? "Pago actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Pago eliminado." : "No se encontrÃ³ el pago.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageReservations(InputPort<Reservation> service, ReservationView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n reservas: ");
            switch (option) {
                case 1 -> {
                    Reservation reservation = new Reservation();
                    reservation.setId(readInt("ID: "));
                    reservation.setIdCustomer(readInt("ID Cliente: "));
                    reservation.setIdService(readInt("ID Servicio: "));
                    reservation.setIdEmployee(readInt("ID Empleado: "));
                    reservation.setReservationTime(readString("Hora (HH:mm): "));
                    reservation.setStatus(readString("Estado: "));
                    reservation.setNotes(readString("Notas: "));
                    try {
                        reservation.setReservationDate(parseDate(readString("Fecha (yyyy-MM-dd): ")));
                        service.create(reservation);
                        System.out.println("Reserva creada.");
                    } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                    catch (ParseException e) { System.out.println("Formato de fecha invÃ¡lido. Usa yyyy-MM-dd"); }
                }
                case 2 -> view.showReservations(service.selectAll());
                case 3 -> {
                    Reservation reservation = service.selectById(readInt("ID a buscar: "));
                    System.out.println(reservation != null ? reservation : "No se encontrÃ³ la reserva.");
                }
                case 4 -> {
                    Reservation reservation = service.selectById(readInt("ID a actualizar: "));
                    if (reservation == null) { System.out.println("No existe la reserva."); break; }
                    reservation.setStatus(readString("Nuevo estado: "));
                    reservation.setNotes(readString("Nuevas notas: "));
                    System.out.println(service.update(reservation) ? "Reserva actualizada." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Reserva eliminada." : "No se encontrÃ³ la reserva.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static void manageServices(InputPort<Service> service, ServiceView view) {
        boolean back = false;
        while (!back) {
            view.showMenu();
            int option = readInt("OpciÃ³n servicios: ");
            switch (option) {
                case 1 -> {
                    Service serviceItem = new Service();
                    serviceItem.setId(readInt("ID: "));
                    serviceItem.setDescription(readString("DescripciÃ³n: "));
                    serviceItem.setBenefit(readString("Beneficio: "));
                    serviceItem.setPhoto(readString("Foto: "));
                    serviceItem.setDuration(readInt("DuraciÃ³n (min): "));
                    serviceItem.setStatus(readString("Estado: "));
                    try { service.create(serviceItem); System.out.println("Servicio registrado."); } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage()); }
                }
                case 2 -> view.showServices(service.selectAll());
                case 3 -> {
                    Service serviceItem = service.selectById(readInt("ID a buscar: "));
                    System.out.println(serviceItem != null ? serviceItem : "No se encontrÃ³ el servicio.");
                }
                case 4 -> {
                    Service serviceItem = service.selectById(readInt("ID a actualizar: "));
                    if (serviceItem == null) { System.out.println("No existe el servicio."); break; }
                    serviceItem.setDescription(readString("Nueva descripciÃ³n: "));
                    serviceItem.setBenefit(readString("Nuevo beneficio: "));
                    serviceItem.setDuration(readInt("Nueva duraciÃ³n: "));
                    serviceItem.setStatus(readString("Nuevo estado: "));
                    System.out.println(service.update(serviceItem) ? "Servicio actualizado." : "No se pudo actualizar.");
                }
                case 5 -> {
                    int id = readInt("ID a eliminar: ");
                    System.out.println(service.delete(id) ? "Servicio eliminado." : "No se encontrÃ³ el servicio.");
                }
                case 0 -> back = true;
                default -> System.out.println("OpciÃ³n invÃ¡lida.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invÃ¡lida. Debe ser un nÃºmero.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invÃ¡lida. Debe ser un nÃºmero decimal.");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static Date parseDate(String dateText) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        return format.parse(dateText);
    }
}