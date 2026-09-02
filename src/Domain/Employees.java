package Domain;

public class Employees extends Person {

    // 1. Atributos propios de Employees (si los hay, ej. idService)
    private String idService;

    // 2. Constructor vacío
    public Employees() {
        super();
    }

    // 3. Constructor con parámetros
    public Employees(int id, String name, String gender, int age, String idService) {
        super(id, name, gender, age);
        this.idService = idService;
    }

    // 4. Getters y Setters propios
    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    // 5. Métodos heredados con @Override correcto
    @Override
    public void create() {
        super.create();
    }

    @Override
    public void selectById(int id) {
        super.selectById(id);
    }

    @Override
    public void selectAll() {
        super.selectAll();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void deleteById(int id) { // Corrección: deleteById en lugar de delete
        super.deleteById(id);
    }
}