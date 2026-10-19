package Repository;

import Domain.Reservation;
import Port.OutputPort;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements OutputPort<Reservation> {
    private final List<Reservation> data = new ArrayList<>();
    public void create(Reservation reservation) { if (reservation != null) data.add(reservation); }
    public Reservation selectById(int id) {
        for (Reservation reservation : data) {
            if (reservation.getId() == id) return reservation;
        }
        return null;
    }
    public List<Reservation> selectAll() { return new ArrayList<>(data); }
    public boolean update(Reservation reservation) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == reservation.getId()) { data.set(i, reservation); return true; }
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