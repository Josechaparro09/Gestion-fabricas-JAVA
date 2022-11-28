
package View;

import Modelo.*;
import java.util.ArrayList;

public class Pantalla {
    
    private VistaConsola m1 = new VistaConsola();
    
    
     public static int imprimirMenu(String titulo, String opciones[]){
        Pantalla.tituloVista(titulo);
        for(int i=0; i<opciones.length; i++){
            System.out.printf("| %-35s |%n", opciones[i]);
        }
        System.out.println("---------------------------------------");
        int opc = Teclado.leerInt("Seleccione una opcion:");
        return opc;
    }
    
   public static void imprimirEmpleados(ArrayList<Empleado> emp){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s%n",
                          "CC", 
                          "Nombre", 
                          "Apellido",
                          "Telefono", 
                          "Planta enc");
        System.out.println("--------------------------------------------------------------------------------------------");
        for(Empleado c: emp){
            System.out.println("| "+c.consultarDatos()+" |");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
                
    }

    public static void imprimirProductos(ArrayList<Producto> prod){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%15s\t%15s\t%15s\t%10.2f\t%10.2f\t%2d",
                          "Nombre", 
                          "Categoria", 
                          "Costo Producc","Precio venta", 
                          "Cantidad");
        System.out.println("--------------------------------------------------------------------------------------------");
        for(Producto p: prod){
            System.out.println("| "+p.consultarDatos()+" |");
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
    
    public static void tituloVista(String titulo){
        System.out.println("\n---------------------------------------");
        System.out.printf("| %-35s |%n", titulo.toUpperCase());
        System.out.println("---------------------------------------");
    }
    
    public static void msgExito(){
        System.out.println("!! Operacion realizada con exito ¡¡");
    }
    
    public static void msgNoEncontrada(){
        System.out.println("!! La cuenta no se encuentra registrada ¡¡");
    }
    
    public static int msgConfirmacion(){
        int opc;
        do{
            opc = Teclado.leerInt("¿Desea confirmar ? [1->si] [2->no]","");
        }while(opc!=1 && opc!=2);
        return opc;
    }
    
    public static void printTexto(String dato){
        System.out.printf("%s %-15s:",">>",dato);
    }
    
    public static void printTexto(String dato, String marcador){
        System.out.printf("%s %-15s:",marcador,dato);
    }

    public void imprimirCategorias(ArrayList<Categoria> cag){
        
    }

    public void imprimirVentas(ArrayList<Venta> vent){
        
    }

}
