package Domain;

public class Employees extends Person {

    // 1. Atributo propio de Employees
    private String idService;

    // 2. Constructor vacío
    public Employees() {
        super();
    }

    // 3. Constructor con parámetros (envía los 4 datos a Person)
    public Employees(int id, String name, String gender, int age, String idService) {
        super(id, name, gender, age);
        this.idService = idService;
    }

    // 4. Getter y Setter del atributo propio
    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    // 5. Métodos CRUD heredados
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
    public void deleteById(int id) {
        super.deleteById(id);
    }
}