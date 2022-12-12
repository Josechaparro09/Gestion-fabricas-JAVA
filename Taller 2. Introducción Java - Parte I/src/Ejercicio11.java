
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Desarrolle un programa en java que lea una cantidad numérica entre cero y mil (0 y 1000) e imprima la cifra
correspondiente a sus unidades, decenas y centenas.
*/

/**
 *
 * @author josec
 */
public class Ejercicio11 {
    
     public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int numero,unidades,decenas,centenas,residuo;
        System.out.print("Ingrese un numero entre 0 y 1000: ");
        numero=entrada.nextInt();
        centenas=numero/100;
        residuo=numero-(centenas*100);
        decenas=residuo/10;
        unidades=residuo-(decenas*10);
        System.out.printf("Unidades: %d%n", unidades);
        System.out.printf("Decenas: %d%n", decenas);
        System.out.printf("Centenas: %d%n", centenas);
        
        
        
        
        
        
     }
    
}
