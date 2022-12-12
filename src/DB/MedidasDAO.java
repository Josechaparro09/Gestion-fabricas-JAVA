/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josec
 */
public class MedidasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarMedidas(Medida me) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO medidas(id_medida , n_medida , n_corto) VALUES (?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, me.getIdMedida());
            ps.setString(2, me.getNombre());
            ps.setString(3, me.getnCorto());
            ps.execute();
            con.close();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException scv){
            JOptionPane.showMessageDialog(null, "La medida ya existe");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public ArrayList<Medida> listarMedidas() throws SQLException{
        ArrayList<Medida> listaMedidas = new ArrayList();
        String sql = "SELECT * FROM medidas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medida me = new Medida();
                me.setIdMedida(rs.getString("id_medida"));
                me.setNombre(rs.getString("n_medida"));
                me.setnCorto(rs.getString("n_corto"));
                listaMedidas.add(me);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaMedidas;
    }
    public boolean ModificarMedida(Medida me) {
        String sql = "UPDATE medidas SET id_medida=? ,n_medida = ?, n_corto = ? WHERE id_medida  = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, me.getIdMedida());
            ps.setString(2, me.getNombre());
            ps.setString(3, me.getnCorto());
            ps.setString(4, me.getIdMedida());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean eliminarMedida(String id_medida) throws SQLException{
        String sql = "DELETE FROM medidas WHERE id_medida = ?";
        try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, id_medida);
            ps.execute();
            con.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
     public ArrayList<Medida> listaMedidas(){
        ArrayList<Medida> listaMed= new ArrayList();  
         try {
            con = cn.getConexion();
           
            String sql = "SELECT * FROM medidas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                Medida med = new Medida();
                med.setIdMedida(rs.getString("id_medida"));
                med.setNombre(rs.getString("n_medida"));
                med.setNombre(rs.getString("n_corto"));
                
                listaMed.add(med);
                
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return listaMed;
    }
    
}
