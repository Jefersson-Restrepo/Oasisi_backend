package Domain;

// permite usar fechas en el codigo
import java.util.Date;


    public class Payment {

        // Atributos según el diagrama UML
        private int id;
        private double amount;
        private Date paymentDate;
        private String paymentMethod;
        private String status;
        private int idCustomer;
        private int idReservation;

        // Constructor vacío
        public Payment() {
        }

        // Constructor con parámetros
        public Payment(int id, double amount, Date paymentDate, String paymentMethod, String status, int idCustomer, int idReservation) {
            this.id = id;
            this.amount = amount;
            this.paymentDate = paymentDate;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.idCustomer = idCustomer;
            this.idReservation = idReservation;
        }

        // Métodos indicados
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

        // Getters y Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Date getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getIdCustomer() {
            return idCustomer;
        }

        public void setIdCustomer(int idCustomer) {
            this.idCustomer = idCustomer;
        }

        public int getIdReservation() {
            return idReservation;
        }

        public void setIdReservation(int idReservation) {
            this.idReservation = idReservation;
        }
    }