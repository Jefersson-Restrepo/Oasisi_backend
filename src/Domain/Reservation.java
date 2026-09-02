
package Domain;

// permite usar fechas en el codigo
import java.util.Date;

public class Reservation {

    // 1. Atributos privados según el diagrama UML
    private int id;
    private Date reservationDate;
    private String reservationTime;
    private String status;
    private String notes;
    private int idCustomer;
    private int idService;
    private int idEmployee;

    // 2. Constructor vacío
    public Reservation() {
    }

    // 3. Constructor con parámetros
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

    // 4. Métodos especificados en el diagrama UML
    public void create() {
    }

    public void selectById(int id) {
    }

    public void selectAll() {
    }

    public void update() {
    }

    public void deleteById(int id) {
    }

    // 5. Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

}
