package Service;

import Domain.Products;
import Repository.ProductsRepository;
import java.util.List;

public class ProductsService {
    private final ProductsRepository repository = new ProductsRepository();

    public void create(Products product) {
        if (product == null) throw new IllegalArgumentException("El producto no puede ser nulo.");
        if (product.getName() == null || product.getName().isBlank())
            throw new IllegalArgumentException("El nombre del producto es obligatorio.");
        if (product.getBrand() == null || product.getBrand().isBlank())
            throw new IllegalArgumentException("La marca del producto es obligatoria.");
        repository.create(product);
    }
    public Products selectById(int id) {
        return repository.selectById(id);
    }

    public List<Products> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Products product) {
        return product != null && repository.update(product);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}