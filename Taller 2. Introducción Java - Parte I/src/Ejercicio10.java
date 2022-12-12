
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Escriba un programa en Java que lea el peso de un objeto (en kilogramos) e imprima su equivalencia en: gramos, libras, 
toneladas.
*/

/**
 *
 * @author josec
 */
public class Ejercicio10 {
     public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float peso;
        System.out.print("Ingrese el peso del objeto en kilogramos (Kg) ");
        peso=entrada.nextFloat();
        System.out.printf("Peso en gramos: %.2f%n", (peso*1000));
        System.out.printf("Peso en libras: %.2f%n", (peso*2.2));
        System.out.printf("Peso en toneladas: %.2f%n", (peso/1000));
        
        
     }
    
}
