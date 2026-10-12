package Service;

import Domain.Payment;
import Repository.PaymetnRepository;
import java.util.List;

public class PaymetnService {
    private final PaymetnRepository repository = new PaymetnRepository();

    public void create(Payment payment) {
        if (payment == null) throw new IllegalArgumentException("El pago no puede ser nulo.");
        if (payment.getAmount() <= 0) throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        if (payment.getPaymentMethod() == null || payment.getPaymentMethod().isBlank()) throw new IllegalArgumentException("El mÃ©todo de pago es obligatorio.");
        repository.create(payment);
    }
