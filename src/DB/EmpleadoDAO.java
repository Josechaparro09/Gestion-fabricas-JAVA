/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Conexion;
import Modelo.*;
import java.awt.List;
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
public class EmpleadoDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpleado(Empleado em) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO empleado(cedula,nombres,apellidos,telefono) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCedula());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.execute();
            con.close();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException scv){
            JOptionPane.showMessageDialog(null, "El empleado ya existe");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public ArrayList<Empleado> listarEmpleados() throws SQLException{
        ArrayList<Empleado> listaEmp = new ArrayList();
        String sql = "SELECT * FROM empleado";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setCedula(rs.getString("cedula"));
                emp.setNombres(rs.getString("nombres"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setTelefono(rs.getString("telefono"));
                listaEmp.add(emp);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaEmp;
    }
    public boolean ModificarEmpleado(Empleado em) {
        String sql = "UPDATE empleado SET cedula=? ,nombres = ?, apellidos = ?,telefono = ? WHERE cedula  = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCedula());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean eliminarEmpleado(String cedula) throws SQLException{
        String sql = "DELETE FROM empleado WHERE cedula = ?";
        try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.execute();
            con.close();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    
}
