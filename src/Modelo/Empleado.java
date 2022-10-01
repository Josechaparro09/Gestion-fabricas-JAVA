package Modelo;

public class Empleado {
    
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    public Planta plantaEnc;
    
    public Empleado() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Planta getPlantaEnc() {
        return plantaEnc;
    }

    public void setPlantaEnc(Planta plantaEnc) {
        this.plantaEnc = plantaEnc;
    }
    









}