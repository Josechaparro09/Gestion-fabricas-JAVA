
package Models;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class ProductosDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrar(Productos pro){
        String sql = "INSERT INTO productos (codigo, descripcion, precio_compra, precio_venta, id_proveedor, id_medida, id_categoria) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio_compra());
            ps.setDouble(4, pro.getPrecio_venta());
            ps.setInt(5, pro.getId_proveedor());
            ps.setInt(6, pro.getId_medida());
            ps.setInt(7, pro.getId_categoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public List ListaProductos(String valor){
        List<Productos> listaPro = new ArrayList();
        String sql = "SELECT * FROM productos ORDER BY estado ASC";
        String buscar = "SELECT * FROM productos WHERE codigo LIKE '%"+valor+"%' OR descripcion LIKE '%"+valor+"%'";
        try {
            con = cn.getConexion();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            }else{
                ps = con.prepareStatement(buscar);
            rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_venta(rs.getInt("precio_venta"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setEstado(rs.getString("estado"));
                listaPro.add(pro);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaPro;
    }
    public boolean modificar(Productos pro){
        String sql = "UPDATE productos SET codigo = ?, descripcion = ?, precio_compra = ?, precio_venta = ?, id_proveedor = ?, id_medida = ?, id_categoria = ? WHERE id = ? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio_compra());
            ps.setDouble(4, pro.getPrecio_venta());
            ps.setInt(5, pro.getId_proveedor());
            ps.setInt(6, pro.getId_medida());
            ps.setInt(7, pro.getId_categoria());
            ps.setInt(8, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean accion(String estado , int id ){
        String sql = "UPDATE productos SET estado = ? WHERE id = ?";
        try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return  false;
        
    }
    public Productos BuscarPro(int id){
        String sql = "SELECT p.*,pr.id,pr.proveedor,m.id,m.medida,c.id,c.categoria FROM productos p INNER JOIN proveedores pr ON p.id_proveedor = pr.id INNER JOIN medidas m ON p.id_medida = m.id INNER JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
        Productos pro = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setCodigo(rs.getString("codigo"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_compra(rs.getDouble("precio_compra"));
                pro.setPrecio_venta(rs.getDouble("precio_venta"));
                pro.setId_proveedor(rs.getInt("id_proveedor"));
                pro.setId_medida(rs.getInt("id_medida"));
                pro.setId_categoria(rs.getInt("id_categoria"));
                pro.setProveedor(rs.getString("proveedor"));
                pro.setMedida(rs.getString("medida"));
                pro.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pro;
    }
    
}
