package Domain;

import java.util.Date;

public class Inventory {
    private int id;
    private int quantity;
    private int minimumStock;
    private Date lastUpdate;
    private int idProduct;

    public Inventory() { }

    public Inventory(int id, int quantity, int minimumStock, Date lastUpdate, int idProduct) {
        this.id = id;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
        this.lastUpdate = lastUpdate;
        this.idProduct = idProduct;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getMinimumStock() { return minimumStock; }
    public void setMinimumStock(int minimumStock) { this.minimumStock = minimumStock; }
    public Date getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Date lastUpdate) { this.lastUpdate = lastUpdate; }
    public int getIdProduct() { return idProduct; }
    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }

    @Override
    public String toString() {
        return "Inventory{id=" + id + ", quantity=" + quantity + ", minimumStock=" + minimumStock + ", lastUpdate=" + lastUpdate + ", idProduct=" + idProduct + '}';
    }
}