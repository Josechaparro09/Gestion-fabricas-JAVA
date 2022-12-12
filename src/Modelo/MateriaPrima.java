
package Modelo;

import java.util.Date;

public class MateriaPrima {
    //Definicion de atributos
    private String cod;
    private String nombre;
    private int unidades;
    private double catidad;
    private String medida;
    private Date fechaCompra;

    //Constructor por defecto
    public MateriaPrima() {
    }

    //Getters y Setters
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getCatidad() {
        return catidad;
    }

    public void setCatidad(double catidad) {
        this.catidad = catidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    
    //Mostrar datos
    @Override
    public String toString() {
        return "\nMateriaPrima: " +
                "\nNombre: " + nombre + 
                "\nUnidades: " + unidades + 
                "\nCatidad= " + catidad + 
                "\nMedida:" + medida + 
                "\nFechaCompra: " + fechaCompra;
    }
    
    
    
    
}
