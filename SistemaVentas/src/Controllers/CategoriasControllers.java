
package Controllers;

import Models.Categorias;
import Models.CategoriasDao;
import Models.Combo;
import Models.Tables;
import Views.Admin;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CategoriasControllers implements ActionListener,MouseListener,KeyListener{
    
    private Categorias ct;
    private CategoriasDao ctDao;
    private Admin views;
    DefaultTableModel modelo = new DefaultTableModel();
    public CategoriasControllers(Categorias ct, CategoriasDao ctDao, Admin views) {
        this.ct = ct;
        this.ctDao = ctDao;
        this.views = views;
        this.views.btnRegistrarCag.addActionListener(this);
        this.views.btnModificarCag.addActionListener(this);
        this.views.btnNuevoCag.addActionListener(this);
        this.views.tableCag.addMouseListener(this);
        this.views.jMenuEliminarCag.addActionListener(this);
        this.views.jMenuReingresarCag.addActionListener(this);
        this.views.txtBuscarCag.addKeyListener(this);
        this.views.JLabelCategorias.addMouseListener(this);
        cbxCategoriaProd();
        AutoCompleteDecorator.decorate(views.cbxCategoriaProd);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarCag) {
            if (views.txtNombreCag.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                ct.setNombre(views.txtNombreCag.getText());
                if (ctDao.registrar(ct)) {
                    limpiarTable();
                    listarCategorias();
                    JOptionPane.showMessageDialog(null, "Categoria registrado con exito");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }
            }     
        }else if (e.getSource() == views.btnModificarCag) {
            if (views.txtIdCag.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila");
            }else{
                if (views.txtNombreCag.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    ct.setNombre(views.txtNombreCag.getText());
                    ct.setId(Integer.parseInt(views.txtIdCag.getText()));
                    if (ctDao.modificar(ct)) {
                        limpiarTable();
                        listarCategorias();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Categoria modificada con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar");
                    }
                }
            }
            
        }else if (e.getSource() == views.jMenuEliminarCag) {
            if (views.txtIdCag.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                int id = Integer.parseInt(views.txtIdCag.getText());
                if (ctDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarCategorias();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Categoria Eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el categoria");
                }
            }
            
            
        }else if (e.getSource() == views.jMenuReingresarCag) {
            int id = Integer.parseInt(views.txtIdCag.getText());
            if (views.txtIdCag.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                if (ctDao.accion("Activo", id)) {
                    limpiarTable();
                    listarCategorias();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Categoria reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al reingresar el categoria");
                }
            }
            
            
        }else{
            limpiar();
        }
    }
    public void listarCategorias(){
        Tables color = new Tables();
        views.tableCag.setDefaultRenderer(views.tableCag.getColumnClass(0), color);
        List<Categorias> lista = ctDao.ListaCategorias(views.txtBuscarCag.getText());
        modelo =  (DefaultTableModel) views.tableCag.getModel();
        Object[] ob = new Object[3];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        views.tableCag.setModel(modelo);
        JTableHeader header = views.tableCag.getTableHeader();
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
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getSource() == views.tableCag) {
            int fila = views.tableCag.rowAtPoint(e.getPoint());
            views.txtIdCag.setText(views.tableCag.getValueAt(fila, 0).toString());
            views.txtNombreCag.setText(views.tableCag.getValueAt(fila, 1).toString());
            views.btnRegistrarCag.setEnabled(false);
        }else if (e.getSource() == views.JLabelCategorias) {
            views.jTabbedpane1.setSelectedIndex(4);
            limpiarTable();
            listarCategorias();
            
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    private void limpiar(){
        views.txtNombreCag.setText("");
        views.txtIdCag.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCag) {
            limpiarTable();
            listarCategorias();
        }
    }
    private void cbxCategoriaProd(){
        List<Categorias> lista = ctDao.ListaCategorias(views.txtBuscarProv.getText());
        for (int i = 0 ; i<lista.size();i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            views.cbxCategoriaProd.addItem(new Combo(id,nombre));
        }
    }
    
    
}
