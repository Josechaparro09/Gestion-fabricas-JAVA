package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Venta {

    //Definicion de atributos
//    private Producto productoVen;
    private String idVenta;
//    private int cantidadProd;
//    private double precio;
    private double totalVenta;
    private Date fechaVenta;
    private Preventa preventa;
    private double ganancias;
    ArrayList<Venta> ventas = new ArrayList();
    
    //Constructor por defecto
    public Venta() {
    }

    public Venta(String idVenta, Date fechaVenta, Preventa preventa) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.preventa = preventa;
        this.totalVenta=this.calcularTotalVenta();
        this.ganancias=this.calcularGananciasVenta();
    }
    
    
//    public Venta(Producto productoVen, String idVenta, int cantidadProd, double precio, double totalVenta, Date fechaVenta) {
//        this.productoVen = productoVen;
//        this.idVenta = idVenta;
//        this.cantidadProd = cantidadProd;
//        this.precio = precio;
//        this.totalVenta = totalVenta;
//        this.fechaVenta = fechaVenta;
//    }

    

    //Getters y Setters
//    public Producto getProductoVen() {
//        return productoVen;
//    }
//
//    public void setProductoVen(Producto productoVen) {
//        this.productoVen = productoVen;
//    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

//    public int getCantidadProd() {
//        return cantidadProd;
//    }
//
//    public void setCantidadProd(int cantidadProd) {
//        this.cantidadProd = cantidadProd;
//    }

//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
//    }

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

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public double calcularTotalVenta(){   
        for (Preventa pre : preventa.getPreventa()) {
            this.totalVenta+=pre.getTotal();
        }
        return this.totalVenta;
    }
    
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
    public double calcularGananciasVenta(){
        
        for (Preventa pre : preventa.getPreventa()) {
            this.ganancias+=pre.getGananciasPre();
        }
        return this.ganancias;
    }
    public void agregarPreventa(){
        
    }
    

    
}