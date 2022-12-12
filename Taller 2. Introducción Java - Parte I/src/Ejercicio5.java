
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Escriba un programa en Java que lea un carácter e imprima su correspondiente valor numérico (utilizar la conversión
de tipos)
*/

/**
 *
 * @author josec
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        char caracter;
        System.out.print("Ingrese un caracter: ");
        caracter = entrada.next().charAt(0);
        System.out.printf("El valor numerico del caracter '%c' es: %d%n ",caracter,(int)caracter );
        
        
    }
    
}
