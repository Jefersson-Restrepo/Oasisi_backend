package Service;

import Domain.Customer;
import Repository.CustomersRepository;
import java.util.List;

public class CustomersService {
    private final CustomersRepository repository = new CustomersRepository();

    public void create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("El cliente no puede ser nulo.");
        if (customer.getName() == null || customer.getName().isBlank())
            throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        if (customer.getPhone() == null || customer.getPhone().isBlank())
            throw new IllegalArgumentException("El telÃ©fono del cliente es obligatorio.");
        repository.create(customer);
    }
    public Customer selectById(int id) {
        return repository.selectById(id);
    }

    public List<Customer> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Customer customer) {
        return customer != null && repository.update(customer);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}
