package Domain;

import java.util.Date;

public class Inventory {

    //Atributos segun el UML
    private int id;
    private int quantity;
    private int minimunStok;
    private Date lastUpdate;
    private int idProduct;

    //Constructor con parametros
    public Inventory(int id, int quantity, int minimunStok, Date lastUpdate, int idProduct) {
        this.id = id;
        this.quantity = quantity;
        this.minimunStok = minimunStok;
        this.lastUpdate = lastUpdate;
        this.idProduct = idProduct;
    }

    //Metodos especificados en el UML
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

    public void updateStock(){
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinimunStok() {
        return minimunStok;
    }

    public void setMinimunStok(int minimunStok) {
        this.minimunStok = minimunStok;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
