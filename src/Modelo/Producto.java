package Modelo;

public class Producto {

    private String codProducto;
    private String nombreProd;
    private Categoria cagProducto;
    private int cantidad;
    private double precioVenta;
    private double costoProduccion;
    
    public Producto() {
    }

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
    









}