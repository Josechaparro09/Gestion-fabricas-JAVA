package Modelo;

import java.util.Date;

public class Empleado {
    
    //Definicion de atributos
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    public Planta plantaEnc;
    public Date fechaIngreso;
    
    //Costructor por defecto
    public Empleado() {
    }

    //Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Planta getPlantaEnc() {
        return plantaEnc;
    }

    public void setPlantaEnc(Planta plantaEnc) {
        this.plantaEnc = plantaEnc;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
    //Mostrar datos

    @Override
    public String toString() {
        return "\nEmpleado: " + "\nNombres:" + nombres + 
                "\napellidos :" + apellidos + 
                "\ncedula :" + cedula + 
                "\ntelefono :" + telefono + 
                "\nplantaEnc :" + plantaEnc.getNombre()+ 
                "\nfechaIngreso :" + fechaIngreso ;
    }

    
    
    
}