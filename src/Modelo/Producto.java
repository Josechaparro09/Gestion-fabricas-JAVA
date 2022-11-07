package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Producto {

    //Definicion de atributos
    protected String codProducto;
    protected String nombreProd;
    protected Categoria cagProducto;
    protected int cantidad;
    protected double precioVenta;
    protected double costoProduccion;
    ArrayList<Producto> productos = new ArrayList();
    
    //Constructor por defecto
    public Producto() {
    }
    
    public Producto(String codProducto, String nombreProd, Categoria cagProducto, int cantidad, double precioVenta, double costoProduccion) {
        this.codProducto = codProducto;
        this.nombreProd = nombreProd;
        this.cagProducto = cagProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
        this.agregarProducto();
    }
    

    //Getters y Setters
    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public Categoria getCagProducto() {
        return cagProducto;
    }

    public void setCagProducto(Categoria cagProducto) {
        this.cagProducto = cagProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    //Mostrar Datos
    @Override
    public String toString() {
        return "\nProducto: " + 
                "\nNombre : " + nombreProd +
                "\nCantidad: " + cantidad + 
                "\nPrecioVenta: " + precioVenta + 
                "\nCostoProduccion: " + costoProduccion;
    }
    
    public void agregarProducto(){
        this.productos.add(this);
    }
    public Producto eliminarProducto(Producto prod){
        Producto eliminado = null ; 
        Iterator<Producto> i = this.productos.iterator();
        while (i.hasNext()) {            
            Producto leida = i.next();
            if (prod==leida) {
                i.remove();
                break;
            }
        }
        return eliminado;
    }

}