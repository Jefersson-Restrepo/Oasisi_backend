package View;

import Domain.Reservation;
import java.util.List;

public class ReservationView {
    public void showMenu() {
        System.out.println("\n--- Reservas ---");
        System.out.println("1. Crear reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Buscar reserva");
        System.out.println("4. Actualizar reserva");
        System.out.println("5. Eliminar reserva");
        System.out.println("0. Volver");
    }

    public void showReservations(List<Reservation> reservations) {
        if (reservations.isEmpty()) { System.out.println("No hay reservas registradas."); return; }
        for (Reservation reservation : reservations) System.out.println(reservation);
    }
}
