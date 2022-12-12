
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josec
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int x;
        int y;
        System.out.printf("Digite el valor de x : %n");
        x=entrada.nextInt();
        System.out.printf("Digite el valor de num2 : %n");
        y=entrada.nextInt();
        System.out.printf("x = %d\n", x );
        System.out.printf("El valor de %d + %d es %d\n", x, x, ( x + x ) );
        System.out.printf("x=%.2f%n", (double)x );
        System.out.printf("%d - %d\n", ( x + y ), ( y + x ) );
        
    } 
    
}
