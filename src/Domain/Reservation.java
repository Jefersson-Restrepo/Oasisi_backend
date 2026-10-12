package Domain;

import java.util.Date;

public class Reservation {
    private int id;
    private Date reservationDate;
    private String reservationTime;
    private String status;
    private String notes;
    private int idCustomer;
    private int idService;
    private int idEmployee;

    public Reservation() { }

    public Reservation(int id, Date reservationDate, String reservationTime, String status, String notes, int idCustomer, int idService, int idEmployee) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.status = status;
        this.notes = notes;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.idEmployee = idEmployee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getReservationDate() { return reservationDate; }
    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }
    public String getReservationTime() { return reservationTime; }
    public void setReservationTime(String reservationTime) { this.reservationTime = reservationTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public int getIdCustomer() { return idCustomer; }
    public void setIdCustomer(int idCustomer) { this.idCustomer = idCustomer; }
    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }
    public int getIdEmployee() { return idEmployee; }
    public void setIdEmployee(int idEmployee) { this.idEmployee = idEmployee; }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", reservationDate=" + reservationDate + ", reservationTime='" + reservationTime + "', status='" + status + "', notes='" + notes + "', idCustomer=" + idCustomer + ", idService=" + idService + ", idEmployee=" + idEmployee + '}';
    }
}