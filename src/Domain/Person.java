package Domain;

public class Person {

    // 1. Atributos exactos del UML
    private int id;
    private String name;
    private String gender;
    private int age;

    // 2. Constructor vacío
    public Person() {
    }

    // 3. Constructor con parámetros (4 parámetros)
    public Person(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // 4. Métodos CRUD
    public void create() {
    }

    public void selectById(int id) {
    }

    public void selectAll() {
    }

    public void update() {
    }

    public void deleteById(int id) {
    }

    // 5. Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}