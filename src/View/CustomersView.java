package View;

import Domain.Customer;
import java.util.List;

public class CustomersView {
    public void showMenu() {
        System.out.println("\n--- Clientes ---");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Volver");
    }

    public void showCustomers(List<Customer> customers) {
        if (customers.isEmpty()) { System.out.println("No hay clientes registrados."); return; }
        for (Customer customer : customers) System.out.println(customer);
    }
}