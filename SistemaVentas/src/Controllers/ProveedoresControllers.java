
package Controllers;

import Models.Combo;
import Models.Proveedores;
import Models.ProveedoresDao;
import Models.Tables;
import Views.Admin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ProveedoresControllers implements ActionListener,MouseListener,KeyListener{
    private Proveedores pv;
    private ProveedoresDao pvDao;
    private Admin views;
    DefaultTableModel modelo = new DefaultTableModel();

    public ProveedoresControllers(Proveedores pv, ProveedoresDao pvDao, Admin views) {
        this.pv = pv;
        this.pvDao = pvDao;
        this.views = views;
        this.views.btnRegistrarProv.addActionListener(this);
        this.views.btnModificarProv.addActionListener(this);
        this.views.btnNuevoProv.addActionListener(this);
        this.views.tableProv.addMouseListener(this);
        this.views.jMenuEliminarProv.addActionListener(this);
        this.views.jMenuReingresarProv.addActionListener(this);
        this.views.txtBuscarProv.addKeyListener(this);
        this.views.JLabelProveedor.addMouseListener(this);
        
        
        listarProveedores();
        llenarProveedor();
        AutoCompleteDecorator.decorate(views.cbxProveedorProd);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarProv) {
            if (views.txtNombreProv.getText().equals("") 
                    || views.txtTelefonoProv.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                pv.setNombre(views.txtNombreProv.getText());
                pv.setTelefono(views.txtTelefonoProv.getText());
                pv.setDireccion(views.txtDireccionProv.getText());
                if (pvDao.registrar(pv)) {
                    limpiarTable();
                    listarProveedores();
                    JOptionPane.showMessageDialog(null, "Proveedor registrado con exito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }
            }     
        }else if (e.getSource() == views.btnModificarProv) {
            if (views.txtIdProv.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila");
            }else{
                if (views.txtNombreProv.getText().equals("") 
                    || views.txtTelefonoProv.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    pv.setNombre(views.txtNombreProv.getText());
                    pv.setTelefono(views.txtTelefonoProv.getText());
                    pv.setDireccion(views.txtDireccionProv.getText());
                    pv.setId(Integer.parseInt(views.txtIdProv.getText()));
                    if (pvDao.modificar(pv)) {
                        limpiarTable();
                        listarProveedores();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Proveedor modificado con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar");
                    }
                }
            }
            
        }else if (e.getSource() == views.jMenuEliminarProv) {
            if (views.txtIdProv.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                int id = Integer.parseInt(views.txtIdProv.getText());
                if (pvDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
                }
            }
            
            
        }else if (e.getSource() == views.jMenuReingresarProv) {
            int id = Integer.parseInt(views.txtIdProv.getText());
            if (views.txtIdProv.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                if (pvDao.accion("Activo", id)) {
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Proveedor reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al reingresar el cliente");
                }
            }
            
            
        }else{
            limpiar();
        }
    }
    public void listarProveedores(){
        Tables color = new Tables();
        views.tableProv.setDefaultRenderer(views.tableProv.getColumnClass(0), color);
        List<Proveedores> lista = pvDao.ListaProveedores(views.txtBuscarProv.getText());
        modelo =  (DefaultTableModel) views.tableProv.getModel();
        Object[] ob = new Object[5];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getTelefono();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        views.tableProv.setModel(modelo);
        JTableHeader header = views.tableProv.getTableHeader();
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
         if (e.getSource() == views.tableProv) {
            int fila = views.tableProv.rowAtPoint(e.getPoint());
            views.txtIdProv.setText(views.tableProv.getValueAt(fila, 0).toString());
            views.txtNombreProv.setText(views.tableProv.getValueAt(fila, 1).toString());
            views.txtTelefonoProv.setText(views.tableProv.getValueAt(fila, 2).toString());
            views.txtDireccionProv.setText(views.tableProv.getValueAt(fila, 3).toString());
            views.btnRegistrarProv.setEnabled(false);
            
        }else if (e.getSource() == views.JLabelProveedor) {
            views.jTabbedpane1.setSelectedIndex(2);
            
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
    private void limpiar(){
        views.txtNombreProv.setText("");
        views.txtTelefonoProv.setText("");
        views.txtDireccionProv.setText("");
        views.txtIdProv.setText("");
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarProv) {
            limpiarTable();
            listarProveedores();
        }
    }
    private void llenarProveedor(){
        List<Proveedores> lista = pvDao.ListaProveedores(views.txtBuscarProv.getText());
        for (int i = 0 ; i<lista.size();i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            views.cbxProveedorProd.addItem(new Combo(id,nombre));
        }
    }
    
}
