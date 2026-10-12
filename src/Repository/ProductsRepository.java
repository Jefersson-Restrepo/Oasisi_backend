package Repository;

import Domain.Products;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    private final List<Products> data = new ArrayList<>();
    public void create(Products product) { if (product != null) data.add(product); }
    public Products selectById(int id) { return data.stream().filter(product -> product.getId() == id).findFirst().orElse(null); }
    public List<Products> selectAll() { return new ArrayList<>(data); }
    public boolean update(Products product) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == product.getId()) { data.set(i, product); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(product -> product.getId() == id); }
}