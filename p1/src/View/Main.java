/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author josec
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DAtos ii = new DAtos();
        ii.eso(0);
        ii.eso(2);
        ii.eso(2);
        ii.eso(2);
        for (Integer i : ii.getDa()) {
            System.out.println(i);
        }
        
    }
    
}
