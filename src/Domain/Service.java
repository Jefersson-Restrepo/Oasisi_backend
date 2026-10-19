package Domain;

public class Service {
    private int id;
    private String description;
    private String benefit;
    private String photo;
    private int duration;
    private ServiceStatus status = ServiceStatus.DISPONIBLE;

    public Service() { }

    public Service(int id, String description, String benefit, String photo, int duration, ServiceStatus status) {
        this.id = id;
        this.description = description;
        this.benefit = benefit;
        this.photo = photo;
        this.duration = duration;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getBenefit() { return benefit; }
    public void setBenefit(String benefit) { this.benefit = benefit; }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public ServiceStatus getStatus() { return status; }
    public void setStatus(ServiceStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Service{id=" + id + ", description='" + description + "', benefit='" + benefit + "', photo='" + photo + "', duration=" + duration + ", status='" + status + "'}";
    }
}