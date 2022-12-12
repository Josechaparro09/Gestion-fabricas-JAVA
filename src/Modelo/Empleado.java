package Modelo;

import View.Dashboard;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Empleado {
    
    //Definicion de atributos
    private String p_nombre;
    private String s_nombre;
    private String p_apellido;
    private String s_apellido;
    private String cedula;
    private String telefono;
    public Planta plantaEnc;
    public Date fechaIngreso;
    ArrayList<Empleado> empleados = new ArrayList();
    
    //Costructor por defecto
    public Empleado() {
    }

    public Empleado(String p_nombre, String s_nombre, String p_apellido, String s_apellido, String cedula, String telefono, Planta plantaEnc, Date fechaIngreso) {
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.plantaEnc = plantaEnc;
        this.fechaIngreso = fechaIngreso;
        this.agregarEmpleado();
    }

    public String getP_nombre() {
        return p_nombre ;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getS_nombre() {
        return s_nombre;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
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

    //Getters y Setters
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //Hola
    //Mostrar datos
    @Override
    public String toString() {
        return "\nEmpleado: " + "\nNombres:" + p_nombre +
                "\napellidos :" + p_apellido +
                "\ncedula :" + cedula +
                "\ntelefono :" + telefono +
                "\nplantaEnc :" + plantaEnc.getNombre()+ 
                "\nfechaIngreso :" + fechaIngreso ;
    }

    public void agregarEmpleado(){
        this.empleados.add(this);
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
    public String consultarDatos(){
        String datos = String.format("%15s\t%15s\t%15s\t%15s\t%15s",
                                    this.cedula,
                                    this.p_nombre,
                                    this.p_apellido,
                                    this.telefono,
                                    this.plantaEnc.getNombre()
                                     );
        return datos;
    }
    public boolean validarVacio(String a){
        if (!"".equals(a)) {
            return true;
        }else{
            return false;
        }
    }
    
}