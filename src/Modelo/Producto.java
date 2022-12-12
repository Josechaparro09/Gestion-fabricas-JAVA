package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Producto {

    //Definicion de atributos
    private String idProducto;
    private String nombreProd;
    private String cagProducto;
    private String medidaProd;
    private double precioVenta;
    private double costoProduccion;
    private ArrayList<Producto> productos = new ArrayList();
    
    //Constructor por defecto
    public Producto() {
    }
    //Constructor sobrecargado

    public Producto(String idProducto, String nombreProd, String cagProducto, String medidaProd, double precioVenta, double costoProduccion) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.cagProducto = cagProducto;
        this.medidaProd = medidaProd;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
    }
    
    

    //Getters y Setters
    

    //Mostrar Datos
    
    
    public void agregarProducto(){
        this.getProductos().add(this);
    }
    public Producto eliminarProducto(Producto prod){
        Producto eliminado = null ; 
        Iterator<Producto> i = this.getProductos().iterator();
        while (i.hasNext()) {            
            Producto leida = i.next();
            if (prod==leida) {
                i.remove();
                break;
            }
        }
        return eliminado;
    }
    
    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the nombreProd
     */
    public String getNombreProd() {
        return nombreProd;
    }

    /**
     * @param nombreProd the nombreProd to set
     */
    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    /**
     * @return the cagProducto
     */
    public String getCagProducto() {
        return cagProducto;
    }

    /**
     * @param cagProducto the cagProducto to set
     */
    public void setCagProducto(String cagProducto) {
        this.cagProducto = cagProducto;
    }

    /**
     * @return the medidaProd
     */
    public String getMedidaProd() {
        return medidaProd;
    }

    /**
     * @param medidaProd the medidaProd to set
     */
    public void setMedidaProd(String medidaProd) {
        this.medidaProd = medidaProd;
    }

    /**
     * @return the precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the costoProduccion
     */
    public double getCostoProduccion() {
        return costoProduccion;
    }

    /**
     * @param costoProduccion the costoProduccion to set
     */
    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    /**
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
   
    

}