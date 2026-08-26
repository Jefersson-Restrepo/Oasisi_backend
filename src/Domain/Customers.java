package Domain;

public class Customers {
    //Atributos
    private int id;
    private String name;
    private String gender;
    private String photo; // guarda la ruta de la foto
    private int age;


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


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void create(){

    }

    // Metodo vacio con argumentos

    public void selectById(int id){

    }

    public void selectAll(){

    }

    public void update(){

    }

    public void delete(int id ){

    }


}

