package Domain;

public class Person {

    private int id;
    private String name;
    private String gender;
    private String photo;
    private int age;
// GETTER AND SETTER

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // metodos
    public void create() {
    }

    public void selectById(int id) {
    }

    public void selectAll() {
    }

    public void update() {
    }

    public void delete(int id) {
    }
}
