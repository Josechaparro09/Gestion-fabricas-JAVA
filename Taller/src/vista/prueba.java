
package vista;

import modelo.Cuenta;
import modelo.Usuario;

public class prueba {
    public static void main(String[] args) {
        System.out.println(
        "----------Menu----------\n"+
        "1. Crear banco \n" +
        "2. Crear sede bancaria\n"+
        "3. Consulta sede bancaria\n"+
        "4. Consulta cuenta\n");
        Usuario a = new Usuario("1066875671", "Jose", "Chaparro", 'M');
       Cuenta c1 = new Cuenta("1066875671", "corriente", 1000000, a);
        System.out.println(c1);
    }
    
    
}
