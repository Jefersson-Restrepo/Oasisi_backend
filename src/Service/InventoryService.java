package Service;

import Domain.Inventory;
import Repository.InventoryRepository;
import java.util.Date;
import java.util.List;

public class InventoryService {
    private final InventoryRepository repository = new InventoryRepository();

    public void create(Inventory inventory) {
        if (inventory == null) throw new IllegalArgumentException("El inventario no puede ser nulo.");
        if (inventory.getQuantity() < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        if (inventory.getMinimumStock() < 0) throw new IllegalArgumentException("El stock mÃ­nimo no puede ser negativo.");
        if (inventory.getLastUpdate() == null) inventory.setLastUpdate(new Date());
        repository.create(inventory);
    }
    public Inventory selectById(int id) { return repository.selectById(id); }
    public List<Inventory> selectAll() { return repository.selectAll(); }
    public boolean update(Inventory inventory) {
        if (inventory == null) return false;
        inventory.setLastUpdate(new Date());
        return repository.update(inventory);
    }
    public boolean delete(int id) { return repository.delete(id); }
}