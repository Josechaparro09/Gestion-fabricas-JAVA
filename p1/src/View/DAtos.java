/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;

/**
 *
 * @author josec
 */
public class DAtos {
    
    
    private  int eso;
    private  ArrayList<Integer> da ;

    public DAtos() {
    }

    public  int getEso() {
        return eso;
    }

    public void setEso(int eso) {
        this.eso = eso;
    }

    public  ArrayList<Integer> getDa() {
        return da;
    }

    public  void setDa(ArrayList<Integer> da) {
        this.da = da;
    }

    
    public  void eso(int a){
        da.add(a);
    }

    
}
