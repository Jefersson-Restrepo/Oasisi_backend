package Domain;

public class Service {
    private int id;
    private String description;
    private String benefit;
    private String photo;
    private int duration;
    private String status;

    public Service() { }

    public Service(int id, String description, String benefit, String photo, int duration, String status) {
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
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Service{id=" + id + ", description='" + description + "', benefit='" + benefit + "', photo='" + photo + "', duration=" + duration + ", status='" + status + "'}";
    }
}