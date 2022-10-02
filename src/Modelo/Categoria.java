package Modelo;

public class Categoria {
    //Definicion de atributos
    private String nombre;
    private String codigo;
    
    //Constructor por defecto
    public Categoria() {
    }
    
    
    //Getters y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return  "\nCategoria: " +
                "\nNombre"+ nombre;
    }
    
    
}