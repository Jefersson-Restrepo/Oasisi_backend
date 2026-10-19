package Repository;

import Domain.Products;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository implements OutputPort<Products> {
    private final List<Products> data = new ArrayList<>();
    public void create(Products product) { if (product != null) data.add(product); }
    public Products selectById(int id) {
        for (Products product : data) {
            if (product.getId() == id) return product;
        }
        return null;
    }
    public List<Products> selectAll() { return new ArrayList<>(data); }
    public boolean update(Products product) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == product.getId()) { data.set(i, product); return true; }
        }
        return false;
    }
    public boolean delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
}