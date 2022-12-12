package DB;
import Modelo.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ProductosDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProd(Producto prod) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO productos(id_producto,nom_producto,p_produccion,p_venta,categorias_id_categoria,medidas_id_medida) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getIdProducto());
            ps.setString(2, prod.getNombreProd());
            ps.setDouble(3, prod.getCostoProduccion());
            ps.setDouble(4, prod.getPrecioVenta());
            ps.setString(5, prod.getCagProducto());
            ps.setString(6, prod.getMedidaProd());
            ps.execute();
            con.close();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException scv){
            JOptionPane.showMessageDialog(null, "El producto ya existe");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public ArrayList<Producto> listarProd() throws SQLException{
        ArrayList<Producto> listaProd = new ArrayList();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getString("id_producto"));
                prod.setNombreProd(rs.getString("nom_producto"));
                prod.setCostoProduccion(rs.getDouble("p_produccion"));
                prod.setPrecioVenta(rs.getDouble("p_venta"));
                prod.setCagProducto(rs.getString("categorias_id_categoria"));
                prod.setMedidaProd(rs.getString("medidas_id_medida"));
                listaProd.add(prod);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProd;
    }
    public boolean ModificarProd(Producto prod) {
        String sql = "UPDATE productos SET id_producto=? ,nom_producto = ?, p_produccion = ?,p_venta = ? , categorias_id_categoria = ? , medidas_id_medida = ? WHERE id_producto  =?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getIdProducto());
            ps.setString(2, prod.getNombreProd());
            ps.setDouble(3, prod.getCostoProduccion());
            ps.setDouble(4, prod.getPrecioVenta());
            ps.setString(5, prod.getCagProducto());
            ps.setString(6, prod.getMedidaProd());
            ps.setString(7, prod.getIdProducto());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean eliminarProd(String id_producto) throws SQLException{
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, id_producto);
            ps.execute();
            con.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
}
