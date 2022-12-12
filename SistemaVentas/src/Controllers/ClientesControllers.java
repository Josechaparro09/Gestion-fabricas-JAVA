
package Controllers;

import Models.Clientes;
import Models.ClientesDao;
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

public class ClientesControllers implements ActionListener, MouseListener, KeyListener{
    private Clientes cl;
    private ClientesDao clDao;
    private Admin views;
    DefaultTableModel modelo = new DefaultTableModel();
    public ClientesControllers(Clientes cl, ClientesDao clDao, Admin views) {
        this.cl = cl;
        this.clDao = clDao;
        this.views = views;
        this.views.btnRegistrarClient.addActionListener(this);
        this.views.btnModificarClient.addActionListener(this);
        this.views.btnNuevoClient.addActionListener(this);
        this.views.tableClient.addMouseListener(this);
        this.views.jMenuEliminarClient.addActionListener(this);
        this.views.jMenuReingresarClient.addActionListener(this);
        this.views.txtBuscarClient.addKeyListener(this);
        this.views.JLabelClientes.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarClient) {
            if (views.txtNombreClient.getText().equals("") 
                    || views.txtTelefonoClient.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                cl.setNombre(views.txtNombreClient.getText());
                cl.setTelefono(views.txtTelefonoClient.getText());
                cl.setDireccion(views.txtDireccionClient.getText());
                if (clDao.registrar(cl)) {
                    limpiarTable();
                    listarClientes();
                    JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }
            }     
        }else if (e.getSource() == views.btnModificarClient) {
            if (views.txtIdClient.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila");
            }else{
                if (views.txtNombreClient.getText().equals("") 
                    || views.txtTelefonoClient.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    cl.setNombre(views.txtNombreClient.getText());
                    cl.setTelefono(views.txtTelefonoClient.getText());
                    cl.setDireccion(views.txtDireccionClient.getText());
                    cl.setId(Integer.parseInt(views.txtIdClient.getText()));
                    if (clDao.modificar(cl)) {
                        limpiarTable();
                        listarClientes();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Cliente modificado con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar");
                    }
                }
            }
            
        }else if (e.getSource() == views.jMenuEliminarClient) {
            if (views.txtIdClient.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                int id = Integer.parseInt(views.txtIdClient.getText());
                if (clDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarClientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Cliente Eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
                }
            }
            
            
        }else if (e.getSource() == views.jMenuReingresarClient) {
            int id = Integer.parseInt(views.txtIdClient.getText());
            if (views.txtIdClient.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                if (clDao.accion("Activo", id)) {
                    limpiarTable();
                    listarClientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Cliente reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al reingresar el cliente");
                }
            }
            
            
        }else{
            limpiar();
        }
    }
    public void listarClientes(){
        Tables color = new Tables();
        views.tableClient.setDefaultRenderer(views.tableClient.getColumnClass(0), color);
        List<Clientes> lista = clDao.ListaClientes(views.txtBuscarClient.getText());
        modelo =  (DefaultTableModel) views.tableClient.getModel();
        Object[] ob = new Object[5];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getTelefono();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        views.tableClient.setModel(modelo);
        JTableHeader header = views.tableClient.getTableHeader();
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
        if (e.getSource() == views.tableClient) {
            int fila = views.tableClient.rowAtPoint(e.getPoint());
            views.txtIdClient.setText(views.tableClient.getValueAt(fila, 0).toString());
            views.txtNombreClient.setText(views.tableClient.getValueAt(fila, 1).toString());
            views.txtTelefonoClient.setText(views.tableClient.getValueAt(fila, 2).toString());
            views.txtDireccionClient.setText(views.tableClient.getValueAt(fila, 3).toString());
            views.btnRegistrarClient.setEnabled(false);
        }else if (e.getSource() == views.JLabelClientes) {
            views.jTabbedpane1.setSelectedIndex(1);
            limpiarTable(); 
            listarClientes();
            
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
        views.txtNombreClient.setText("");
        views.txtTelefonoClient.setText("");
        views.txtDireccionClient.setText("");
        views.txtIdClient.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarClient) {
            limpiarTable();
            listarClientes();
        }
    }
}
