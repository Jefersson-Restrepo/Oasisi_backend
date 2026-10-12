package Repository;

import Domain.Inventory;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
    private final List<Inventory> data = new ArrayList<>();
    public void create(Inventory inventory) { if (inventory != null) data.add(inventory); }
    public Inventory selectById(int id) { return data.stream().filter(item -> item.getId() == id).findFirst().orElse(null); }
    public List<Inventory> selectAll() { return new ArrayList<>(data); }
    public boolean update(Inventory inventory) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == inventory.getId()) { data.set(i, inventory); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(item -> item.getId() == id); }
}