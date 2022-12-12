package modelo;


public class Sede {
    private String nombre;
    private String direccion;
    private String ciudad;
    public static final Integer NO_MAX_CTA=10;
    private Integer codigo;
    private Banco banco;

    public Sede(String nombre, String direccion, String ciudad, Integer codigo, Banco banco) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigo = codigo;
        this.banco = banco;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    
}
