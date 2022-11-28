
package View;

import java.util.Scanner;

public class Teclado {
    
    private static Scanner entrada = new Scanner(System.in);
    
    public static int leerInt(String dato){
        System.out.printf("%",dato);
        return entrada.nextInt();
    }
    public static int leerInt(String dato, String marcador){
        Pantalla.printTexto(dato, marcador);
        return entrada.nextInt();
    }
    
    public static double leerDouble(String dato){
        Pantalla.printTexto(dato);
        return entrada.nextDouble();
    }
    
    public static String leerLinea(String dato){
        Pantalla.printTexto(dato);
        entrada = new Scanner(System.in);
        return entrada.nextLine();
    }
    
    public static String leerString(String dato){
        Pantalla.printTexto(dato);
        entrada = new Scanner(System.in);
        return entrada.nextLine();
    }
    
}
