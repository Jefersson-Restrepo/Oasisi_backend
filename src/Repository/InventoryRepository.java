package Repository;

import Domain.Inventory;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository implements OutputPort<Inventory> {
    private final List<Inventory> data = new ArrayList<>();
    public void create(Inventory inventory) { if (inventory != null) data.add(inventory); }
    public Inventory selectById(int id) {
        for (Inventory item : data) {
            if (item.getId() == id) return item;
        }
        return null;
    }
    public List<Inventory> selectAll() { return new ArrayList<>(data); }
    public boolean update(Inventory inventory) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == inventory.getId()) { data.set(i, inventory); return true; }
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