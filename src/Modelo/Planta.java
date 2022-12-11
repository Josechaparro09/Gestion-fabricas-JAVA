package Modelo;

import java.util.ArrayList;

public class Planta {
    //Definicion de atributos
    private String nombre;
    private String direccion;
    private Fabrica fabricaAsig;
    private Empleado empleadoAsig;
    private Produccion producido;
    private ArrayList<Planta> plantas = new ArrayList();
            
    //Constructor por defecto
    public Planta() {
        
    }

    public Planta(String nombre, String direccion, Fabrica fabricaAsig, Empleado empleadoAsig, Produccion producido) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fabricaAsig = fabricaAsig;
        this.empleadoAsig = empleadoAsig;
        this.producido = producido;
        agregarPlanta();
    }
    
    
    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Fabrica getFabricaAsig() {
        return fabricaAsig;
    }

    public void setFabricaAsig(Fabrica fabricaAsig) {
        this.fabricaAsig = fabricaAsig;
    }

    public Empleado getEmpleadoAsig() {
        return empleadoAsig;
    }

    public void setEmpleadoAsig(Empleado empleadoAsig) {
        this.empleadoAsig = empleadoAsig;
    }

    public Produccion getProducido() {
        return producido;
    }

    public void setProducido(Produccion producido) {
        this.producido = producido;
    }

    @Override
    public String toString() {
        return "\nPlanta:" + 
                "\nnombre: " + nombre + 
                "\ndireccion: " + direccion + 
                "\nfabricaAsig: " + fabricaAsig.getNombre() + 
                "\nempleadoAsig: " + empleadoAsig.getNombres() + 
                "\nproducido: " + producido;
    }
    
    public void agregarPlanta(){
        plantas.add(this);
    }

}