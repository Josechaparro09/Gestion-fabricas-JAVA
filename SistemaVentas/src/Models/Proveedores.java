
package Models;

public class Proveedores {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String estado;

    public Proveedores() {
    }

    public Proveedores(int id, String nombre, String telefono, String direecion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direecion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
