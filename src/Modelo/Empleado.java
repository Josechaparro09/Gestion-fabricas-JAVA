package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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

    public void agregarEmpleado(Empleado em){
        this.empleados.add(em);
    }
    public Empleado eliminarEmpleadoBycc(String cc){
        Empleado eliminado = null;
        Iterator<Empleado> i = this.empleados.iterator();
        while (i.hasNext()) {

            Empleado leido = i.next();
            if (leido.getCedula()==cc) {
                eliminado=leido;
                i.remove();
                break;
            }
            
        }
        return eliminado;
    }
    
    public Empleado BuscarEmpleadoByCC(String cc){
        
        Empleado emp = null;
        for (Empleado em : this.empleados) {
            if (em.getCedula()== cc) {
               emp=em;
               
               break;
            }
        }
        return emp;
    }
    
    
    
    
    
}