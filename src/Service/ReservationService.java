package Service;

import Domain.Reservation;
import Repository.ReservationRepository;
import java.util.List;

public class ReservationService {
    private final ReservationRepository repository = new ReservationRepository();

    public void create(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("La reserva no puede ser nula.");
        if (reservation.getReservationTime() == null || reservation.getReservationTime().isBlank()) throw new IllegalArgumentException("La hora de la reserva es obligatoria.");
        if (reservation.getStatus() == null || reservation.getStatus().isBlank()) reservation.setStatus("Pendiente");
        repository.create(reservation);
    }
