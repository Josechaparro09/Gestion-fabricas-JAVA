package Modelo;

import java.util.Date;

public class Venta {

    //Definicion de atributos
    private Producto productoVen;
    private String idVenta;
    private int cantidadProd;
    private double precio;
    private double totalVenta;
    private Date fechaVenta;
    
    //Constructor por defecto
    public Venta() {
    }

    //Getters y Setters
    public Producto getProductoVen() {
        return productoVen;
    }

    public void setProductoVen(Producto productoVen) {
        this.productoVen = productoVen;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
}