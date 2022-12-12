package cuenta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cuenta c1 = new Cuenta();
        System.out.println("Inserte el numero de cuenta");
        c1.setNoCuenta(sc.nextInt());
        System.out.println("Inserte el nombre del cliente");
        c1.setNombreCliente(sc.next());
        System.out.println("Ingrese el saldo");
        c1.setSaldo(sc.nextDouble());
        System.out.println("Ingrese el monto a consignar");
        c1.consignar(sc.nextDouble());
        System.out.println("Ingrese el monto a retirar");
        c1.retirar(sc.nextDouble());
        
        
        
    }
    
}
