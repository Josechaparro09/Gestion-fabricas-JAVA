
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Juan conoce el precio de compra y de venta de unos de los productos de su tienda y requiere conocer cuál es su % de 
utilidad. Desarrolle un programa en java que lo ayude con ese cálculo
*/

/**
 *
 * @author josec
 */
public class Ejercicio7 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        double precioCompra, precioVenta,utilidad;
        System.out.print("Ingrese el precio de compra del producto: ");
        precioCompra=entrada.nextDouble();
        System.out.print("Ingrese el precio de venta del producto: ");
        precioVenta=entrada.nextDouble();
        utilidad=((precioVenta-precioCompra)/(precioVenta)*100);
        System.out.printf("El porcentaje de utilidad es del: %.2f porciento ", utilidad);
        
        
        
    }
    
}
