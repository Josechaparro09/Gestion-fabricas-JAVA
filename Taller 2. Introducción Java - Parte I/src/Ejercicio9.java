
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Se desea construir un programa en java que permita calcular el costo total de un viaje que tiene una duración en días.
Para ello, se requiere los siguientes datos: Número de días del viaje, Total de kilómetros conducidos por día, costo por 
litro de gasolina, promedio de kilometro por litro de gasolina, pago por estacionamiento por día, pago de peajes por día. 
Imprima en consola el resultado.

*/

/**
 *
 * @author josec
 */
public class Ejercicio9 {
    
     public static void main(String[] args){
         Scanner entrada = new Scanner(System.in);
         int dias;
         float kilometros , costoGasolina,promGasolina,pEstacionamiento,pPeajes;
         float costoTotal;
         System.out.print("Ingrese el numero de dias del viaje: ");
         dias=entrada.nextInt();
         System.out.print("Ingrese el total de kilómetros conducidos por día: ");
         kilometros=entrada.nextFloat();
         System.out.print("Ingrese el costo por litro de gasolina: ");
         costoGasolina=entrada.nextFloat();
         System.out.print("Ingrese el promedio de kilometro por litro de gasolina: ");
         promGasolina=entrada.nextFloat();
         System.out.print("Ingrese el pago por estacionamiento por día: ");
         pEstacionamiento=entrada.nextFloat();
         System.out.print("Ingrese el pago de peajes por día: ");
         pPeajes=entrada.nextFloat();
         costoTotal=dias*((costoGasolina*(kilometros/promGasolina))+(pEstacionamiento+pPeajes));
         System.out.printf("El conto total del viaje es de: %.2f$" , costoTotal);
         
         
         
         
     }
        
        
    
}
