package Modelo;

import Datos.IAEntidades;
import Datos.Libro;
import java.util.ArrayList;

public class Fabrica {

    //Definicion de atributos
    private String nombre;
    private String nit;
    private String direccionF;
    private Produccion datosProducc;
    private Empleado datosEmpleados;
    private Venta datosVentas;
    private Categoria datosCag;
    private Producto datosProd;
    private Planta datosPlantas;
    private MateriaPrima datosMPrima;
    private Libro libro ;
    
    ArrayList<Fabrica> fabricas = new ArrayList();
    
    
    //Constructor
    public Fabrica() {
    }

    public Fabrica(String nombre, String nit, String direccionF, Produccion datosProducc, Empleado datosEmpleados, Venta datosVentas, Categoria datosCag, Producto datosProd, Planta datosPlantas, MateriaPrima datosMPrima) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccionF = direccionF;
        this.datosProducc = datosProducc;
        this.datosEmpleados = datosEmpleados;
        this.datosVentas = datosVentas;
        this.datosCag = datosCag;
        this.datosProd = datosProd;
        this.datosPlantas = datosPlantas;
        this.datosMPrima = datosMPrima;
        this.libro = new Libro();
    }
    
    
     //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccionF() {
        return direccionF;
    }

    public void setDireccionF(String direccionF) {
        this.direccionF = direccionF;
    }

    public Produccion getDatosProducc() {
        return datosProducc;
    }

    public void setDatosProducc(Produccion datosProducc) {
        this.datosProducc = datosProducc;
    }

    public Empleado getDatosEmpleados() {
        return datosEmpleados;
    }

    public void setDatosEmpleados(Empleado datosEmpleados) {
        this.datosEmpleados = datosEmpleados;
    }

    public Venta getDatosVentas() {
        return datosVentas;
    }

    public void setDatosVentas(Venta datosVentas) {
        this.datosVentas = datosVentas;
    }

    public Categoria getDatosCag() {
        return datosCag;
    }

    public void setDatosCag(Categoria datosCag) {
        this.datosCag = datosCag;
    }

    public Producto getDatosProd() {
        return datosProd;
    }

    public void setDatosProd(Producto datosProd) {
        this.datosProd = datosProd;
    }

    public Planta getDatosPlantas() {
        return datosPlantas;
    }

    public void setDatosPlantas(Planta datosPlantas) {
        this.datosPlantas = datosPlantas;
    }

    public MateriaPrima getDatosMPrima() {
        return datosMPrima;
    }

    public void setDatosMPrima(MateriaPrima datosMPrima) {
        this.datosMPrima = datosMPrima;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    

    //Mostrar datos
    @Override
    public String toString() {
        return "\nFabrica:" + 
                "\nNombre: " + nombre + 
                "\nNit: " + nit + 
                "\nDireccion: " + direccionF + 
                "\nProduccion: " + datosProducc + 
                "\nEmpleado: " + datosEmpleados + 
                "\nVenta: " + datosVentas +
                "\nProducto: " + datosProd + 
                "\nPlanta: " + datosPlantas + 
                "\nMateria Prima: " + datosMPrima ;
    }

    
}