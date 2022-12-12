package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Categoria {
    //Definicion de atributos
    private String nombre;
    private String id;
    ArrayList<Categoria> categorias = new ArrayList();
    //Constructor por defecto
    public Categoria() {
    }
    //Constructor sobrecargado
    public Categoria(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
    
    
    //Getters y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return  "\nCategoria: " +
                "\nNombre"+ nombre;
    }
    
    public void agregarCategoria(Categoria cag){
        this.categorias.add(cag);
    }
    public Categoria eliminarCategoria(Categoria cag){
        Categoria eliminada = null ; 
        Iterator<Categoria> i = this.categorias.iterator();
        while (i.hasNext()) {            
            Categoria leida = i.next();
            if (cag==leida) {
                i.remove();
                break;
            }
        }
        return eliminada;
    }
    
}