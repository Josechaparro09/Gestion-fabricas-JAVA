
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Preventa {
    private int cantP ;
    private double total;
    private Producto producto;
    private double gananciasPre;
    ArrayList<Preventa> preventa = new ArrayList();
    
    public Preventa() {
    }

    public Preventa(int cantidadP, Producto producto) {
        this.cantP = cantidadP;
        this.producto = producto;
        this.total = calcularTotal();
        this.gananciasPre=this.calcularGananciasPre();
//        this.producto.setCantidad(this.producto.getCantidad()-this.cantP);
        
    }

    public int getCantP() {
        return cantP;
    }

    public double getGananciasPre() {
        return gananciasPre;
    }

    public void setGananciasPre(double gananciasPre) {
        this.gananciasPre = gananciasPre;
    }
    
    
    public void setCantP(int cantP) {
        this.cantP = cantP;
    }

    public ArrayList<Preventa> getPreventa() {
        return preventa;
    }

    public void setPreventa(ArrayList<Preventa> preventa) {
        this.preventa = preventa;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public double calcularTotal(){
        this.total = this.cantP*this.producto.getPrecioVenta();
        return total;
    }
    public void agregarPreventa(){
        preventa.add(this);
    }
    public void eliminarPreventa(Preventa pre){
        Iterator<Preventa> i = this.preventa.iterator();
        while (i.hasNext()) {            
            Preventa leida = i.next();
            if (pre==leida) {
                i.remove();
                break;
            }
        }
    }
    
    public boolean validarPPreventa(){
        
//        if (this.cantP>this.producto.getCantidad()) {
//            return false;
//        }else{
//            return true;
//        }
        return false;
    }
    public double calcularGananciasPre(){
        if (validarPPreventa()) {
            this.gananciasPre+=this.producto.getPrecioVenta()-this.producto.getCostoProduccion();
        }
        return this.gananciasPre;
    }
}
