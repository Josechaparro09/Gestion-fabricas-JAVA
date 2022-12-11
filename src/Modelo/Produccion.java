package Modelo;

import java.util.Date;

public class Produccion {
    //Definicion de atributos
    private String nombreProducc;
    private String codProducc;
    private Date fechaProducc;
    private Empleado empleadoEncar;
    private Planta plantaEncar;
    private Producto datosProd;
    private Categoria categoriaProd;
    private MateriaPrima mPrimaUtil;
    
    //Constructor por defecto
    public Produccion() {
    }

    public Produccion(String nombreProducc, Date fechaProducc, Empleado empleadoEncar, Planta plantaEncar, Producto datosProd, Categoria categoriaProd, MateriaPrima mPrimaUtil, double cMPrimaUtilizada, int cantidaPproduccida) {
        this.nombreProducc = nombreProducc;
        this.codProducc = codProducc;
        this.fechaProducc = fechaProducc;
        this.empleadoEncar = empleadoEncar;
        this.plantaEncar = plantaEncar;
        this.datosProd = datosProd;
        this.categoriaProd = categoriaProd;
        this.mPrimaUtil = mPrimaUtil;
        this.mPrimaUtil.setCatidad(mPrimaUtil.getCatidad()-cMPrimaUtilizada);
        this.datosProd.setCantidad(datosProd.getCantidad()-cantidaPproduccida);
    }
    
    
    

    //Getters y Setters
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

    public Date getFechaProducc() {
        return fechaProducc;
    }

    public void setFechaProducc(Date fechaProducc) {
        this.fechaProducc = fechaProducc;
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

    public Categoria getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(Categoria categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public MateriaPrima getmPrimaUtil() {
        return mPrimaUtil;
    }

    public void setmPrimaUtil(MateriaPrima mPrimaUtil) {
        this.mPrimaUtil = mPrimaUtil;
    }

    @Override
    public String toString() {
        return "\nProduccion: " + 
                "\nnombreProducc:" + nombreProducc + 
                "\ncodProducc=" + codProducc + 
                "\nfechaProducc=" + fechaProducc + 
                "\nempleadoEncar=" + empleadoEncar.getNombres() + 
                "\nplantaEncar=" + plantaEncar.getNombre() + 
                "\ndatosProd=" + datosProd + 
                "\ncategoriaProd=" + categoriaProd + 
                "\nmPrimaUtil=" + mPrimaUtil + '}';
    }
    
}