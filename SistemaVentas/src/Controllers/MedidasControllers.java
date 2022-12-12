
package Controllers;
import Models.Combo;
import Models.Medidas;
import Models.MedidasDao;
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


public class MedidasControllers implements  ActionListener, MouseListener, KeyListener{
    private Medidas md;
    private MedidasDao mdDao;
    private Admin v;
    DefaultTableModel modelo = new DefaultTableModel();
    public MedidasControllers(Medidas md, MedidasDao mdDao, Admin v) {
        this.md = md;
        this.mdDao = mdDao;
        this.v = v;
        this.v.btnRegistrarMed.addActionListener(this);
        this.v.btnModificarMed.addActionListener(this);
        this.v.btnNuevoMed.addActionListener(this);
        this.v.tableMed.addMouseListener(this);
        this.v.jmEliminarMed.addActionListener(this);
        this.v.jmModificarMed.addActionListener(this);
        this.v.txtBuscarMed.addKeyListener(this);
        this.v.JLabelMedidas.addMouseListener(this);
        
        listarMedidas();
        llenarMedidas();
        AutoCompleteDecorator.decorate(v.cbxMedidaProd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.btnRegistrarMed) {
            if (v.txtNombreMed.getText().equals("") 
                    || v.txtNombreCortoMed.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }else{
                md.setNombre(v.txtNombreMed.getText());
                md.setNombre_corto(v.txtNombreCortoMed.getText());
                
                if(mdDao.registrar(md)){
                    limpiarTable();
                    listarMedidas();
                    JOptionPane.showMessageDialog(null, "Medida registrada con extito");
                
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar medida");
                }
            }
        }else if (e.getSource() == v.btnModificarMed) {
            if (v.txtIdMed.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else{
                if (v.txtNombreMed.getText().equals("") 
                    || v.txtNombreCortoMed.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    md.setNombre(v.txtNombreMed.getText());
                    md.setNombre_corto(v.txtNombreCortoMed.getText());
                    md.setId(Integer.parseInt(v.txtIdMed.getText()));
                    
                    if (mdDao.modificar(md)) {
                        limpiarTable();
                        listarMedidas();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Medida modificada con exito");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al modificar");
                    }
                }
            }
            
        }else if (e.getSource() == v.jmEliminarMed) {
            if (v.txtIdMed.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                int id = Integer.parseInt(v.txtIdMed.getText());
                if (mdDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarMedidas();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Medida Eliminada");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar la Medida");
                }
            }
            
            
        }else if (e.getSource() == v.jmModificarMed) {
            int id = Integer.parseInt(v.txtIdMed.getText());
            if (v.txtIdMed.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Selecciona una fila");

            }else{
                if (mdDao.accion("Activo", id)) {
                    limpiarTable();
                    listarMedidas();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Medida reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al reingresar la Medida");
                }
            }
            
            
        }else{
            limpiar();
        }
    }
    public void listarMedidas(){
        Tables color = new Tables();
        v.tableMed.setDefaultRenderer(v.tableMed.getColumnClass(0), color);
        List<Medidas> lista = mdDao.ListaMedidas(v.txtBuscarMed.getText());
        modelo =  (DefaultTableModel) v.tableMed.getModel();
        Object[] ob = new Object[4];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getNombre_corto();
            ob[3] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        v.tableMed.setModel(modelo);
        JTableHeader header = v.tableMed.getTableHeader();
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
        if (e.getSource() == v.tableMed) {
            int fila = v.tableMed.rowAtPoint(e.getPoint());
            v.txtIdMed.setText(v.tableMed.getValueAt(fila, 0).toString());
            v.txtNombreMed.setText(v.tableMed.getValueAt(fila, 1).toString());
            v.txtNombreCortoMed.setText(v.tableMed.getValueAt(fila, 2).toString());
            v.btnRegistrarMed.setEnabled(false);
            
            
        }else if (e.getSource() == v.JLabelMedidas) {
            v.jTabbedpane1.setSelectedIndex(5);
            
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
        v.txtNombreMed.setText("");
        v.txtNombreCortoMed.setText("");
        v.txtIdMed.setText("");
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == v.txtBuscarMed) {
            limpiarTable();
            listarMedidas();
        }
    }
    private void llenarMedidas(){
        List<Medidas> lista = mdDao.ListaMedidas(v.txtBuscarMed.getText());
        for (int i = 0 ; i<lista.size();i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            v.cbxMedidaProd.addItem(new Combo(id,nombre));
        }
    }
}