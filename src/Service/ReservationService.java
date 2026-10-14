package Service;

import Domain.Reservation;
import Port.InputPort;
import Port.OutputPort;
import Repository.ReservationRepository;
import java.util.List;
import java.util.Objects;

public class ReservationService implements InputPort<Reservation> {
    private final OutputPort<Reservation> repository;

    public ReservationService() {
        this(new ReservationRepository());
    }

    public ReservationService(OutputPort<Reservation> repository) {
        this.repository = Objects.requireNonNull(repository, "El OutputPort no puede ser nulo.");
    }

    public void create(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("La reserva no puede ser nula.");
        if (reservation.getReservationTime() == null || reservation.getReservationTime().isBlank())
            throw new IllegalArgumentException("La hora de la reserva es obligatoria.");
        if (reservation.getStatus() == null || reservation.getStatus().isBlank()) reservation.setStatus("Pendiente");
        repository.create(reservation);
    }
    public Reservation selectById(int id) {
        return repository.selectById(id);
    }

    public List<Reservation> selectAll() {
        return repository.selectAll();
    }

    public boolean update(Reservation reservation) {
        return reservation != null && repository.update(reservation);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }
}
