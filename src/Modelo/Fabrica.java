package Modelo;

public class Fabrica {

    private String nombre;
    private String nit;
    private String direccionF;
    private Produccion datosProducc;
    private Empleado datosEmpleados;
    private Venta datosVentas;
    private Categoria datosCag;
    private Producto datosProd;
    private Planta datosPlantas;
    
    public Fabrica() {
    }

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
    









}