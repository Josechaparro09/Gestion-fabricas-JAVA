
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 Escriba una aplicación que pida al usuario que escriba dos enteros, que obtenga los números 
 del usuario e imprima la suma, producto, diferencia de los números.
 */

/**
 *
 * @author josec
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner (System.in);
        int num1;
        int num2;
        
        
       System.out.print("Ingrese el primer numero: ");
       num1=entrada.nextInt();
       System.out.print("Ingrese el segundo numeor: ");
       num2=entrada.nextInt();
       System.out.printf("La suma de %d y %d es: %d%n", num1,num2,suma(num1,num2));
       System.out.printf("El producto de %d y %d es : %d%n",num1,num2, producto(num1 , num2));
       System.out.printf("La diferencia de %d y %d es: %d%n ",num1,num2, diferencia(num1,num2));
       
    }
    public static int suma(int a , int b){
        return a+b;
    }
    public static int producto(int a , int b){
        return a*b;
    }
    public static int diferencia(int a , int b){
        return a-b;
    }
}
