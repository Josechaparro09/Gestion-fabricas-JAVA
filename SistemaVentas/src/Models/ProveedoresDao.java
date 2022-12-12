/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Yurainis
 */
public class ProveedoresDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean registrar(Proveedores pv){
        String sql = "INSERT INTO proveedores (proveedor, telefono, direccion) VALUES (?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pv.getNombre());
            ps.setString(2, pv.getTelefono());
            ps.setString(3, pv.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public List ListaProveedores(String valor){
        List<Proveedores> listaProveedores = new ArrayList();
        
         try {
            con = cn.getConexion();
            if ("".equalsIgnoreCase(valor)) {
                String sql = "SELECT * FROM proveedores ORDER BY estado ASC";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            }else{
                String buscar = "SELECT * FROM proveedores WHERE proveedor LIKE '%"+valor+"%' OR telefono LIKE '%"+valor+"%'";
       
                ps = con.prepareStatement(buscar);
                rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Proveedores pv = new Proveedores();
                pv.setId(rs.getInt("id"));
                pv.setNombre(rs.getString("proveedor"));
                pv.setTelefono(rs.getString("telefono"));
                pv.setDireccion(rs.getString("direccion"));
                pv.setEstado(rs.getString("estado"));
                listaProveedores.add(pv);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProveedores;
    }
    public boolean modificar(Proveedores pv){
        String sql = "UPDATE proveedores SET proveedor = ?, telefono = ?, direccion = ? WHERE id = ? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pv.getNombre());
            ps.setString(2, pv.getTelefono());
            ps.setString(3, pv.getDireccion());
            ps.setInt(4, pv.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean accion(String estado , int id ){
        String sql = "UPDATE proveedores SET estado = ? WHERE id = ?";
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
