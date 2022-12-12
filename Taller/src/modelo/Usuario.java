package modelo;


public class Usuario {
    
    private String cc;
    private String nombre;
    private String apellido;
    private char sexo;
    private Cuenta cuenta;

    public Usuario(String cc, String nombre, String apellido, char sexo) {
        this.cc = cc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }
    
    
    
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }
    
    @Override
    public String toString(){
        String sex;
        if(this.sexo=='M'){
            sex = "Masculino";
        }else{
            sex="Femenino";
        }
        return(   "Nombre: " + this.nombre + "\n" 
                + "Apellido: " + this.apellido+ "\n" 
                + "CC:" + this.cc+"\n"
                + "Sexo:" + sex);
    }
    
}
