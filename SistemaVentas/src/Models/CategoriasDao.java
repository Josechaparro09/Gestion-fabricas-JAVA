
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriasDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean registrar(Categorias ct){
        String sql = "INSERT INTO categorias (categoria) VALUES (?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ct.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public List ListaCategorias(String valor){
        List<Categorias> listaCategorias = new ArrayList();
        String sql = "SELECT * FROM categorias ORDER BY estado ASC";
        String buscar = "SELECT * FROM categorias WHERE categoria LIKE '%"+valor+"%'";
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
                Categorias ct = new Categorias();
                ct.setId(rs.getInt("id"));
                ct.setNombre(rs.getString("categoria"));
                ct.setEstado(rs.getString("estado"));
                listaCategorias.add(ct);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaCategorias;
    }
    public boolean modificar(Categorias ct){
        String sql = "UPDATE categorias SET categoria = ? WHERE id = ? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ct.getNombre());
            ps.setInt(2, ct.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean accion(String estado , int id ){
        String sql = "UPDATE categorias SET estado = ? WHERE id = ?";
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
    
}
