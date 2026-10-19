package Service;

import Domain.ServiceStatus;

public class ServiceStatusService {
    public void changeStatus(ServiceStatus status) {
        if (status == null) throw new IllegalArgumentException("El estado no puede estar vacio.");
        System.out.println("Estado actualizado a: " + status);
    }
}