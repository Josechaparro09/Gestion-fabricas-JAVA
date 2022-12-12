
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Desarrolle un programa en java que calcule el índice de masa corporal BMI el cual está dado por la formula (pesoenKg 
/ alturaenmetros*alturaenmetros)
*/

/**
 *
 * @author josec
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        float altura, peso,bmi;
        System.out.print("Ingrese su peso en Kilogramos (Kg): ");
        peso = entrada.nextFloat();
        System.out.print("Ingrese su altura en metros (m):");
        altura=entrada.nextFloat();
        bmi=(peso/(altura*altura));
        System.out.printf("Su Indice de masa corporal (BMI) es de: %f",bmi);
        
        
        
        
    }
    
}
