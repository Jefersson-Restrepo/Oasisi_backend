package Repository;

import Domain.Customer;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class CustomersRepository implements OutputPort<Customer> {
    private final List<Customer> data = new ArrayList<>();
    public void create(Customer customer) { if (customer != null) data.add(customer); }
    public Customer selectById(int id) {
        for (Customer customer : data) {
            if (customer.getId() == id) return customer;
        }
        return null;
    }
    public List<Customer> selectAll() { return new ArrayList<>(data); }
    public boolean update(Customer customer) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == customer.getId()) { data.set(i, customer); return true; }
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