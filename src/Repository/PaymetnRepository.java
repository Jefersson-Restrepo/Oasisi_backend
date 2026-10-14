package Repository;

import Domain.Payment;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class PaymetnRepository implements OutputPort<Payment> {
    private final List<Payment> data = new ArrayList<>();
    public void create(Payment payment) { if (payment != null) data.add(payment); }
    public Payment selectById(int id) { return data.stream().filter(payment -> payment.getId() == id).findFirst().orElse(null); }
    public List<Payment> selectAll() { return new ArrayList<>(data); }
    public boolean update(Payment payment) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == payment.getId()) { data.set(i, payment); return true; }
        }
        return false;
    }
    public boolean delete(int id) { return data.removeIf(payment -> payment.getId() == id); }
}