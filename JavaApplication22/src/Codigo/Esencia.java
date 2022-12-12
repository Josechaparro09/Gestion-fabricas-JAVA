
package Codigo;

import java.util.ArrayList;

public class Esencia {
    
    private double precio;
    private int cantidad;
    private String nombre;
    private String presentacion="500";
    ArrayList <String> nums = new ArrayList<>();
    public Esencia(double precio, String nombre , int cantidad) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad=cantidad;
    }
        
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
  
    public String getInfo(){
        return "Esencia de " + this.nombre + 
                "\n" + "precio unidad: " + this.precio + 
                "\n" + "Precio total: " + this.cantidad*this.precio;
    }
    
   public String marcasAutos[] = new String[6];
    
}
