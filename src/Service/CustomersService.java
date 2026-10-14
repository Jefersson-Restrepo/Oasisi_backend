package Service;

import Domain.Customer;
import Port.InputPort;
import Port.OutputPort;
import Repository.CustomersRepository;
import java.util.List;
import java.util.Objects;

public class CustomersService implements InputPort<Customer> {
    private final OutputPort<Customer> repository;

    public CustomersService() {
        this(new CustomersRepository());
    }

    public CustomersService(OutputPort<Customer> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

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
