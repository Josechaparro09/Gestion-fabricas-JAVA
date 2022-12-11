
package Modelo;

public class Medida {
    private String nombre;
    private String nCorto;

    public Medida() {
    }

    public Medida(String nombre, String nCorto) {
        this.nombre = nombre;
        this.nCorto = nCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnCorto() {
        return nCorto;
    }

    public void setnCorto(String nCorto) {
        this.nCorto = nCorto;
    }
    
    
}
