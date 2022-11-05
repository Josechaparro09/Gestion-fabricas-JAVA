package Modelo;

import java.util.ArrayList;

public class Producto {

    //Definicion de atributos
    private String codProducto;
    private String nombreProd;
    private Categoria cagProducto;
    private int cantidad;
    private double precioVenta;
    private double costoProduccion;
    ArrayList<Producto> productos = new ArrayList();
    
    //Constructor por defecto
    public Producto() {
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
    
    public void agregarProducto(Producto prod){
        this.productos.add(prod);
    }
    public void eliminarProducto(Producto prod){
        ArrayList<Producto> pds = new ArrayList();
        for (Producto p : this.productos) {
            if (p==prod) {
                productos.remove(productos.)
            }
        }
    }

}