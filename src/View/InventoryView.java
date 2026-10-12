package View;

import Domain.Inventory;
import java.util.List;

public class InventoryView {
    public void showMenu() {
        System.out.println("\n--- Inventario ---");
        System.out.println("1. Registrar movimiento");
        System.out.println("2. Listar inventario");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar inventario");
        System.out.println("5. Eliminar registro");
        System.out.println("0. Volver");
    }

    public void showInventory(List<Inventory> items) {
        if (items.isEmpty()) { System.out.println("No hay registros de inventario."); return; }
        for (Inventory item : items) System.out.println(item);
    }
}