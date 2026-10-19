package Service;

import Domain.Payment;
import Port.InputPort;
import Port.OutputPort;
import Repository.PaymentRepository;
import java.util.List;
import java.util.Objects;

public class PaymentService implements InputPort<Payment> {
    private final OutputPort<Payment> repository;

    public PaymentService() {
        this(new PaymentRepository());
    }

    public PaymentService(OutputPort<Payment> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

    public void create(Payment payment) {
        if (payment == null) throw new IllegalArgumentException("El pago no puede ser nulo.");
        if (payment.getAmount() <= 0) throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        if (payment.getPaymentMethod() == null || payment.getPaymentMethod().isBlank())
            throw new IllegalArgumentException("El mÃ©todo de pago es obligatorio.");
        repository.create(payment);
    }
    public Payment selectById(int id) {
        return repository.selectById(id);
    }

    public List<Payment> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Payment payment) {
        return payment != null && repository.update(payment);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}
