package Repository;

import Domain.Payment;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements OutputPort<Payment> {
    private final List<Payment> data = new ArrayList<>();
    public void create(Payment payment) { if (payment != null) data.add(payment); }
    public Payment selectById(int id) {
        for (Payment payment : data) {
            if (payment.getId() == id) return payment;
        }
        return null;
    }
    public List<Payment> selectAll() { return new ArrayList<>(data); }
    public boolean update(Payment payment) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == payment.getId()) { data.set(i, payment); return true; }
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