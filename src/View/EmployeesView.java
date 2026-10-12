package View;

import Domain.Employees;
import java.util.List;

public class EmployeesView {
    public void showMenu() {
        System.out.println("\n--- Empleados ---");
        System.out.println("1. Crear empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Buscar empleado");
        System.out.println("4. Actualizar empleado");
        System.out.println("5. Eliminar empleado");
        System.out.println("0. Volver");
    }

    public void showEmployees(List<Employees> employees) {
        if (employees.isEmpty()) { System.out.println("No hay empleados registrados."); return; }
        for (Employees employee : employees) System.out.println(employee);
    }
}