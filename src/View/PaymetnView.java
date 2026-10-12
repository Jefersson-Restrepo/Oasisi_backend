package View;

import Domain.Payment;
import java.util.List;

public class PaymetnView {
    public void showMenu() {
        System.out.println("\n--- Pagos ---");
        System.out.println("1. Registrar pago");
        System.out.println("2. Listar pagos");
        System.out.println("3. Buscar pago");
        System.out.println("4. Actualizar pago");
        System.out.println("5. Eliminar pago");
        System.out.println("0. Volver");
    }

    public void showPayments(List<Payment> payments) {
        if (payments.isEmpty()) { System.out.println("No hay pagos registrados."); return; }
        for (Payment payment : payments) System.out.println(payment);
    }
}