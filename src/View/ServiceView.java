
import Domain.Service;
import java.util.List;

public class ServiceView {
    public void showMenu() {
        System.out.println("\n--- Servicios ---");
        System.out.println("1. Crear servicio");
        System.out.println("2. Listar servicios");
        System.out.println("3. Buscar servicio");
        System.out.println("4. Actualizar servicio");
        System.out.println("5. Eliminar servicio");
        System.out.println("0. Volver");
    }

    public void showServices(List<Service> services) {
        if (services.isEmpty()) { System.out.println("No hay servicios registrados."); return; }
        for (Service serviceItem : services) System.out.println(serviceItem);
    }
}
