package Domain;

public class Employees extends Person {
    private String idService;

    public Employees() { super(); }

    public Employees(int id, String name, String gender, int age, String idService) {
        super(id, name, gender, age);
        this.idService = idService;
    }

    public String getIdService() { return idService; }
    public void setIdService(String idService) { this.idService = idService; }

    @Override
    public String toString() {
        return "Employees{id=" + getId() + ", name='" + getName() + "', gender='" + getGender() + "', age=" + getAge() + ", idService='" + idService + "'}";
    }
}