
package Modelo;

public class Medida {
    private String idMedida;
    private String nombre;
    private String nCorto;

    public Medida() {
    }

    public Medida(String nombre, String nCorto, String idMedida) {
        this.nombre = nombre;
        this.nCorto = nCorto;
        this.idMedida = idMedida;
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

    public String getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(String idMedida) {
        this.idMedida = idMedida;
    }
    
    
}
