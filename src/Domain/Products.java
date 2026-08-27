package Domain;

public class Products {
    // 1. Atributos (en minúscula)
    private int id;
    private int idCustomer;
    private String name;
    private String brand;

    // 2. Constructor vacío
    public Products() {
    }

    // 3. Constructor con parámetros
    // this.id: se  refiere al atributo de la clase ( es la variable de la propiedad del objeto)
    // id (sin el this): Hace referencia al parámetro (el valor temporal que entra por los paréntesis).

    public Products(int id, int idCustomer, String name, String brand) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.name = name;
        this.brand = brand;
    }

    // 4. Métodos Getters y Setters (DENTRO de las llaves de la clase)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
} // La llave final...
