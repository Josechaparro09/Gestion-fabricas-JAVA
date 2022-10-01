package Modelo;

public class Produccion {

    private String nombreProducc;
    private String codProducc;
    private Empleado empleadoEncar;
    private Planta plantaEncar;
    private Producto datosProd;
    private Producto categoriaProd;
    
    public Produccion() {
    }

    public String getNombreProducc() {
        return nombreProducc;
    }

    public void setNombreProducc(String nombreProducc) {
        this.nombreProducc = nombreProducc;
    }

    public String getCodProducc() {
        return codProducc;
    }

    public void setCodProducc(String codProducc) {
        this.codProducc = codProducc;
    }

    public Empleado getEmpleadoEncar() {
        return empleadoEncar;
    }

    public void setEmpleadoEncar(Empleado empleadoEncar) {
        this.empleadoEncar = empleadoEncar;
    }

    public Planta getPlantaEncar() {
        return plantaEncar;
    }

    public void setPlantaEncar(Planta plantaEncar) {
        this.plantaEncar = plantaEncar;
    }

    public Producto getDatosProd() {
        return datosProd;
    }

    public void setDatosProd(Producto datosProd) {
        this.datosProd = datosProd;
    }

    public Producto getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(Producto categoriaProd) {
        this.categoriaProd = categoriaProd;
    }
    











}