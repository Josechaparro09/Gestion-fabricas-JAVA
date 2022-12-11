
package View;

import Modelo.*;
import java.util.Date;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
        //Creacion de objetos
//        
//        Empleado e1 = new Empleado();
//        Planta p1 = new Planta();
//        Producto pro1 = new Producto();
//        Categoria c1 = new Categoria();
//        MateriaPrima mp1 = new MateriaPrima();
//        Venta v1 = new Venta();
//        
//        //Prueba setters
//        
//        e1.setNombres("Jose Alberto");
//        e1.setApellidos("Chaparro Castro");
//        e1.setCedula("1066875671");
//        e1.agregarEmpleado();
//        System.out.println(e1.BuscarEmpleadoByCC("1066875671"));
//        e1.setFechaIngreso(new Date());
//        e1.setPlantaEnc(p1);
//        e1.setTelefono("3024105794");
//        p1.setNombre("Esencias");
//        p1.setEmpleadoAsig(e1);
//        c1.setNombre("Esencia");
//        pro1.setNombreProd("Esencia kola");
//        pro1.setCantidad(12);
//        pro1.setCostoProduccion(800);
//        pro1.setPrecioVenta(2000);
//        mp1.setNombre("Goma xantha");
//        mp1.setFechaCompra(new Date());
//        mp1.setCatidad(2);
//        mp1.setMedida("Kilo");
//        mp1.setUnidades(5);
//        
//        //
//        Categoria c2 = new Categoria("Salsa", "5444");
//        Producto pro2 = new Producto("123456", "Esencia Chicle", c1, 6, 1500, 1000);
//        Producto pro3 = new Producto("456789", "Esencia Coco", c1, 20, 1500, 1000);
//        Producto pro4 = new Producto("789321", "Salsa de ajo", c2, 15, 1500, 1000);
//        
//        
//        //
//        
//        
//        Preventa pv1 = new Preventa();
//        pv1.agregarPreventa();
//        Produccion producc1 = new Produccion("P1", new Date(), e1, p1, pro1, c1, mp1, 0.5, 5);
//
//        Fabrica f1 = new Fabrica("Sabores del valle SAS", "120001001219", "Cra 41 # 5e 29", producc1, e1, v1, c1, pro1, p1, mp1);
//        p1.setFabricaAsig(f1);
//        f1.getLibro().agregarCategoria(c1);
//        f1.getLibro().agregarCategoria(c2);
//        f1.getLibro().agregarProducto(pro1);
//        f1.getLibro().agregarProducto(pro2);
//        f1.getLibro().agregarProducto(pro3);
//        f1.getLibro().agregarProducto(pro4);
//        
        //Mostrar datos
        
        //System.out.println("Fabrica: " +f1);
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
   
    }
    
}
