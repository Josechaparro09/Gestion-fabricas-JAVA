
package Controller;


public class TrabajadoresCE {
    private String prueba;

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public TrabajadoresCE(String prueba) {
        this.prueba = prueba;
    }
    
    public String mostrar(){
        String dato = String.format("Aca esta la prueba"+prueba);
        return dato;
    }
    
    
    
}
