package modelo;


public class Banco {
    
    private String nombre ;
    private Sede sede;
    public static Integer NO_MAX_SEDES=10;

    public Banco(String nombre) {
        this.nombre = nombre;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Integer getNO_MAX_SEDES() {
        return NO_MAX_SEDES;
    }

    public static void setNO_MAX_SEDES(Integer NO_MAX_SEDES) {
        Banco.NO_MAX_SEDES = NO_MAX_SEDES;
    }
    
}
