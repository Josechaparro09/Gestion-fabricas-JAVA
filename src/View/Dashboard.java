/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Modelo.*;
import DB.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josec
 */
public class Dashboard extends javax.swing.JFrame {

    
    Empleado emp = new Empleado();
    EmpleadosDAO empDao = new EmpleadosDAO();
    Medida me = new Medida();
    MedidasDAO meDao = new MedidasDAO();
    Categoria cag = new Categoria();
    CategoriasDAO cagDao = new CategoriasDAO();
    Producto prod = new Producto();
    ProductosDao prodDao = new ProductosDao();
    DefaultTableModel modelo = new DefaultTableModel();
    
    int modificar ;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
    }
    //Campos editables
    public void empleadoEditable(boolean ed){
        txtccEmp.setEditable(ed);
        txtpNombreEmp.setEditable(ed);
        txtsNombreEmp.setEditable(ed);
        txtpApellidoEmp.setEditable(ed);
        txtsApellidoEmp.setEditable(ed);
        txtTelefonoEmp.setEditable(ed);
        txtccEmp.setFocusable(ed);
        txtpNombreEmp.setFocusable(ed);
        txtsNombreEmp.setFocusable(ed);
        txtTelefonoEmp.setFocusable(ed);
        txtpApellidoEmp.setFocusable(ed);
        txtsApellidoEmp.setFocusable(ed);
    }
    public void cagEditable(boolean ed){
        txtidCag.setEditable(ed);
        txtNombreMed.setEditable(ed);
        txtNombreCag.setEditable(ed);
        txtidCag.setFocusable(ed);
        txtNombreCag.setFocusable(ed);
    }
    public void medidaEditable(boolean ed){
        txtidMed.setEditable(ed);
        txtNombreMed.setEditable(ed);
        txtNombreCortoMed.setEditable(ed);
        txtidMed.setFocusable(ed);
        txtNombreMed.setFocusable(ed);
        txtNombreCortoMed.setFocusable(ed);
        
    }
    public void prodEditable(boolean ed){
        txtIdProd.setEditable(ed);
        txtNombreProd.setEditable(ed);
        txtPrecioProduccProd.setEditable(ed);
        txtPrecioVentaProd.setEditable(ed);
        cbxCategoriaProd.setEditable(ed);
        cbxMedidaProd.setEditable(ed);
        
        txtIdProd.setFocusable(ed);
        txtNombreProd.setFocusable(ed);
        txtPrecioProduccProd.setFocusable(ed);
        txtPrecioVentaProd.setFocusable(ed);
        cbxCategoriaProd.setFocusable(ed);
        cbxMedidaProd.setFocusable(ed);
    }
    
    //limpiar txtfields
    public void limpiarempleado(){
        txtccEmp.setText("");
        txtpNombreEmp.setText("");
        txtsNombreEmp.setText("");
        txtTelefonoEmp.setText("");
        txtpApellidoEmp.setText("");
        txtsApellidoEmp.setText("");
    }
    public void limpiarCag(){
        txtidCag.setText("");
        txtNombreCag.setText("");
    }
    public void limpiarmedida(){
        txtidMed.setText("");
        txtNombreMed.setText("");
        txtNombreCortoMed.setText("");
    }
    public void limpiarProd(){
        txtIdProd.setText("");
        txtNombreProd.setText("");
        txtPrecioProduccProd.setText("");
        txtPrecioVentaProd.setText("");
        cbxCategoriaProd.setSelectedItem("");
        cbxMedidaProd.setSelectedItem("");
    }
    
    public void listaComboCagProd(){
        DefaultComboBoxModel<String> modCombo = new DefaultComboBoxModel<>();
        ArrayList<Categoria> listaCag = cagDao.listaCategorias();
        for (Categoria cag : listaCag) {
           modCombo.addElement(cag.getNombre());  
        }
        cbxCategoriaProd.setModel((ComboBoxModel) modCombo);
    }
    public void listaComboMedProd(){
        DefaultComboBoxModel<String> modCombo = new DefaultComboBoxModel<>();
        ArrayList<Medida> listaMed = meDao.listaMedidas();
        for (Medida med : listaMed) {
           modCombo.addElement(med.getNombre());  
        }
        cbxMedidaProd.setModel((ComboBoxModel) modCombo);
    }
    //Validar vacio
    public boolean validarEmp(){
        if (!"".equals(txtccEmp.getText()) || !"".equals(txtpNombreEmp.getText()) || !"".equals(txtsNombreEmp.getText()) || !"".equals(txtTelefonoEmp.getText())) {
            return true;
        }else{
            return false;
        }
    }
    public boolean validarCag(){
        if (!"".equals(txtidCag.getText()) || !"".equals(txtNombreCag.getText())) {
            return true;
        }else{
            return false;
        }
    }
    public boolean validarMedida(){
        if (!"".equals(txtidMed.getText()) || !"".equals(txtNombreMed.getText()) || !"".equals(txtNombreCortoMed.getText())) {
            return true;
        }else{
            return false;
        }
    }
    public boolean validarProd(){
        if (!"".equals(txtIdProd.getText()) || !"".equals(txtNombreProd.getText()) || !"".equals(txtPrecioProduccProd.getText())|| !"".equals(txtPrecioVentaProd.getText())) {
            return true;
        }else{
            return false;
        }
    }
    
    
    //Limpiar tablas
    public void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
        }
    }
    public void listarEmpleados() throws SQLException{
        ArrayList<Empleado> listaEmp = empDao.listarEmpleados();
        modelo = (DefaultTableModel) tableEmp.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < listaEmp.size(); i++) {
            
            ob[0] = listaEmp.get(i).getCedula();
            ob[1] = listaEmp.get(i).getP_nombre()+" "+listaEmp.get(i).getS_nombre();
            ob[2] = listaEmp.get(i).getP_apellido()+" "+listaEmp.get(i).getS_apellido();
            ob[3] = listaEmp.get(i).getTelefono();
            modelo.addRow(ob);
        }
        tableEmp.setModel(modelo);
    }
    public void listarMedidas() throws SQLException{
        ArrayList<Medida> listaMedidas = meDao.listarMedidas();
        modelo = (DefaultTableModel) tableMed.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < listaMedidas.size(); i++) {
            
            ob[0] = listaMedidas.get(i).getIdMedida();
            ob[1] = listaMedidas.get(i).getNombre();
            ob[2] = listaMedidas.get(i).getnCorto();
            modelo.addRow(ob);
        }
        tableMed.setModel(modelo);
    }
    public void listarCag() throws SQLException{
        ArrayList<Categoria> listaCag = cagDao.listarCag();
        modelo = (DefaultTableModel) tableCag.getModel();
        Object[] ob = new Object[2];
        for (int i = 0; i < listaCag.size(); i++) {
            ob[0] = listaCag.get(i).getId();
            ob[1] = listaCag.get(i).getNombre();
            modelo.addRow(ob);
        }
        tableCag.setModel(modelo);
    }
    public void listarProd() throws SQLException{
        ArrayList<Producto> listaProductos = prodDao.listarProd();
        modelo = (DefaultTableModel) tableProd.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < listaProductos.size(); i++) {
            
            ob[0] = listaProductos.get(i).getIdProducto();
            ob[1] = listaProductos.get(i).getNombreProd();
            ob[2] = listaProductos.get(i).getCostoProduccion();
            ob[3] = listaProductos.get(i).getPrecioVenta();
            ob[4] = cagDao.buscarnombreCag(listaProductos.get(i).getCagProducto());
            ob[5] = meDao.buscarnombreMed(listaProductos.get(i).getMedidaProd());
            
            modelo.addRow(ob);
        }
        tableProd.setModel(modelo);
    }
  
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuEmp = new javax.swing.JPopupMenu();
        menuEliminar = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenuItem();
        menuMed = new javax.swing.JPopupMenu();
        menuEliminarMed = new javax.swing.JMenuItem();
        menuEditarMed = new javax.swing.JMenuItem();
        menuCag = new javax.swing.JPopupMenu();
        eliminarCag = new javax.swing.JMenuItem();
        editarCag = new javax.swing.JMenuItem();
        menuProd = new javax.swing.JPopupMenu();
        eliminarProd = new javax.swing.JMenuItem();
        editarProd = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        JPanelEmpleados = new javax.swing.JPanel();
        jLabelEmpleados = new javax.swing.JLabel();
        JPanelProductos = new javax.swing.JPanel();
        jLabelProductos = new javax.swing.JLabel();
        JPanelMedidas = new javax.swing.JPanel();
        jLabelMedidas = new javax.swing.JLabel();
        JPanelCategorias = new javax.swing.JPanel();
        jLabelCategorias = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        paneles = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdProd = new javax.swing.JTextField();
        txtNombreProd = new javax.swing.JTextField();
        txtPrecioProduccProd = new javax.swing.JTextField();
        txtPrecioVentaProd = new javax.swing.JTextField();
        cbxMedidaProd = new javax.swing.JComboBox<>();
        cbxCategoriaProd = new javax.swing.JComboBox<>();
        btnNuevoProd = new javax.swing.JButton();
        btnRegistrarProd = new javax.swing.JButton();
        btnModificarProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProd = new javax.swing.JTable();
        PajinadorProd = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpNombreEmp = new javax.swing.JTextField();
        txtccEmp = new javax.swing.JTextField();
        btnNuevoEmp = new javax.swing.JButton();
        btnModificarEmp = new javax.swing.JButton();
        btnRegistrarEmp = new javax.swing.JButton();
        txtsNombreEmp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefonoEmp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtsApellidoEmp = new javax.swing.JTextField();
        txtpApellidoEmp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        PajinadorClient = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnNuevoCag = new javax.swing.JButton();
        btnRegistrarCag = new javax.swing.JButton();
        btnModificarCag = new javax.swing.JButton();
        txtidCag = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNombreCag = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableCag = new javax.swing.JTable();
        PajinadorCag = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMed = new javax.swing.JTable();
        PajinadorMed = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtNombreMed = new javax.swing.JTextField();
        btnNuevoMed = new javax.swing.JButton();
        btnRegistrarMed = new javax.swing.JButton();
        btnModificarMed = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtNombreCortoMed = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtidMed = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        menuEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        menuEliminar.setText("Eliminar");
        menuEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEliminarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuEliminarMousePressed(evt);
            }
        });
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        menuEmp.add(menuEliminar);

        menuEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Editar.png"))); // NOI18N
        menuEditar.setText("Editar");
        menuEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuEditarMousePressed(evt);
            }
        });
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        menuEmp.add(menuEditar);

        menuMed.setInvoker(tableMed);

        menuEliminarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        menuEliminarMed.setText("Eliminar");
        menuEliminarMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuEliminarMedMousePressed(evt);
            }
        });
        menuMed.add(menuEliminarMed);

        menuEditarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Editar.png"))); // NOI18N
        menuEditarMed.setText("Editar");
        menuEditarMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuEditarMedMousePressed(evt);
            }
        });
        menuEditarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarMedActionPerformed(evt);
            }
        });
        menuMed.add(menuEditarMed);

        eliminarCag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        eliminarCag.setText("Eliminar");
        eliminarCag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarCagMousePressed(evt);
            }
        });
        eliminarCag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCagActionPerformed(evt);
            }
        });
        menuCag.add(eliminarCag);

        editarCag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Editar.png"))); // NOI18N
        editarCag.setText("Editar");
        editarCag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarCagMousePressed(evt);
            }
        });
        menuCag.add(editarCag);

        eliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        eliminarProd.setText("Eliminar");
        eliminarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarProdMousePressed(evt);
            }
        });
        menuProd.add(eliminarProd);

        editarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Editar.png"))); // NOI18N
        editarProd.setText("Editar");
        editarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarProdMousePressed(evt);
            }
        });
        editarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProdActionPerformed(evt);
            }
        });
        menuProd.add(editarProd);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(18, 90, 173));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanelEmpleados.setBackground(new java.awt.Color(18, 90, 173));

        jLabelEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmpleados.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmpleados.setText("Empleados");
        jLabelEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEmpleadosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelEmpleadosLayout = new javax.swing.GroupLayout(JPanelEmpleados);
        JPanelEmpleados.setLayout(JPanelEmpleadosLayout);
        JPanelEmpleadosLayout.setHorizontalGroup(
            JPanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelEmpleadosLayout.createSequentialGroup()
                .addComponent(jLabelEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPanelEmpleadosLayout.setVerticalGroup(
            JPanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 244, 55));

        JPanelProductos.setBackground(new java.awt.Color(18, 90, 173));

        jLabelProductos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductos.setText("Productos");
        jLabelProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelProductosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelProductosLayout = new javax.swing.GroupLayout(JPanelProductos);
        JPanelProductos.setLayout(JPanelProductosLayout);
        JPanelProductosLayout.setHorizontalGroup(
            JPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelProductosLayout.setVerticalGroup(
            JPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 244, 55));

        JPanelMedidas.setBackground(new java.awt.Color(18, 90, 173));

        jLabelMedidas.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMedidas.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelMedidas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMedidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedidas.setText("Medidas");
        jLabelMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMedidasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMedidasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMedidasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelMedidasLayout = new javax.swing.GroupLayout(JPanelMedidas);
        JPanelMedidas.setLayout(JPanelMedidasLayout);
        JPanelMedidasLayout.setHorizontalGroup(
            JPanelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelMedidasLayout.setVerticalGroup(
            JPanelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 244, 55));

        JPanelCategorias.setBackground(new java.awt.Color(18, 90, 173));

        jLabelCategorias.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCategorias.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelCategorias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategorias.setText("Categorias");
        jLabelCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCategoriasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCategoriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCategoriasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelCategoriasLayout = new javax.swing.GroupLayout(JPanelCategorias);
        JPanelCategorias.setLayout(JPanelCategoriasLayout);
        JPanelCategoriasLayout.setHorizontalGroup(
            JPanelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelCategoriasLayout.setVerticalGroup(
            JPanelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 244, 55));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 244, 980));

        jPanel2.setBackground(new java.awt.Color(13, 71, 161));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 60));

        paneles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nuevo Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Id");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Precio Produccion");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Precio Venta");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Medida");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Categoria");

        txtIdProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdActionPerformed(evt);
            }
        });

        cbxMedidaProd.setEditable(true);

        cbxCategoriaProd.setEditable(true);

        btnNuevoProd.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoProd.setText("Nuevo");
        btnNuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProdActionPerformed(evt);
            }
        });

        btnRegistrarProd.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarProd.setText("Registrar");
        btnRegistrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProdActionPerformed(evt);
            }
        });

        btnModificarProd.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarProd.setText("Modificar");
        btnModificarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificarProdMousePressed(evt);
            }
        });
        btnModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNombreProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addComponent(txtIdProd, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPrecioProduccProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(txtPrecioVentaProd, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxMedidaProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxCategoriaProd, 0, 137, Short.MAX_VALUE)))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnRegistrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnModificarProd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevoProd)
                        .addGap(98, 98, 98)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecioProduccProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioVentaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxCategoriaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxMedidaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnNuevoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 460));

        tableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio Produccion", "Precio venta", "Categoria", "Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProd.setComponentPopupMenu(menuProd);
        tableProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProd);
        if (tableProd.getColumnModel().getColumnCount() > 0) {
            tableProd.getColumnModel().getColumn(0).setResizable(false);
            tableProd.getColumnModel().getColumn(1).setResizable(false);
            tableProd.getColumnModel().getColumn(2).setResizable(false);
            tableProd.getColumnModel().getColumn(3).setResizable(false);
            tableProd.getColumnModel().getColumn(4).setResizable(false);
            tableProd.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 760, 360));

        javax.swing.GroupLayout PajinadorProdLayout = new javax.swing.GroupLayout(PajinadorProd);
        PajinadorProd.setLayout(PajinadorProdLayout);
        PajinadorProdLayout.setHorizontalGroup(
            PajinadorProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorProdLayout.setVerticalGroup(
            PajinadorProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel4.add(PajinadorProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 770, 90));

        paneles.addTab("Producto", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nuevo Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
        jPanel17.setToolTipText("");
        jPanel17.setName(""); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setText("Primer nombre");
        jPanel17.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 108, 123, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Telefono");
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 448, -1, -1));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setText("Cedula");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 44, -1, -1));

        txtpNombreEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpNombreEmpActionPerformed(evt);
            }
        });
        jPanel17.add(txtpNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 142, 236, 30));
        jPanel17.add(txtccEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 72, 236, 30));

        btnNuevoEmp.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoEmp.setText("Nuevo");
        btnNuevoEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoEmpMouseClicked(evt);
            }
        });
        btnNuevoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpActionPerformed(evt);
            }
        });
        jPanel17.add(btnNuevoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, -1, 30));

        btnModificarEmp.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarEmp.setText("Modificar");
        btnModificarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpActionPerformed(evt);
            }
        });
        jPanel17.add(btnModificarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, 30));

        btnRegistrarEmp.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarEmp.setText("Registrar");
        btnRegistrarEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarEmpMouseClicked(evt);
            }
        });
        btnRegistrarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpActionPerformed(evt);
            }
        });
        jPanel17.add(btnRegistrarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 87, 30));

        txtsNombreEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsNombreEmpActionPerformed(evt);
            }
        });
        jPanel17.add(txtsNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 224, 236, 30));

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel12.setText("Segundo nombre");
        jPanel17.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 190, -1, -1));
        jPanel17.add(txtTelefonoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 483, 236, 30));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel13.setText("Primer apellido");
        jPanel17.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 272, -1, -1));

        txtsApellidoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsApellidoEmpActionPerformed(evt);
            }
        });
        jPanel17.add(txtsApellidoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 400, 236, 30));

        txtpApellidoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpApellidoEmpActionPerformed(evt);
            }
        });
        jPanel17.add(txtpApellidoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 312, 236, 30));

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel14.setText("Segundo apellido");
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 360, 158, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 300, 50));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 610));
        jPanel17.getAccessibleContext().setAccessibleName("Nuevo empleado");

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Telefono"
            }
        ));
        tableEmp.setComponentPopupMenu(menuEmp);
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableEmp);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 770, 360));

        javax.swing.GroupLayout PajinadorClientLayout = new javax.swing.GroupLayout(PajinadorClient);
        PajinadorClient.setLayout(PajinadorClientLayout);
        PajinadorClientLayout.setHorizontalGroup(
            PajinadorClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorClientLayout.setVerticalGroup(
            PajinadorClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel5.add(PajinadorClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 770, 90));

        paneles.addTab("Empleado", jPanel5);

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nueva Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel27.setText("Id");

        btnNuevoCag.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoCag.setText("Nuevo");
        btnNuevoCag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoCagMouseClicked(evt);
            }
        });

        btnRegistrarCag.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarCag.setText("Registrar");
        btnRegistrarCag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCagActionPerformed(evt);
            }
        });

        btnModificarCag.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarCag.setText("Modificar");
        btnModificarCag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCagActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel31.setText("Nombre");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(btnRegistrarCag, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnModificarCag))
                            .addComponent(txtidCag, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel31)
                            .addComponent(txtNombreCag, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnNuevoCag)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidCag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(txtNombreCag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnNuevoCag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 290, -1));

        tableCag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        tableCag.setComponentPopupMenu(menuCag);
        tableCag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCagMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableCag);

        jPanel8.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 19, 770, 360));

        javax.swing.GroupLayout PajinadorCagLayout = new javax.swing.GroupLayout(PajinadorCag);
        PajinadorCag.setLayout(PajinadorCagLayout);
        PajinadorCagLayout.setHorizontalGroup(
            PajinadorCagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorCagLayout.setVerticalGroup(
            PajinadorCagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel8.add(PajinadorCag, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 389, -1, -1));

        paneles.addTab("Categoria", jPanel8);

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Nombre corto"
            }
        ));
        tableMed.setComponentPopupMenu(menuMed);
        tableMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMedMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableMed);

        jPanel9.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 19, 770, 360));

        javax.swing.GroupLayout PajinadorMedLayout = new javax.swing.GroupLayout(PajinadorMed);
        PajinadorMed.setLayout(PajinadorMedLayout);
        PajinadorMedLayout.setHorizontalGroup(
            PajinadorMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorMedLayout.setVerticalGroup(
            PajinadorMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel9.add(PajinadorMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 389, -1, -1));

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nueva Medida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel28.setText("Nombre");

        btnNuevoMed.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoMed.setText("Nuevo");
        btnNuevoMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMedMouseClicked(evt);
            }
        });
        btnNuevoMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedActionPerformed(evt);
            }
        });

        btnRegistrarMed.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarMed.setText("Registrar");
        btnRegistrarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMedActionPerformed(evt);
            }
        });

        btnModificarMed.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarMed.setText("Modificar");
        btnModificarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMedActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel29.setText("Nombre Corto");

        jLabel30.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel30.setText("id");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel29)
                                    .addComponent(txtNombreCortoMed, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(txtNombreMed)
                                    .addComponent(jLabel28)
                                    .addComponent(txtidMed)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel30))))))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRegistrarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoMed)
                            .addComponent(btnModificarMed))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreCortoMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnNuevoMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 290, -1));

        paneles.addTab("Medida", jPanel9);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins", 1, 100)); // NOI18N
        jLabel1.setText("Bienvenido ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(238, 238, 238))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel1)
                .addContainerGap(499, Short.MAX_VALUE))
        );

        paneles.addTab("tab5", jPanel3);

        paneles.setSelectedIndex(4);

        getContentPane().add(paneles, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 1120, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpleadosMouseEntered
        JPanelEmpleados.setBackground(new Color(13,71,161));
                   // TODO add your handling code here:
    }//GEN-LAST:event_jLabelEmpleadosMouseEntered

    private void jLabelEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpleadosMouseExited
       JPanelEmpleados.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelEmpleadosMouseExited

    private void jLabelProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProductosMouseEntered
        JPanelProductos.setBackground(new Color(13,71,161));     // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProductosMouseEntered

    private void jLabelProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProductosMouseExited
        JPanelProductos.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelProductosMouseExited

    private void jLabelMedidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMedidasMouseEntered
        JPanelMedidas.setBackground(new Color(13,71,161));     // TODO add your handling code here:
    }//GEN-LAST:event_jLabelMedidasMouseEntered

    private void jLabelMedidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMedidasMouseExited
        JPanelMedidas.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelMedidasMouseExited

    private void jLabelCategoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoriasMouseEntered
        JPanelCategorias.setBackground(new Color(13,71,161));     // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCategoriasMouseEntered

    private void jLabelCategoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoriasMouseExited
        JPanelCategorias.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCategoriasMouseExited

    private void jLabelProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProductosMouseClicked
        limpiarTabla();
        try {
            listarProd();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(0);
        listaComboCagProd();
        listaComboMedProd();
    }//GEN-LAST:event_jLabelProductosMouseClicked

    private void jLabelEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpleadosMouseClicked
        limpiarTabla();
        try {
            listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(1);
    }//GEN-LAST:event_jLabelEmpleadosMouseClicked

    private void menuEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEliminarMouseClicked
        
        
    }//GEN-LAST:event_menuEliminarMouseClicked

    private void menuEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEliminarMousePressed
        int fila = tableEmp.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "Seguro que de desea eliminar al empleado con la cedula : " + txtccEmp.getText(), "Eliminar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
                eliminado=empDao.eliminarEmpleado(tableEmp.getValueAt(fila, 0).toString());
                limpiarempleado();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado");
            }
           
           
            try {
                limpiarTabla();
                listarEmpleados();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuEliminarMousePressed

    private void menuEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEditarMousePressed
                
        empleadoEditable(true);
        txtccEmp.setEditable(false);
        btnRegistrarEmp.setVisible(false);
        btnModificarEmp.setVisible(true);
        modificar = tableEmp.rowAtPoint(evt.getPoint()); 
        
        
    }//GEN-LAST:event_menuEditarMousePressed

    private void jLabelMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMedidasMouseClicked
        limpiarTabla();
        try {
            listarMedidas();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(3);
    }//GEN-LAST:event_jLabelMedidasMouseClicked

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEditarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEliminarActionPerformed
    //Eliminar 
    private void menuEliminarMedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEliminarMedMousePressed
        int fila = tableMed.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea eliminar la medida?", "Eliminar medida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
                eliminado=meDao.eliminarMedida(tableMed.getValueAt(fila, 0).toString());
                limpiarmedida();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Medida eliminada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la medida");
            }
           
           
            try {
                limpiarTabla();
                listarMedidas();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuEliminarMedMousePressed
    
    private void menuEditarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEditarMedActionPerformed
    //modificar medida
    private void menuEditarMedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEditarMedMousePressed
        medidaEditable(true);
        txtidMed.setEditable(false);
        btnRegistrarMed.setVisible(false);
        btnModificarMed.setVisible(true);
        modificar = tableMed.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_menuEditarMedMousePressed

      //categorias activador
    private void jLabelCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoriasMouseClicked
        limpiarTabla();
        try {
            listarCag();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(2);
    }//GEN-LAST:event_jLabelCategoriasMouseClicked

    private void eliminarCagMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarCagMousePressed
        int fila = tableCag.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea eliminar la categoria?", "Eliminar categoria", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
                eliminado=cagDao.eliminarCag(tableCag.getValueAt(fila, 0).toString());
                limpiarCag();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Categoria eliminada con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la categoria");
            }
           
           
            try {
                limpiarTabla();
                listarCag();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_eliminarCagMousePressed

    private void editarCagMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCagMousePressed
        cagEditable(true);
        txtidCag.setEditable(false);
        btnRegistrarCag.setVisible(false);
        btnModificarCag.setVisible(true);
        modificar = tableCag.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_editarCagMousePressed
    
    private void eliminarProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarProdMousePressed
        int fila = tableProd.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea eliminar el producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
                System.out.println(tableProd.getValueAt(fila, 0).toString());
                eliminado=prodDao.eliminarProd(tableProd.getValueAt(fila, 0).toString());
                limpiarProd();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
            }
           
           
            try {
                limpiarTabla();
                listarProd();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_eliminarProdMousePressed
    
    int indicecag = 0;
    int indicemed = 0;
    
    
    private void editarProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarProdMousePressed
        prodEditable(true);
        txtIdProd.setEditable(false);
        btnRegistrarProd.setVisible(false);
        btnModificarProd.setVisible(true);
        modificar = tableProd.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_editarProdMousePressed

    private void tableCagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCagMouseClicked
        int fila = tableCag.rowAtPoint(evt.getPoint());

        txtidCag.setText(tableCag.getValueAt(fila, 0).toString());
        txtNombreCag.setText(tableCag.getValueAt(fila, 1).toString());
        cagEditable(false);
    }//GEN-LAST:event_tableCagMouseClicked

    private void btnModificarCagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCagActionPerformed
        if (validarCag()) {
            boolean modificado = false;
            cag.setId(txtidCag.getText());
            cag.setNombre(txtNombreCag.getText());

            int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea modificar la categoria? ", "Modificar categoria", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                modificado=cagDao.ModificarCag(cag);
                if (modificado) {
                    JOptionPane.showMessageDialog(null, "Categoria modificado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la categoria");
                }

                try {
                    limpiarTabla();
                    listarCag();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarCagActionPerformed

    private void btnRegistrarCagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCagActionPerformed
        if (validarCag()) {
            cag.setId(txtidCag.getText());
            cag.setNombre(txtNombreCag.getText());

            boolean registrado = false;
            try {
                registrado = cagDao.RegistrarCag(cag);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Categoria registrada");
            }
            limpiarTabla();
            try {
                listarCag();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnRegistrarCagActionPerformed

    private void btnNuevoCagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCagMouseClicked
        cagEditable(true);
        btnRegistrarCag.setVisible(true);
        btnModificarCag.setVisible(false);
        limpiarCag();
    }//GEN-LAST:event_btnNuevoCagMouseClicked

    private void tableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMouseClicked

        int fila = tableEmp.rowAtPoint(evt.getPoint());

        String nombres = tableEmp.getValueAt(fila, 1).toString();
        String apellidos = tableEmp.getValueAt(fila, 2).toString();
        //pasando datos de la tabla a txtfields
        txtccEmp.setText(tableEmp.getValueAt(fila, 0).toString());
        txtpNombreEmp.setText(nombres.substring(0,nombres.indexOf(" ")));
        txtsNombreEmp.setText(nombres.substring(nombres.indexOf(" ")+1,nombres.length()));
        txtpApellidoEmp.setText(apellidos.substring(0,apellidos.indexOf(" ")));
        txtsApellidoEmp.setText(apellidos.substring(apellidos.indexOf(" ")+1,apellidos.length()));
        txtTelefonoEmp.setText(tableEmp.getValueAt(fila, 3).toString());
        empleadoEditable(false);
    }//GEN-LAST:event_tableEmpMouseClicked

    private void txtpApellidoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpApellidoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpApellidoEmpActionPerformed

    private void txtsApellidoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsApellidoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsApellidoEmpActionPerformed

    private void txtsNombreEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsNombreEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsNombreEmpActionPerformed

    private void btnRegistrarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpActionPerformed
        if (validarEmp()) {

            emp.setCedula(txtccEmp.getText());
            emp.setP_nombre(txtpNombreEmp.getText());
            emp.setS_nombre(txtsNombreEmp.getText());
            emp.setP_apellido(txtpApellidoEmp.getText());
            emp.setS_apellido(txtsApellidoEmp.getText());
            emp.setTelefono(txtTelefonoEmp.getText());
            boolean registrado = false;
            try {
                registrado = empDao.RegistrarEmpleado(emp);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Empleado registrado");
            }
            limpiarTabla();
            try {
                listarEmpleados();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarEmpActionPerformed

    private void btnRegistrarEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEmpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarEmpMouseClicked

    //boton modificar empleado
    private void btnModificarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpActionPerformed

        if (validarEmp()) {
            boolean modificado = false;
            emp.setCedula(txtccEmp.getText());
            emp.setP_nombre(txtpNombreEmp.getText());
            emp.setS_nombre(txtsNombreEmp.getText());
            emp.setP_apellido(txtpApellidoEmp.getText());
            emp.setS_apellido(txtsApellidoEmp.getText());
            emp.setTelefono(txtTelefonoEmp.getText());
            int opt = JOptionPane.showConfirmDialog(null, "Seguro que de desea modificar al empleado con la cedula : " + emp.getCedula(), "modificar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                modificado=empDao.ModificarEmpleado(emp);
                System.out.println("Hola");
                System.out.println(emp.getCedula());
                if (modificado) {
                    JOptionPane.showMessageDialog(null, "Empleado modificado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el empleado");
                }

                try {
                    limpiarTabla();
                    listarEmpleados();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarEmpActionPerformed

    private void btnNuevoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoEmpActionPerformed

    private void btnNuevoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEmpMouseClicked
        // TODO add your handling code here:
        empleadoEditable(true);
        btnRegistrarEmp.setVisible(true);
        btnModificarEmp.setVisible(false);
        limpiarempleado();
    }//GEN-LAST:event_btnNuevoEmpMouseClicked

    private void txtpNombreEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpNombreEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpNombreEmpActionPerformed

    private void tableProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdMouseClicked
        int fila = tableProd.rowAtPoint(evt.getPoint());

        ArrayList<Categoria> listaCag = cagDao.listaCategorias();
        ArrayList<Medida> listaMed = meDao.listaMedidas();

        //pasando datos de la tabla a txtfields
        txtIdProd.setText(tableProd.getValueAt(fila, 0).toString());
        txtNombreProd.setText(tableProd.getValueAt(fila, 1).toString());
        txtPrecioProduccProd.setText(tableProd.getValueAt(fila, 2).toString());
        txtPrecioVentaProd.setText(tableProd.getValueAt(fila, 3).toString());

        for (int i = 0; i < listaCag.size(); i++) {
            if(tableProd.getValueAt(fila, 4).toString()==listaCag.get(i).getNombre()){
                indicecag = i;
            }
        }
        cbxCategoriaProd.setSelectedIndex(indicecag);
        for (int i = 0; i < listaMed.size(); i++) {
            if(tableProd.getValueAt(fila, 5).toString()==listaMed.get(i).getNombre()){
                indicemed = i;
            }
        }
        cbxMedidaProd.setSelectedIndex(indicemed);

        prodEditable(false);
    }//GEN-LAST:event_tableProdMouseClicked

    private void btnModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarProdActionPerformed

    private void btnModificarProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarProdMousePressed
        if (validarProd()) {
            boolean modificado = false;
            ArrayList<Categoria> listaCag = cagDao.listaCategorias();
            ArrayList<Medida> listaMed = meDao.listaMedidas();
            prod.setIdProducto(txtIdProd.getText());
            prod.setNombreProd(txtNombreProd.getText());
            prod.setCostoProduccion(Double.parseDouble(txtPrecioProduccProd.getText()));
            prod.setPrecioVenta(Double.parseDouble(txtPrecioVentaProd.getText()));
            prod.setCagProducto(listaCag.get(indicecag).getId());
            prod.setMedidaProd(listaMed.get(indicemed).getIdMedida());
            int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea modificar el producto? ", "Modificar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                modificado=prodDao.ModificarProd(prod);
                if (modificado) {
                    JOptionPane.showMessageDialog(null, "Producto modificado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el Producto");
                }

                try {
                    limpiarTabla();
                    listarProd();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarProdMousePressed

    //Boton registrar productos
    private void btnRegistrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProdActionPerformed
        ArrayList<Categoria> listaCag = cagDao.listaCategorias();
        ArrayList<Medida> listaMed = meDao.listaMedidas();
        if (validarProd()) {

            prod.setIdProducto(txtIdProd.getText());
            prod.setNombreProd(txtNombreProd.getText());
            prod.setCostoProduccion(Double.valueOf(txtPrecioProduccProd.getText()));
            prod.setPrecioVenta(Double.valueOf(txtPrecioVentaProd.getText()));
            int itemnumbercag = cbxCategoriaProd.getSelectedIndex();
            int itemnumbermed = cbxMedidaProd.getSelectedIndex();
            prod.setCagProducto(listaCag.get(itemnumbercag).getId());
            //            prod.setCagProducto(cbxCategoriaProd.getSelectedItem().toString());
            prod.setMedidaProd(listaMed.get(itemnumbermed).getIdMedida());
            System.out.println();
            //            prod.setMedidaProd(cbxMedidaProd.getSelectedItem().toString());
            boolean registrado = false;
            try {
                registrado = prodDao.RegistrarProd(prod);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Producto registrado");
            }
            limpiarTabla();
            try {
                listarProd();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnRegistrarProdActionPerformed

    private void txtIdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdActionPerformed

    private void btnModificarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMedActionPerformed
        if (validarMedida()) {
            boolean modificado = false;
            me.setIdMedida(txtidMed.getText());
            me.setNombre(txtNombreMed.getText());
            me.setnCorto(txtNombreCortoMed.getText());

            int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea modificar la medida? ", "Modificar medida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                modificado=meDao.ModificarMedida(me);
                if (modificado) {
                    JOptionPane.showMessageDialog(null, "Medida modificada con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la medida");
                }

                try {
                    limpiarTabla();
                    listarMedidas();
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarMedActionPerformed

    private void btnRegistrarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMedActionPerformed
        if (validarMedida()) {

            me.setIdMedida(txtidMed.getText());
            me.setNombre(txtNombreMed.getText());
            me.setnCorto(txtNombreCortoMed.getText());
            boolean registrado = false;
            try {
                registrado = meDao.RegistrarMedidas(me);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Medida registrada");
            }
            limpiarTabla();
            try {
                listarMedidas();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnRegistrarMedActionPerformed

    private void btnNuevoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoMedActionPerformed

    private void btnNuevoMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMedMouseClicked
        limpiarmedida();
        medidaEditable(true);
        btnRegistrarMed.setVisible(true);
        btnModificarMed.setVisible(false);
    }//GEN-LAST:event_btnNuevoMedMouseClicked

    private void tableMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedMouseClicked
        int fila = tableMed.rowAtPoint(evt.getPoint());

        //pasando datos de la tabla a txtfields
        txtidMed.setText(tableMed.getValueAt(fila, 0).toString());
        txtNombreMed.setText(tableMed.getValueAt(fila, 1).toString());
        txtNombreCortoMed.setText(tableMed.getValueAt(fila, 2).toString());
        medidaEditable(false);
    }//GEN-LAST:event_tableMedMouseClicked

    private void editarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarProdActionPerformed

    private void btnNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProdActionPerformed
        prodEditable(true);
        btnRegistrarProd.setVisible(true);
        btnModificarProd.setVisible(false);
        limpiarmedida();
    }//GEN-LAST:event_btnNuevoProdActionPerformed

    private void eliminarCagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarCagActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Dashboard().setVisible(true);
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPanelCategorias;
    public javax.swing.JPanel JPanelEmpleados;
    public javax.swing.JPanel JPanelMedidas;
    public javax.swing.JPanel JPanelProductos;
    private javax.swing.JPanel PajinadorCag;
    private javax.swing.JPanel PajinadorClient;
    private javax.swing.JPanel PajinadorMed;
    private javax.swing.JPanel PajinadorProd;
    private javax.swing.JButton btnModificarCag;
    private javax.swing.JButton btnModificarEmp;
    private javax.swing.JButton btnModificarMed;
    private javax.swing.JButton btnModificarProd;
    private javax.swing.JButton btnNuevoCag;
    private javax.swing.JButton btnNuevoEmp;
    private javax.swing.JButton btnNuevoMed;
    private javax.swing.JButton btnNuevoProd;
    private javax.swing.JButton btnRegistrarCag;
    private javax.swing.JButton btnRegistrarEmp;
    private javax.swing.JButton btnRegistrarMed;
    private javax.swing.JButton btnRegistrarProd;
    private javax.swing.JComboBox<Object> cbxCategoriaProd;
    private javax.swing.JComboBox<Object> cbxMedidaProd;
    private javax.swing.JMenuItem editarCag;
    private javax.swing.JMenuItem editarProd;
    private javax.swing.JMenuItem eliminarCag;
    private javax.swing.JMenuItem eliminarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCategorias;
    private javax.swing.JLabel jLabelEmpleados;
    private javax.swing.JLabel jLabelMedidas;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu menuCag;
    public javax.swing.JMenuItem menuEditar;
    public javax.swing.JMenuItem menuEditarMed;
    public javax.swing.JMenuItem menuEliminar;
    public javax.swing.JMenuItem menuEliminarMed;
    private javax.swing.JPopupMenu menuEmp;
    private javax.swing.JPopupMenu menuMed;
    private javax.swing.JPopupMenu menuProd;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JTable tableCag;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTable tableMed;
    private javax.swing.JTable tableProd;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtNombreCag;
    private javax.swing.JTextField txtNombreCortoMed;
    private javax.swing.JTextField txtNombreMed;
    private javax.swing.JTextField txtNombreProd;
    private javax.swing.JTextField txtPrecioProduccProd;
    private javax.swing.JTextField txtPrecioVentaProd;
    private javax.swing.JTextField txtTelefonoEmp;
    private javax.swing.JTextField txtccEmp;
    private javax.swing.JTextField txtidCag;
    private javax.swing.JTextField txtidMed;
    private javax.swing.JTextField txtpApellidoEmp;
    private javax.swing.JTextField txtpNombreEmp;
    private javax.swing.JTextField txtsApellidoEmp;
    private javax.swing.JTextField txtsNombreEmp;
    // End of variables declaration//GEN-END:variables
}
