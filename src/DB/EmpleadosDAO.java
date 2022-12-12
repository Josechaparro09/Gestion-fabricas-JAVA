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
public class EmpleadosDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpleado(Empleado em) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO empleados(cc,p_nombre,s_nombre,p_apellido,s_apellido,telefono,f_ingreso) VALUES (?,?,?,?,?,?,NOW())";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCedula());
            ps.setString(2, em.getP_nombre());
            ps.setString(3, em.getS_nombre());
            ps.setString(4, em.getP_apellido());
            ps.setString(5, em.getS_apellido());
            ps.setString(6, em.getTelefono());
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
        String sql = "SELECT * FROM empleados";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setCedula(rs.getString("cc"));
                emp.setP_nombre(rs.getString("p_nombre"));
                emp.setS_nombre(rs.getString("s_nombre"));
                emp.setP_apellido(rs.getString("p_apellido"));
                emp.setS_apellido(rs.getString("s_apellido"));
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
        String sql = "UPDATE empleados SET cc=? ,p_nombre = ?, s_nombre = ?,p_apellido = ? , s_apellido = ? , telefono = ? WHERE cc  =?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCedula());
            System.out.println(em.getCedula());
            ps.setString(2, em.getP_nombre());
            ps.setString(3, em.getS_nombre());
            ps.setString(4, em.getP_apellido());
            ps.setString(5, em.getS_apellido());
            ps.setString(6, em.getTelefono());
            ps.setString(7, em.getCedula());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    public boolean eliminarEmpleado(String cedula) throws SQLException{
        String sql = "DELETE FROM empleados WHERE cc = ?";
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
