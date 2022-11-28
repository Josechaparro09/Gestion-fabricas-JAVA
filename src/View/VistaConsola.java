package View;
import Datos.*;
import Modelo.Empleado;
public class VistaConsola {
    
    private static String menu[]={
        "1. Fabrica",
        "2. Empleados",
        "3. Productos",
        "4. Categorias",
        "5. Ventas",
        
        
    };

    private static String empleados[]={
        "1. Agregar empleado",
        "2. Eliminar empleado",
        "3. Buscar empleado"
    };
    private static String productos[]={
        "1. Agregar producto",
        "2. Eliminar producto",
        "3. Buscar producto"
    };
    private static String categorias[]={
        "1. Agregar categoria",
        "2. Eliminar categoria",
        "3. Buscar categoria"
    };
    private static String ventas[]={
        "1. Nueva venta",
        "2. Eliminar venta",
        "3. Buscar venta"
    };

 
    
    
    public void imprimirMenus(String[] m){
        for (int i = 0; i < m.length; i++) {
                System.out.println(menu[i]);
            }
    }
    public void menu(){
        
        do { 
            imprimirMenus(menu);
            
        } while (true);
        
    }
    public void validaropciones(int n){
        if (true) {
            
        }
    }
    public void menuVentas(){
        
        
        
    }
    public void agregarEmpleado(){

        
                
    }
    
}
