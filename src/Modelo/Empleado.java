package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Empleado {
    
    //Definicion de atributos
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    public Planta plantaEnc;
    public Date fechaIngreso;
    ArrayList<Empleado> empleados = new ArrayList();
    
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

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    //Hola
    
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

    public ArrayList<Empleado> agregarEmpleado(Empleado em){
        this.empleados.add(em);
        return this.empleados;
    }
    public int BuscarEmpleadoByCC(String cc){
        int pos = 0;
        for (Empleado empleado : empleados) {
            if (empleados.equals(cc)) {
                pos = empleados.indexOf(cc);
            }
        }
        return pos;
    }
    
    
    
}