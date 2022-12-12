package cuenta;

public class Cuenta {

    private int noCuenta;
    private String nombreCliente;
    private double saldo;

    public Cuenta() {
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean consignar(double monto){
        if(monto<=0){
            System.out.println("Error al consignar");
            return false;
        }else{
            double total =this.saldo+monto;;
            this.saldo=total;
            System.out.println("Monto consignado con exito, nuevo saldo: " + total);
            return true;
        }
    }
    public boolean retirar(double monto){
        
        if(monto<=0){
            System.out.println("Error al retirar");
            return false;
        }else{
            double total =this.saldo-monto;;
            this.saldo=total;
            System.out.println("Monto retirado con exito, nuevo saldo: " + total);
            return true;
        }
    }
}
