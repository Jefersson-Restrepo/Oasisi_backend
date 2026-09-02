package Domain;

import java.util.Date;

public class Inventory {

    private int id;
    private int quantity;
    private int minimunStock;
    private Date lastUpdate;
    private int idProduct;

    public Inventory() {
    }

    public Inventory(int id, int quantity, int minimunStock, Date lastUpdate, int idProduct) {
        this.id = id;
        this.quantity = quantity;
        this.minimunStock = minimunStock;
        this.lastUpdate = lastUpdate;
        this.idProduct = idProduct;
    }

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

    public void updateStock() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getMinimunStock() { return minimunStock; }
    public void setMinimunStock(int minimunStock) { this.minimunStock = minimunStock; }

    public Date getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Date lastUpdate) { this.lastUpdate = lastUpdate; }

    public int getIdProduct() { return idProduct; }
    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }
}