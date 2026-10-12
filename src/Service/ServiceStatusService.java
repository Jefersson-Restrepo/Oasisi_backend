package Service;

public class ServiceStatusService {
    public void changeStatus(String status) {
        if (status == null || status.isBlank()) throw new IllegalArgumentException("El estado no puede estar vacÃ­o.");
        System.out.println("Estado actualizado a: " + status);
    }
}