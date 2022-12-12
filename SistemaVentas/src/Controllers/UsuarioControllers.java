
package Controllers;

import Models.Tables;
import Models.Usuario;
import Models.UsuarioDao;
import Views.Admin;
import com.mysql.cj.xdevapi.Table;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UsuarioControllers implements ActionListener , MouseListener, KeyListener{
    private Usuario us ;
    private UsuarioDao usDao;
    private Admin views;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public UsuarioControllers(Usuario us, UsuarioDao usDao, Admin views) {
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.btnRegistrarUser.addActionListener(this);
        this.views.btnModificarUser.addActionListener(this);
        this.views.jMenuEliminarUser.addActionListener(this);
        this.views.jMenuReingresarUser.addActionListener(this);
        this.views.btnNuevoUser.addActionListener(this);
        this.views.txtBuscarUsers.addKeyListener(this);
        this.views.tableUser.addMouseListener(this);
        this.views.JLabelUsers.addMouseListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarUser) {
            if (views.txtUsuarioUser.getText().equals("") 
                    || views.txtNombreUser.getText().equals("") 
                    || String.valueOf(views.txtClaveUser.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                
            }else{
                us.setUsuario(views.txtUsuarioUser.getText());
                us.setNombre(views.txtNombreUser.getText());
                us.setClave(String.valueOf(views.txtClaveUser.getPassword()));
                us.setCaja(views.cbxCajaUser.getSelectedItem().toString());
                us.setRol(views.cbxRolUser.getSelectedItem().toString());
                if (usDao.registrar(us)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                }
                
                
            }
            
        }else if (e.getSource() == views.btnModificarUser) {
            if (views.txtUsuarioUser.getText().equals("") 
                    || views.txtNombreUser.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                
            }else{
                us.setUsuario(views.txtUsuarioUser.getText());
                us.setNombre(views.txtNombreUser.getText());
                us.setCaja(views.cbxCajaUser.getSelectedItem().toString());
                us.setRol(views.cbxRolUser.getSelectedItem().toString());
                us.setId(Integer.parseInt(views.txtIdUser.getText()));
                if (usDao.modificar(us)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al modificar el usuario");
                }   
            }  
        }else if (e.getSource() == views.jMenuEliminarUser) {
            if (views.txtIdUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            }else{
                int id = Integer.parseInt(views.txtIdUser.getText());
                if (usDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                }
            }
            
        }else if (e.getSource() == views.jMenuReingresarUser) {
            if (views.txtIdUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            }else{
                int id = Integer.parseInt(views.txtIdUser.getText());
                if (usDao.accion("Activo", id)) {
                    limpiarTable();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al editar el usuario");
                }
            }
            
        }else{
            limpiar();
        }
    }
    public void listarUsuarios(){
        Tables color = new Tables();
        views.tableUser.setDefaultRenderer(views.tableUser.getColumnClass(0), color);
        List<Usuario> lista = usDao.ListaUsuario(views.txtBuscarUsers.getText());
        modelo =  (DefaultTableModel) views.tableUser.getModel();
        Object[] ob = new Object[6];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getUsuario();
            ob[2] = lista.get(i).getNombre();
            ob[3] = lista.get(i).getCaja();
            ob[4] = lista.get(i).getRol();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        views.tableUser.setModel(modelo);
        JTableHeader header = views.tableUser.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(13, 71, 161));
        header.setForeground(Color.white);
        
    }
    public void limpiarTable(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
            
        }   
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.tableUser) {
            int fila = views.tableUser.rowAtPoint(e.getPoint());
            views.txtIdUser.setText(views.tableUser.getValueAt(fila, 0).toString());
            views.txtUsuarioUser.setText(views.tableUser.getValueAt(fila, 1).toString());
            views.txtNombreUser.setText(views.tableUser.getValueAt(fila, 2).toString());
            views.cbxCajaUser.setSelectedItem(views.tableUser.getValueAt(fila, 3).toString());
            views.cbxRolUser.setSelectedItem(views.tableUser.getValueAt(fila, 4).toString());
            views.txtClaveUser.setEnabled(false);
            views.btnRegistrarUser.setEnabled(false);
        }else if (e.getSource() == views.JLabelUsers) {
            views.jTabbedpane1.setSelectedIndex(3);
            limpiarTable();
            listarUsuarios();
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarUsers) {
            
            limpiarTable();
            listarUsuarios();
            
            
        }
    }
    private void limpiar(){
        views.txtIdUser.setText("");
        views.txtUsuarioUser.setText("");
        views.txtNombreUser.setText("");
        views.txtClaveUser.setText("");
        
    }
    
}
