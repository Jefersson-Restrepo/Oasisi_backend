package Domain;

public class Payment {

    private int id;
    private String efectivo;
    private String transferencia;

    public Payment() {
    }

    public Payment(int id, String efectivo, String transferencia) {
        this.id = id;
        this.efectivo = efectivo;
        this.transferencia = transferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }

    public String getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(String transferencia) {
        this.transferencia = transferencia;
    }
}