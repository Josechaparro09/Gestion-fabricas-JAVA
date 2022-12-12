
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Escriba una aplicación que reciba tres valores decimales del usuario y muestre la suma, promedio, producto, cociente 
y modulo. Los resultados se deben imprimir en formato decimal con dos cifras significativas.
*/

/**
 *
 * @author josec
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float num1 , num2 , num3, sum, prom , cociente , modulo;

        
        System.out.print("Digite el primer numero: ");
        num1=entrada.nextFloat();
        System.out.print("Digite el segundo numero: ");
        num2=entrada.nextFloat();
        System.out.print("Digite el tercer numero: ");
        num3=entrada.nextFloat();
        System.out.printf("La suma de los numero ingresados es de: %.2f%n" , sum=(num1+num2+num3));
        System.out.printf("El promedio de los numero ingresados es de: %.2f%n",(sum/3));
        System.out.printf("El producto de los numeros ingresados es de: %.2f%n", prom=(num1*num2*num3));
        System.out.printf("EL cociente de los numeros ingresados es de: %.2f%n", cociente=(num1/num2/num3));
        System.out.printf("El modulo de los numeros ingresados es de: %.2f%n", modulo=(num1%num2%num3));
        
        
    }

    
    
}
