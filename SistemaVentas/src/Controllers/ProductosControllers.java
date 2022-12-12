
package Controllers;

import Models.Combo;
import Models.Productos;
import Models.ProductosDao;
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

public class ProductosControllers implements ActionListener, MouseListener,KeyListener{
    private Productos pro;
    private ProductosDao proDao;
    private Admin views;
    DefaultTableModel modelo = new DefaultTableModel();

    public ProductosControllers(Productos pro, ProductosDao proDao, Admin views) {
        this.pro = pro;
        this.proDao = proDao;
        this.views = views;
        this.views.btnRegistrarProd.addActionListener(this);
        this.views.btnModificarProd.addActionListener(this);
        this.views.btnNuevoProd.addActionListener(this);
        this.views.jMenuEliminarProd.addActionListener(this);
        this.views.jMenuReingresarProd.addActionListener(this);
        this.views.tableProd.addMouseListener(this);
        this.views.JLabelProductos.addMouseListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarProd) {
            if (views.txtCodigoProd.getText().equals("") 
                    || views.txtDescripcionProd.getText().equals("") 
                    || views.txtPrecioCompra.getText().equals("")
                    || views.txtPrecioVentaProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                
            }else{
                pro.setCodigo(views.txtCodigoProd.getText());
                pro.setDescripcion(views.txtDescripcionProd.getText());
                pro.setPrecio_compra(Double.parseDouble(views.txtPrecioCompra.getText()));
                pro.setPrecio_venta(Double.parseDouble(views.txtPrecioVentaProd.getText()));
                
                Combo itemP = (Combo) views.cbxProveedorProd.getSelectedItem();
                Combo itemC = (Combo) views.cbxCategoriaProd.getSelectedItem();
                Combo itemM = (Combo) views.cbxMedidaProd.getSelectedItem();
                pro.setId_proveedor(itemP.getId());
                pro.setId_categoria(itemC.getId());
                pro.setId_medida(itemM.getId());
                
                if (proDao.registrar(pro)) {
                      limpiarProductos();
                      listarProductos();
//                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar el producto");
                }
                
                
            }
            
        }else if (e.getSource() == views.btnModificarProd) {
            if (views.txtCodigoProd.getText().equals("") 
                    || views.txtDescripcionProd.getText().equals("") 
                    || views.txtPrecioCompra.getText().equals("")
                    || views.txtPrecioVentaProd.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                
            }else{
                pro.setCodigo(views.txtCodigoProd.getText());
                pro.setDescripcion(views.txtDescripcionProd.getText());
                pro.setPrecio_compra(Double.parseDouble(views.txtPrecioCompra.getText()));
                pro.setPrecio_venta(Double.parseDouble(views.txtPrecioVentaProd.getText()));
                Combo itemP = (Combo) views.cbxProveedorProd.getSelectedItem();
                Combo itemC = (Combo) views.cbxCategoriaProd.getSelectedItem();
                Combo itemM = (Combo) views.cbxMedidaProd.getSelectedItem();
                pro.setId_proveedor(itemP.getId());
                pro.setId_categoria(itemC.getId());
                pro.setId_medida(itemM.getId());
                pro.setId(Integer.parseInt(views.txtIdProd.getText()));
                if (proDao.modificar(pro)) {
                    limpiarProductos();
                    listarProductos();
//                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto modificado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al modificar el producto");
                }   
            }  
        }else if (e.getSource() == views.jMenuEliminarProd) {
            if (views.txtIdProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            }else{
                int id = Integer.parseInt(views.txtIdProd.getText());
                if (proDao.accion("Inactivo", id)) {
                      limpiarProductos();
                      listarProductos();
//                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto Eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
                }
            }
            
        }else if (e.getSource() == views.jMenuReingresarProd) {
            if (views.txtIdProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            }else{
                int id = Integer.parseInt(views.txtIdProd.getText());
                if (proDao.accion("Activo", id)) {
                    limpiarProductos();
                      listarProductos();
//                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto reingresado");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al editar el producto");
                }
            }
            
        }else{
//            limpiar();
        }
    }
    public void listarProductos(){
        Tables color = new Tables();
        views.tableProd.setDefaultRenderer(views.tableProd.getColumnClass(0), color);
        List<Productos> lista = proDao.ListaProductos(views.txtBuscarProducto.getText());
        modelo =  (DefaultTableModel) views.tableProd.getModel();
        Object[] ob = new Object[6];
        for (int i = 0 ; i<lista.size();i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getCodigo();
            ob[2] = lista.get(i).getDescripcion();
            ob[3] = lista.get(i).getPrecio_venta();
            ob[4] = lista.get(i).getCantidad();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        views.tableProd.setModel(modelo);
        JTableHeader header = views.tableProd.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(13, 71, 161));
        header.setForeground(Color.white);
        
    }
    public void limpiarProductos(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
            
        }   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if (e.getSource() == views.tableProd) {
                int fila = views.tableProd.rowAtPoint(e.getPoint());
                views.txtIdProd.setText(views.tableProd.getValueAt(fila, 0).toString());
                pro = proDao.BuscarPro(Integer.parseInt(views.txtIdProd.getText()));
                views.txtCodigoProd.setText(pro.getCodigo());
                views.txtDescripcionProd.setText(pro.getDescripcion());
                views.txtPrecioCompra.setText(""+pro.getPrecio_compra());
                views.txtPrecioVentaProd.setText(""+pro.getPrecio_venta());
                views.cbxProveedorProd.setSelectedItem(new Combo(pro.getId_proveedor(), pro.getProveedor()));
                views.cbxMedidaProd.setSelectedItem(new Combo(pro.getId_medida(), pro.getMedida()));
                views.cbxCategoriaProd.setSelectedItem(new Combo(pro.getId_categoria(), pro.getCategoria()));
            
        }else if (e.getSource() == views.JLabelProductos) {
            views.jTabbedpane1.setSelectedIndex(0);
            limpiarProductos();
            listarProductos();
            
            }
                
        }
//            views.btnRegistrarProd.setEnabled(false);
    

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
    }
    
}
