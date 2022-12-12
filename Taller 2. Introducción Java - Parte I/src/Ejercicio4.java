
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Escriba un programa en Java que le solicite al usuario el valor del radio de una circunferencia y calcule su longitud y 
área. Imprima los resultados (con dos números decimales)
*/

/**
 *
 * @author josec
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        
        final double pi=3.141592653589793;
        float radio;
        
        System.out.print("Ingrese el radio del circulo: ");
        radio=entrada.nextFloat();
        System.out.printf("El area del circulo es: %.2f", (pi*(radio*radio)));
        

        
    }
    
    
}
