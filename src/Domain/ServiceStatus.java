package Domain;

public class ServiceStatus {
    // 1. Atributos
    private int id;
    private String description;

    // 2. Constructor vacío
    public ServiceStatus() {
    }

    // 3. Constructor con parámetros
    public ServiceStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // 4. Getters y Setters (SIN @Override)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} // La clase debe cerrarse AQUÍ al final del archivo
