package modelo;


public class Cuenta {
    
    private String noCuenta;
    private String tipo;
    private double saldoInicial;
    private Usuario usuario ;

    public Cuenta(String noCuenta, String tipo, double saldoInicial, Usuario usuario) {
        this.noCuenta = noCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.usuario = usuario;
        usuario.setCuenta(this);
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    
    @Override
    public String toString(){
        
        return ("No Cuenta: " + this.noCuenta + "\n" 
                + "Tipo: " + this.tipo + "\n" 
                + "Saldo inicial: "+ this.saldoInicial + "\n"
                + "Datos del usuario : " + "\n" + this.usuario);
    }
    
}
