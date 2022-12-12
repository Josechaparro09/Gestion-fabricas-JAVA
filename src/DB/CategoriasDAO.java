/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.*;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author josec
 */
public class CategoriasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCag(Categoria cag) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO categorias(id_categoria , n_cag ) VALUES (?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cag.getId());
            ps.setString(2, cag.getNombre());
            ps.execute();
            con.close();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException scv){
            JOptionPane.showMessageDialog(null, "La Categoria ya existe");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public ArrayList<Categoria> listarCag() throws SQLException{
        ArrayList<Categoria> listaCag = new ArrayList();
        String sql = "SELECT * FROM categorias";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cag = new Categoria();
                cag.setId(rs.getString("id_categoria"));
                cag.setNombre(rs.getString("n_cag"));
                
                listaCag.add(cag);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaCag;
    }
    public boolean ModificarCag(Categoria cag) {
        String sql = "UPDATE categorias SET id_categoria=? ,n_cag = ? WHERE id_categoria  = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cag.getId());
            ps.setString(2, cag.getNombre());
            ps.setString(3, cag.getId());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean eliminarCag(String id_categoria) throws SQLException{
        String sql = "DELETE FROM categorias WHERE id_categoria = ?";
        try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, id_categoria);
            ps.execute();
            con.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public ArrayList<Categoria> listaCategorias(){
        ArrayList<Categoria> listaCag= new ArrayList();  
         try {
            con = cn.getConexion();
           
            String sql = "SELECT * FROM categorias";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                Categoria cag = new Categoria();
                cag.setId(rs.getString("id_categoria"));
                cag.setNombre(rs.getString("n_cag"));
                
                listaCag.add(cag);
                
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
         

        return listaCag;
    }
    
}
