package Domain;

public class Service {

    // Atributos según el UML
    private int id;
    private String description;
    private int idEmployer;
    private double price;
    private int time;
    private String benefit;
    private String photo;

    public Service(int id,String description,int IdEmployer, double price, int time,String benefit,String Photo) {
        this.id = id;
        this.description = description;
        this.idEmployer = IdEmployer;
        this.price = price;
        this.time = time;
        this.benefit = benefit;
        this.photo = photo;
    }

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

    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}