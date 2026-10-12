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

