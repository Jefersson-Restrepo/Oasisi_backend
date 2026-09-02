package Domain;

public class Service {

    // Atributos según el UML
    private int id;
    private String description;
    private String benefit;
    private String photo;
    private int time;
    private String status; // Aquí va el estado ("Disponible", "Inactivo", etc.)

    public Service() {
    }

    public Service(int id, String description, String benefit, String photo, int time, String status) {
        this.id = id;
        this.description = description;
        this.benefit = benefit;
        this.photo = photo;
        this.time = time;
        this.status = status;
    }

    // Métodos CRUD + changeStatus
    public void create() {}
    public void selectById(int id) {}
    public void selectAll() {}
    public void update() {}
    public void deleteById(int id) {}
    public void changeStatus() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBenefit() { return benefit; }
    public void setBenefit(String benefit) { this.benefit = benefit; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public int getTime() { return time; }
    public void setTime(int time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}