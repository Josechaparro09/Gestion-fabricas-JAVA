/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author josec
 */
public class Libro implements IAEntidades{

    
    private ArrayList<Categoria> libroCategoria;
    private ArrayList<Empleado> libroEmpleado;
    private ArrayList<Venta> libroVenta;
    private ArrayList<Preventa> libroPreventa;
    private ArrayList<Producto> libroProducto;

    public Libro(ArrayList<Categoria> libroCategoria, ArrayList<Empleado> libroEmpleado, ArrayList<Venta> libroVenta, ArrayList<Preventa> libroPreventa, ArrayList<Producto> libroProducto) {
        this.libroCategoria = libroCategoria;
        this.libroEmpleado = libroEmpleado;
        this.libroVenta = libroVenta;
        this.libroPreventa = libroPreventa;
        this.libroProducto = libroProducto;
    }

    
    public Libro() {
        this.libroCategoria = new ArrayList();
        this.libroEmpleado = new ArrayList();
        this.libroVenta = new ArrayList();
        this.libroProducto = new ArrayList();
        this.libroPreventa = new ArrayList();
    }

    public ArrayList<Categoria> getLibroCategoria() {
        return libroCategoria;
    }

    public void setLibroCategoria(ArrayList<Categoria> libroCategoria) {
        this.libroCategoria = libroCategoria;
    }

    public ArrayList<Empleado> getLibroEmpleado() {
        return libroEmpleado;
    }

    public void setLibroEmpleado(ArrayList<Empleado> libroEmpleado) {
        this.libroEmpleado = libroEmpleado;
    }

    public ArrayList<Venta> getLibroVenta() {
        return libroVenta;
    }

    public void setLibroVenta(ArrayList<Venta> libroVenta) {
        this.libroVenta = libroVenta;
    }

    public ArrayList<Producto> getLibroProducto() {
        return libroProducto;
    }

    public void setLibroProducto(ArrayList<Producto> libroProducto) {
        this.libroProducto = libroProducto;
    }

    public ArrayList<Preventa> getLibroPreventa() {
        return libroPreventa;
    }

    public void setLibroPreventa(ArrayList<Preventa> libroPreventa) {
        this.libroPreventa = libroPreventa;
    }

    @Override
    public ArrayList<Categoria> agregarCategoria(Categoria cag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empleado> agregarEmpleado(Empleado emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venta> agregarVenta(Venta ven) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> agregarProducto(Producto prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Preventa> agregarPreventa(Preventa pre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
