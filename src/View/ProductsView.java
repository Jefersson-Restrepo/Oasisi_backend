package View;

import Domain.Products;
import java.util.List;

public class ProductsView {
    public void showMenu() {
        System.out.println("\n--- Productos ---");
        System.out.println("1. Crear producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Volver");
    }

    public void showProducts(List<Products> products) {
        if (products.isEmpty()) { System.out.println("No hay productos registrados."); return; }
        for (Products product : products) System.out.println(product);
    }
}
