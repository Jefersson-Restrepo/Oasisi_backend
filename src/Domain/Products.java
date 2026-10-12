package Domain;

public class Products {
    private int id;
    private int idCustomer;
    private String name;
    private String brand;

    public Products() { }

    public Products(int id, int idCustomer, String name, String brand) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.name = name;
        this.brand = brand;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdCustomer() { return idCustomer; }
    public void setIdCustomer(int idCustomer) { this.idCustomer = idCustomer; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public String toString() {
        return "Products{id=" + id + ", idCustomer=" + idCustomer + ", name='" + name + "', brand='" + brand + "'}";
    }
}