
package Datos;

import Modelo.*;

import java.util.ArrayList;

public interface IAEntidades {

    ArrayList<Categoria> agregarCategoria(Categoria cag);
    ArrayList<Empleado> agregarEmpleado(Empleado emp);
    ArrayList<Venta> agregarVenta(Venta ven);
    ArrayList<Producto> agregarProducto(Producto prod);
    ArrayList<Preventa> agregarPreventa(Preventa pre);
    
    
    
    
}
