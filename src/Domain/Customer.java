package Domain;

public class Customer extends Person {

    // 1. Constructor vacío
    public Customer() {
        super();
    }

    // 2. Constructor con parámetros actualizados (coincide con los 4 de Person)
    public Customer(int id, String name, String gender, int age) {
        super(id, name, gender, age);
    }

    // 3. Sobrescritura de métodos CRUD
    @Override
    public void create() {
    }

    @Override
    public void selectById(int id) {
    }

    @Override
    public void selectAll() {
    }

    @Override
    public void update() {
    }

    @Override
    public void deleteById(int id) {
    }
}