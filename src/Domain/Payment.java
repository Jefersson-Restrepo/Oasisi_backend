package Domain;

import java.util.Date;

public class Payment {
    private int id;
    private double amount;
    private String paymentMethod;
    private Date paymentDate;
    private String status;

    public Payment() { }

    public Payment(int id, double amount, String paymentMethod, Date paymentDate, String status) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", amount=" + amount + ", paymentMethod='" + paymentMethod + "', paymentDate=" + paymentDate + ", status='" + status + "'}";
    }
}