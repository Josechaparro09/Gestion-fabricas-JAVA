
package Modelo;

public class Equipo {
    
    private String nombre;
    private String ciudad;
    private String tecnico;
    private String nInscripcion;

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, String tecnico, String nInscripcion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tecnico = tecnico;
        this.nInscripcion = nInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getnInscripcion() {
        return nInscripcion;
    }

    public void setnInscripcion(String nInscripcion) {
        this.nInscripcion = nInscripcion;
    }
    
    
    
}
