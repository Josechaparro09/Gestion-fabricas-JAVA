
package Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedidasDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean registrar(Medidas md){
        String sql = "INSERT INTO medidas (medida, nombre_corto) VALUES (?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, md.getNombre());
            ps.setString(2, md.getNombre_corto());

            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public List ListaMedidas(String valor){
        List<Medidas> listaMedidas = new ArrayList();
        
        
        try {
            con = cn.getConexion();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM medidas ORDER BY estado ASC";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            }else{
                String buscar = "SELECT * FROM medidas WHERE medida LIKE '%"+valor+"%' OR nombre_corto LIKE '%"+valor+"%'";
                ps = con.prepareStatement(buscar);
                rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Medidas md = new Medidas();
                md.setId(rs.getInt("id"));
                md.setNombre(rs.getString("medida"));
                md.setNombre_corto(rs.getString("nombre_corto"));
                md.setEstado(rs.getString("estado"));
                listaMedidas.add(md);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaMedidas;
    }
    public boolean modificar(Medidas md){
        String sql = "UPDATE medidas SET medida = ?, nombre_corto = ? WHERE id = ? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, md.getNombre());
            ps.setString(2, md.getNombre_corto());
            ps.setInt(3, md.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean accion(String estado , int id ){
        String sql = "UPDATE medidas SET estado = ? WHERE id = ?";
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
