/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author josec
 */
public class Campeonato {
    
    private String nombre;
    private String dMeses;
    private String premiacion;
    private Equipo [] equipos = new Equipo [5];

    public Campeonato() {
    }

    public Campeonato(String nombre, String dMeses, String premiacion , Equipo[] equipos) {
        this.nombre = nombre;
        this.dMeses = dMeses;
        this.premiacion = premiacion;
        this.equipos[]=equipos;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdMeses() {
        return dMeses;
    }

    public void setdMeses(String dMeses) {
        this.dMeses = dMeses;
    }

    public String getPremiacion() {
        return premiacion;
    }

    public void setPremiacion(String premiacion) {
        this.premiacion = premiacion;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }
    
    
    
}
