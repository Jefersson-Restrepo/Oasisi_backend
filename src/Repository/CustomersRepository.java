package Repository;

import Domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomersRepository {
    private final List<Customer> data = new ArrayList<>();
    public void create(Customer customer) { if (customer != null) data.add(customer); }
    public Customer selectById(int id) { return data.stream().filter(customer -> customer.getId() == id).findFirst().orElse(null); }
    public List<Customer> selectAll() { return new ArrayList<>(data); }
    public boolean update(Customer customer) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == customer.getId()) { data.set(i, customer); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(customer -> customer.getId() == id); }
}