/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
1. Un vendedor minorista en línea requiere un informe de las ventas del día. Para ello cuenta con tres arreglos de n 
elementos cada uno: A, B y C. El primero almacena el código de los productos vendidos en el día, El segundo almacena 
el valor de venta de cada producto, y el tercero la cantidad de unidades vendidas de cada producto.
 Requiere un aplicativo que le calcule rápidamente los siguientes datos: 
 Total productos vendidos en el día.
 Total ingresos por ventas del día.
 El producto más vendido.
 El producto más costoso vendido.
*/
package Taller3;

import java.util.Scanner;

/**
 *
 * @author josec
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        
        int nElementos;
        System.out.print("Ingrese el numero de productos : ");
        nElementos=entrada.nextInt();
        
        long [] A= new long [nElementos];
        double [] B= new double [nElementos];
        int [] C = new int [nElementos];
        
        for (int i = 0; i < nElementos; i++) {
            
            System.out.printf("Ingrese el codigo del producto #%d", i+1);
            A[i]=entrada.nextLong();
            System.out.printf("Ingrese el Valor de venta del producto #%d", i+1);
            B[i]=entrada.nextDouble();
            System.out.printf("Ingrese las cantidades vendidas del producto #%d", i+1);
            C[i]=entrada.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
    
        }
        
        
        
    }
            
            
            
            
            
    
}
