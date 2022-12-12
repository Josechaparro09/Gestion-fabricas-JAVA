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
        if (!"".equals(txtIdProd.getText()) || !"".equals(txtNombreProd.getText()) || !"".equals(txtPrecioProduccProd.getText())|| !"".equals(txtPrecioVentaProd.getText())|| !"".equals(cbxCategoriaProd.getSelectedItem())|| !"".equals(cbxMedidaProd.getSelectedItem())) {
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
        tableEmp.setModel(modelo);
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
        tableEmp.setModel(modelo);
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
        JPanelNuevaVenta = new javax.swing.JPanel();
        jLabelNuevaventa = new javax.swing.JLabel();
        JPanelEmpleados = new javax.swing.JPanel();
        jLabelEmpleados = new javax.swing.JLabel();
        JPanelProductos = new javax.swing.JPanel();
        jLabelProductos = new javax.swing.JLabel();
        JPanelClientes = new javax.swing.JPanel();
        jLabelClientes = new javax.swing.JLabel();
        JPanelMprima = new javax.swing.JPanel();
        jLabelMprima = new javax.swing.JLabel();
        JPanelMedidas = new javax.swing.JPanel();
        jLabelMedidas = new javax.swing.JLabel();
        JPanelCategorias = new javax.swing.JPanel();
        jLabelCategorias = new javax.swing.JLabel();
        JPanelConfig = new javax.swing.JPanel();
        jLabelConfiguracion = new javax.swing.JLabel();
        JPanelPlantas = new javax.swing.JPanel();
        jLabelPlantas = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        PajinadorClient = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombreProv = new javax.swing.JTextField();
        txtTelefonoProv = new javax.swing.JTextField();
        btnNuevoProv = new javax.swing.JButton();
        btnRegistrarProv = new javax.swing.JButton();
        btnModificarProv = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDireccionProv = new javax.swing.JTextPane();
        txtIdProv = new javax.swing.JTextField();
        txtBuscarProv = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableProv = new javax.swing.JTable();
        Pajinadorprov = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtUsuarioUser = new javax.swing.JTextField();
        txtNombreUser = new javax.swing.JTextField();
        btnNuevoUser = new javax.swing.JButton();
        btnRegistrarUser = new javax.swing.JButton();
        btnModificarUser = new javax.swing.JButton();
        txtClaveUser = new javax.swing.JPasswordField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbxCajaUser = new javax.swing.JComboBox<>();
        cbxRolUser = new javax.swing.JComboBox<>();
        txtIdUser = new javax.swing.JTextField();
        txtBuscarUsers = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        PajinadorUser = new javax.swing.JPanel();
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
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        txtCodNv = new javax.swing.JTextField();
        txtProdNv = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNuevaVenta1 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnGenerarVenta1 = new javax.swing.JButton();
        txtCodNv3 = new javax.swing.JTextField();
        txtProdNv1 = new javax.swing.JTextField();
        txtCantNv1 = new javax.swing.JTextField();
        txtPrecioNv1 = new javax.swing.JTextField();
        txtTotalNv1 = new javax.swing.JTextField();
        txtStockNv1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtCodNv5 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txtCodNv4 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        PaginadorVentas = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableCompras = new javax.swing.JTable();
        PaginadorCompras = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        btnModificarEmpresa = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtDireecionEmpresa = new javax.swing.JTextPane();
        txtRutEmpresa = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextPane();
        jLabel56 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableNuevaCompra = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnGenerarCompra = new javax.swing.JButton();
        txtCodNC = new javax.swing.JTextField();
        txtProdNC = new javax.swing.JTextField();
        txtCantNC = new javax.swing.JTextField();
        txtPrecioNC = new javax.swing.JTextField();
        txtTotalNC = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtCodNv8 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();

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
        menuProd.add(editarProd);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(18, 90, 173));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanelNuevaVenta.setBackground(new java.awt.Color(18, 90, 173));

        jLabelNuevaventa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNuevaventa.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelNuevaventa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNuevaventa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNuevaventa.setText("Nueva venta");
        jLabelNuevaventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNuevaventaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNuevaventaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNuevaventaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelNuevaVentaLayout = new javax.swing.GroupLayout(JPanelNuevaVenta);
        JPanelNuevaVenta.setLayout(JPanelNuevaVentaLayout);
        JPanelNuevaVentaLayout.setHorizontalGroup(
            JPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNuevaVentaLayout.createSequentialGroup()
                .addComponent(jLabelNuevaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPanelNuevaVentaLayout.setVerticalGroup(
            JPanelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNuevaventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 244, 55));

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

        JPanelClientes.setBackground(new java.awt.Color(18, 90, 173));

        jLabelClientes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelClientes.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelClientes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClientes.setText("Clientes");
        jLabelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelClientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelClientesLayout = new javax.swing.GroupLayout(JPanelClientes);
        JPanelClientes.setLayout(JPanelClientesLayout);
        JPanelClientesLayout.setHorizontalGroup(
            JPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelClientesLayout.setVerticalGroup(
            JPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 244, 55));

        JPanelMprima.setBackground(new java.awt.Color(18, 90, 173));

        jLabelMprima.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMprima.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelMprima.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMprima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMprima.setText("Materia prima");
        jLabelMprima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMprimaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMprimaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMprimaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelMprimaLayout = new javax.swing.GroupLayout(JPanelMprima);
        JPanelMprima.setLayout(JPanelMprimaLayout);
        JPanelMprimaLayout.setHorizontalGroup(
            JPanelMprimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMprima, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelMprimaLayout.setVerticalGroup(
            JPanelMprimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMprima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelMprima, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 244, 55));

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

        jPanel1.add(JPanelMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 244, 55));

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

        jPanel1.add(JPanelCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 244, 55));

        JPanelConfig.setBackground(new java.awt.Color(18, 90, 173));

        jLabelConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracion.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConfiguracion.setText("Configuración");
        jLabelConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelConfiguracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelConfiguracionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelConfigLayout = new javax.swing.GroupLayout(JPanelConfig);
        JPanelConfig.setLayout(JPanelConfigLayout);
        JPanelConfigLayout.setHorizontalGroup(
            JPanelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelConfigLayout.setVerticalGroup(
            JPanelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 244, 55));

        JPanelPlantas.setBackground(new java.awt.Color(18, 90, 173));

        jLabelPlantas.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPlantas.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabelPlantas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlantas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlantas.setText("Plantas");
        jLabelPlantas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPlantasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPlantasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanelPlantasLayout = new javax.swing.GroupLayout(JPanelPlantas);
        JPanelPlantas.setLayout(JPanelPlantasLayout);
        JPanelPlantasLayout.setHorizontalGroup(
            JPanelPlantasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPlantas, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        JPanelPlantasLayout.setVerticalGroup(
            JPanelPlantasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPlantas, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelPlantas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 244, 55));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 244, 950));

        jPanel2.setBackground(new java.awt.Color(13, 71, 161));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 30));

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
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

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nuevo Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setText("Nombre");

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel19.setText("Telefono");

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel20.setText("Dirección");

        txtNombreProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProvActionPerformed(evt);
            }
        });

        btnNuevoProv.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoProv.setText("Nuevo");

        btnRegistrarProv.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarProv.setText("Registrar");

        btnModificarProv.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarProv.setText("Modificar");

        jScrollPane6.setViewportView(txtDireccionProv);

        txtIdProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProvActionPerformed(evt);
            }
        });

        txtBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefonoProv, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)
                            .addComponent(txtNombreProv)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(btnNuevoProv)
                        .addGap(12, 12, 12)
                        .addComponent(btnRegistrarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarProv)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(txtBuscarProv, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTelefonoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel20))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );

        jPanel6.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 460));

        tableProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Teléfono", "Dirección", "Estado"
            }
        ));
        jScrollPane7.setViewportView(tableProv);

        jPanel6.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 770, 360));

        javax.swing.GroupLayout PajinadorprovLayout = new javax.swing.GroupLayout(Pajinadorprov);
        Pajinadorprov.setLayout(PajinadorprovLayout);
        PajinadorprovLayout.setHorizontalGroup(
            PajinadorprovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorprovLayout.setVerticalGroup(
            PajinadorprovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel6.add(Pajinadorprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 770, 90));

        paneles.addTab("Proveedor", jPanel6);

        jPanel7.setBackground(new java.awt.Color(51, 255, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Nuevo Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel21.setText("Usuario");

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel22.setText("Nombre");

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel23.setText("Contraseña");

        txtUsuarioUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuarioUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioUserActionPerformed(evt);
            }
        });

        txtNombreUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnNuevoUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnNuevoUser.setText("Nuevo");

        btnRegistrarUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarUser.setText("Registrar");

        btnModificarUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarUser.setText("Modificar");

        txtClaveUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtClaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveUserActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel24.setText("Caja");

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel25.setText("Rol");

        cbxCajaUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxCajaUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General" }));

        cbxRolUser.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbxRolUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador" }));

        txtIdUser.setToolTipText("");
        txtIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUserActionPerformed(evt);
            }
        });

        txtBuscarUsers.setToolTipText("");
        txtBuscarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxRolUser, 0, 166, Short.MAX_VALUE)
                    .addComponent(cbxCajaUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuarioUser)
                    .addComponent(txtBuscarUsers)
                    .addComponent(txtNombreUser)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(txtClaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(btnNuevoUser)
                                .addGap(12, 12, 12)
                                .addComponent(btnRegistrarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificarUser))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscarUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtUsuarioUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtClaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbxCajaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbxRolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel7.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 290, -1));

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Nombre", "Rol", "", "Estado"
            }
        ));
        tableUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane9.setViewportView(tableUser);

        jPanel7.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 19, 770, 360));

        javax.swing.GroupLayout PajinadorUserLayout = new javax.swing.GroupLayout(PajinadorUser);
        PajinadorUser.setLayout(PajinadorUserLayout);
        PajinadorUserLayout.setHorizontalGroup(
            PajinadorUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        PajinadorUserLayout.setVerticalGroup(
            PajinadorUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel7.add(PajinadorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 389, -1, -1));

        paneles.addTab("Usuario", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 153));
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

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
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

        jPanel10.setBackground(new java.awt.Color(153, 255, 102));

        jLabel16.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel16.setText("Stock");

        jLabel17.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel17.setText("Total");

        btnGenerarVenta.setText("Generar");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        txtCodNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNvActionPerformed(evt);
            }
        });

        txtProdNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdNvActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(153, 255, 102));

        tableNuevaVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción", "Cant", "Precio", "Total"
            }
        ));
        jScrollPane5.setViewportView(tableNuevaVenta1);

        jLabel33.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel33.setText("Producto");

        jLabel34.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel34.setText("Código");

        jLabel35.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel35.setText("Precio");

        jLabel36.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel36.setText("Cant");

        jLabel37.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel37.setText("Stock");

        jLabel38.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel38.setText("Total");

        btnGenerarVenta1.setText("Generar");
        btnGenerarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVenta1ActionPerformed(evt);
            }
        });

        txtCodNv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNv3ActionPerformed(evt);
            }
        });

        txtProdNv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdNv1ActionPerformed(evt);
            }
        });

        txtCantNv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantNv1ActionPerformed(evt);
            }
        });

        txtPrecioNv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioNv1ActionPerformed(evt);
            }
        });

        txtTotalNv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNv1ActionPerformed(evt);
            }
        });

        txtStockNv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockNv1ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel39.setText("Cliente");

        txtCodNv5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNv5ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel40.setText("Total Pagar");

        jLabel41.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel41.setText("-----------");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        txtCodNv4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNv4ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel42.setText("Pagar con");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(txtCodNv3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(txtProdNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(43, 43, 43)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(txtPrecioNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(txtTotalNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtStockNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(btnGenerarVenta1)
                .addGap(136, 136, 136))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel39)
                .addGap(29, 29, 29)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(txtCodNv5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(txtCodNv4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addGap(59, 59, 59))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarVenta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodNv3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(12, 12, 12)
                        .addComponent(txtProdNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jLabel37))
                            .addComponent(jLabel36))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtCantNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecioNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStockNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(txtCodNv5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(txtCodNv4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(368, 368, 368))))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtCodNv, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtProdNv, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(69, 69, 69)
                .addComponent(jLabel16)
                .addGap(93, 93, 93)
                .addComponent(btnGenerarVenta)
                .addGap(136, 136, 136))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdNv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(42, 42, 42)))
                .addContainerGap(843, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        paneles.addTab("tab7", jPanel10);

        jPanel11.setBackground(new java.awt.Color(102, 102, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Total", "Fecha"
            }
        ));
        jScrollPane12.setViewportView(tableVentas);

        jPanel11.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1040, 380));

        javax.swing.GroupLayout PaginadorVentasLayout = new javax.swing.GroupLayout(PaginadorVentas);
        PaginadorVentas.setLayout(PaginadorVentasLayout);
        PaginadorVentasLayout.setHorizontalGroup(
            PaginadorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        PaginadorVentasLayout.setVerticalGroup(
            PaginadorVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel11.add(PaginadorVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1040, 60));

        paneles.addTab("tab8", jPanel11);

        jPanel12.setBackground(new java.awt.Color(51, 255, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Proveedor", "Total", "Fecha"
            }
        ));
        jScrollPane13.setViewportView(tableCompras);

        jPanel12.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1040, 380));

        javax.swing.GroupLayout PaginadorComprasLayout = new javax.swing.GroupLayout(PaginadorCompras);
        PaginadorCompras.setLayout(PaginadorComprasLayout);
        PaginadorComprasLayout.setHorizontalGroup(
            PaginadorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        PaginadorComprasLayout.setVerticalGroup(
            PaginadorComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel12.add(PaginadorCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1040, 60));

        paneles.addTab("tab9", jPanel12);

        jPanel13.setBackground(new java.awt.Color(0, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos de la empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel43.setText("Nombre");

        jLabel44.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel44.setText("Telefono");

        jLabel45.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel45.setText("Dirección");

        txtNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpresaActionPerformed(evt);
            }
        });

        btnModificarEmpresa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificarEmpresa.setText("Modificar");

        jScrollPane14.setViewportView(txtDireecionEmpresa);

        txtRutEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutEmpresaActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel50.setText("Rut");

        jScrollPane15.setViewportView(txtMensaje);

        jLabel56.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel56.setText("Mensaje");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel50))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jScrollPane14)
                            .addComponent(txtNombreEmpresa)
                            .addComponent(txtRutEmpresa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarEmpresa)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtRutEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel45))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel56))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel13.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 460));
        jPanel19.getAccessibleContext().setAccessibleName("Datos de la fabrica");

        paneles.addTab("tab10", jPanel13);

        jPanel18.setBackground(new java.awt.Color(153, 255, 102));

        tableNuevaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción", "Cant", "Precio", "Total"
            }
        ));
        jScrollPane8.setViewportView(tableNuevaCompra);

        jLabel46.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel46.setText("Producto");

        jLabel47.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel47.setText("Código");

        jLabel48.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel48.setText("Precio");

        jLabel49.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel49.setText("Cant");

        jLabel51.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel51.setText("Total");

        btnGenerarCompra.setText("Generar");
        btnGenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCompraActionPerformed(evt);
            }
        });

        txtCodNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNCActionPerformed(evt);
            }
        });

        txtProdNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdNCActionPerformed(evt);
            }
        });

        txtCantNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantNCActionPerformed(evt);
            }
        });

        txtPrecioNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioNCActionPerformed(evt);
            }
        });

        txtTotalNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNCActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel52.setText("Proveedor");

        txtCodNv8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodNv8ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel53.setText("Total Pagar");

        jLabel54.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel54.setText("-----------");

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel55.setText("Pagar con");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(txtCodNC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(txtProdNC, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantNC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(43, 43, 43)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(txtPrecioNC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(txtTotalNC, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175)
                .addComponent(btnGenerarCompra)
                .addGap(136, 136, 136))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel52)
                .addGap(29, 29, 29)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addGap(18, 18, 18)
                .addComponent(txtCodNv8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addGap(59, 59, 59))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(12, 12, 12)
                        .addComponent(txtProdNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel49))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtCantNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecioNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalNC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(txtCodNv8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(420, 420, 420))))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1118, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 924, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        paneles.addTab("Nueva Compra", jPanel14);

        getContentPane().add(paneles, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 1120, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void txtCodNv8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNv8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNv8ActionPerformed

    private void txtTotalNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalNCActionPerformed

    private void txtPrecioNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioNCActionPerformed

    private void txtCantNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantNCActionPerformed

    private void txtProdNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdNCActionPerformed

    private void txtCodNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNCActionPerformed

    private void btnGenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarCompraActionPerformed

    private void txtRutEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutEmpresaActionPerformed

    private void txtNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaActionPerformed

    private void txtCodNv4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNv4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNv4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void txtCodNv5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNv5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNv5ActionPerformed

    private void txtStockNv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockNv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockNv1ActionPerformed

    private void txtTotalNv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalNv1ActionPerformed

    private void txtPrecioNv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioNv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioNv1ActionPerformed

    private void txtCantNv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantNv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantNv1ActionPerformed

    private void btnGenerarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarVenta1ActionPerformed

    private void txtProdNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdNvActionPerformed

    private void txtCodNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNvActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtBuscarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarUsersActionPerformed

    private void txtIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserActionPerformed

    private void txtClaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveUserActionPerformed

    private void txtUsuarioUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioUserActionPerformed

    private void txtBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProvActionPerformed

    private void txtIdProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProvActionPerformed

    private void txtNombreProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProvActionPerformed

    private void txtpNombreEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpNombreEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpNombreEmpActionPerformed

    private void txtIdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdActionPerformed

    private void jLabelNuevaventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNuevaventaMouseEntered
        JPanelNuevaVenta.setBackground(new Color(13,71,161));
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabelNuevaventaMouseEntered

    private void jLabelNuevaventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNuevaventaMouseExited
        JPanelNuevaVenta.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelNuevaventaMouseExited

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

    private void jLabelClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClientesMouseEntered
        JPanelClientes.setBackground(new Color(13,71,161));      // TODO add your handling code here:
    }//GEN-LAST:event_jLabelClientesMouseEntered

    private void jLabelClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClientesMouseExited
        JPanelClientes.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelClientesMouseExited

    private void jLabelMprimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMprimaMouseClicked
        paneles.setSelectedIndex(2);// TODO add your handling code here:
    }//GEN-LAST:event_jLabelMprimaMouseClicked

    private void jLabelMprimaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMprimaMouseEntered
        JPanelMprima.setBackground(new Color(13,71,161));      // TODO add your handling code here:
    }//GEN-LAST:event_jLabelMprimaMouseEntered

    private void jLabelMprimaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMprimaMouseExited
        JPanelMprima.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelMprimaMouseExited

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

    private void jLabelConfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfiguracionMouseEntered
        JPanelConfig.setBackground(new Color(13,71,161));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabelConfiguracionMouseEntered

    private void jLabelConfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfiguracionMouseExited
        JPanelConfig.setBackground(new Color(18, 90, 173));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelConfiguracionMouseExited

    private void jLabelNuevaventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNuevaventaMouseClicked
        paneles.setSelectedIndex(6);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelNuevaventaMouseClicked

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

    private void txtCodNv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodNv3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodNv3ActionPerformed

    private void txtProdNv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdNv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdNv1ActionPerformed

    private void jLabelPlantasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPlantasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelPlantasMouseEntered

    private void jLabelPlantasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPlantasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelPlantasMouseExited

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

    private void jLabelEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpleadosMouseClicked
        limpiarTabla();
        try {
            listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(1);
    }//GEN-LAST:event_jLabelEmpleadosMouseClicked

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

    private void btnRegistrarEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEmpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarEmpMouseClicked

    private void btnNuevoEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoEmpMouseClicked
        // TODO add your handling code here:
        empleadoEditable(true);
        btnRegistrarEmp.setVisible(true);
        btnModificarEmp.setVisible(false);
        limpiarempleado();
    }//GEN-LAST:event_btnNuevoEmpMouseClicked

    private void menuEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEditarMousePressed
                
        empleadoEditable(true);
        txtccEmp.setEditable(false);
        btnRegistrarEmp.setVisible(false);
        btnModificarEmp.setVisible(true);
        modificar = tableEmp.rowAtPoint(evt.getPoint()); 
        
        
    }//GEN-LAST:event_menuEditarMousePressed

    private void txtsApellidoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsApellidoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsApellidoEmpActionPerformed

    private void txtpApellidoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpApellidoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpApellidoEmpActionPerformed

    private void btnNuevoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoEmpActionPerformed

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

    private void jLabelMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMedidasMouseClicked
        limpiarTabla();
        try {
            listarMedidas();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(5);
    }//GEN-LAST:event_jLabelMedidasMouseClicked
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

    private void tableMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedMouseClicked
        int fila = tableMed.rowAtPoint(evt.getPoint()); 
        
        
        //pasando datos de la tabla a txtfields
        txtidMed.setText(tableMed.getValueAt(fila, 0).toString());
        txtNombreMed.setText(tableMed.getValueAt(fila, 1).toString());
        txtNombreCortoMed.setText(tableMed.getValueAt(fila, 2).toString());
        medidaEditable(false);
    }//GEN-LAST:event_tableMedMouseClicked

    private void btnNuevoMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMedMouseClicked
        limpiarmedida();
        medidaEditable(true);
        btnRegistrarMed.setVisible(true);
        btnModificarMed.setVisible(false);
    }//GEN-LAST:event_btnNuevoMedMouseClicked

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
    // boton modificar medida
    private void btnModificarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMedActionPerformed
        
        if (validarMedida()) {
            boolean modificado = false;
            me.setIdMedida(txtidMed.getText());
            me.setNombre(txtNombreMed.getText());
            me.setnCorto(txtNombreCortoMed.getText());
            
            int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea modificar la medida? " , "Modificar medida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                modificado=meDao.ModificarMedida(me);
                if (modificado) {
                    JOptionPane.showMessageDialog(null, "Medida modificada con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar medida");
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

    private void btnNuevoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoMedActionPerformed

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
       //categorias activador
    private void jLabelCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCategoriasMouseClicked
        limpiarTabla();
        try {
            listarCag();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneles.setSelectedIndex(4);
    }//GEN-LAST:event_jLabelCategoriasMouseClicked

    private void eliminarCagMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarCagMousePressed
        int fila = tableMed.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea eliminar la categoria?", "Eliminar categoria", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
                eliminado=meDao.eliminarMedida(tableCag.getValueAt(fila, 0).toString());
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

    private void btnNuevoCagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoCagMouseClicked
        cagEditable(true);
        btnRegistrarCag.setVisible(true);
        btnModificarCag.setVisible(false);
        limpiarCag();
    }//GEN-LAST:event_btnNuevoCagMouseClicked

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

    private void editarCagMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCagMousePressed
        cagEditable(true);
        txtidCag.setEditable(false);
        btnRegistrarCag.setVisible(false);
        btnModificarCag.setVisible(true);
        modificar = tableCag.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_editarCagMousePressed

    private void tableCagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCagMouseClicked
        int fila = tableCag.rowAtPoint(evt.getPoint()); 
       
        txtidCag.setText(tableCag.getValueAt(fila, 0).toString());
        txtNombreCag.setText(tableCag.getValueAt(fila, 1).toString());
        cagEditable(false);
    }//GEN-LAST:event_tableCagMouseClicked
    
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

    private void eliminarProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarProdMousePressed
        int fila = tableProd.rowAtPoint(evt.getPoint()); 
        boolean eliminado = false;
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que de desea eliminar el producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == JOptionPane.YES_OPTION) {
            try {
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

    private void editarProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarProdMousePressed
        prodEditable(true);
        txtIdProd.setEditable(false);
        btnRegistrarProd.setVisible(false);
        btnModificarProd.setVisible(true);
        modificar = tableProd.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_editarProdMousePressed

    private void btnModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarProdActionPerformed

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
    public javax.swing.JPanel JPanelClientes;
    public javax.swing.JPanel JPanelConfig;
    public javax.swing.JPanel JPanelEmpleados;
    public javax.swing.JPanel JPanelMedidas;
    public javax.swing.JPanel JPanelMprima;
    public javax.swing.JPanel JPanelNuevaVenta;
    public javax.swing.JPanel JPanelPlantas;
    public javax.swing.JPanel JPanelProductos;
    private javax.swing.JPanel PaginadorCompras;
    private javax.swing.JPanel PaginadorVentas;
    public javax.swing.JPanel PajinadorCag;
    public javax.swing.JPanel PajinadorClient;
    public javax.swing.JPanel PajinadorMed;
    public javax.swing.JPanel PajinadorProd;
    private javax.swing.JPanel PajinadorUser;
    public javax.swing.JPanel Pajinadorprov;
    private javax.swing.JButton btnGenerarCompra;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGenerarVenta1;
    public javax.swing.JButton btnModificarCag;
    public javax.swing.JButton btnModificarEmp;
    private javax.swing.JButton btnModificarEmpresa;
    public javax.swing.JButton btnModificarMed;
    public javax.swing.JButton btnModificarProd;
    public javax.swing.JButton btnModificarProv;
    public javax.swing.JButton btnModificarUser;
    public javax.swing.JButton btnNuevoCag;
    public javax.swing.JButton btnNuevoEmp;
    public javax.swing.JButton btnNuevoMed;
    public javax.swing.JButton btnNuevoProd;
    public javax.swing.JButton btnNuevoProv;
    public javax.swing.JButton btnNuevoUser;
    public javax.swing.JButton btnRegistrarCag;
    public javax.swing.JButton btnRegistrarEmp;
    public javax.swing.JButton btnRegistrarMed;
    public javax.swing.JButton btnRegistrarProd;
    public javax.swing.JButton btnRegistrarProv;
    public javax.swing.JButton btnRegistrarUser;
    public javax.swing.JComboBox<String> cbxCajaUser;
    public javax.swing.JComboBox<Object> cbxCategoriaProd;
    public javax.swing.JComboBox<Object> cbxMedidaProd;
    public javax.swing.JComboBox<String> cbxRolUser;
    private javax.swing.JMenuItem editarCag;
    private javax.swing.JMenuItem editarProd;
    private javax.swing.JMenuItem eliminarCag;
    private javax.swing.JMenuItem eliminarProd;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCategorias;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelConfiguracion;
    private javax.swing.JLabel jLabelEmpleados;
    private javax.swing.JLabel jLabelMedidas;
    private javax.swing.JLabel jLabelMprima;
    private javax.swing.JLabel jLabelNuevaventa;
    private javax.swing.JLabel jLabelPlantas;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu menuCag;
    public javax.swing.JMenuItem menuEditar;
    public javax.swing.JMenuItem menuEditarMed;
    public javax.swing.JMenuItem menuEliminar;
    public javax.swing.JMenuItem menuEliminarMed;
    private javax.swing.JPopupMenu menuEmp;
    private javax.swing.JPopupMenu menuMed;
    private javax.swing.JPopupMenu menuProd;
    public javax.swing.JTabbedPane paneles;
    public javax.swing.JTable tableCag;
    private javax.swing.JTable tableCompras;
    public javax.swing.JTable tableEmp;
    public javax.swing.JTable tableMed;
    private javax.swing.JTable tableNuevaCompra;
    private javax.swing.JTable tableNuevaVenta1;
    public javax.swing.JTable tableProd;
    public javax.swing.JTable tableProv;
    public javax.swing.JTable tableUser;
    private javax.swing.JTable tableVentas;
    public javax.swing.JTextField txtBuscarProv;
    public javax.swing.JTextField txtBuscarUsers;
    private javax.swing.JTextField txtCantNC;
    private javax.swing.JTextField txtCantNv1;
    public javax.swing.JPasswordField txtClaveUser;
    private javax.swing.JTextField txtCodNC;
    private javax.swing.JTextField txtCodNv;
    private javax.swing.JTextField txtCodNv3;
    private javax.swing.JTextField txtCodNv4;
    private javax.swing.JTextField txtCodNv5;
    private javax.swing.JTextField txtCodNv8;
    public javax.swing.JTextPane txtDireccionProv;
    private javax.swing.JTextPane txtDireecionEmpresa;
    public javax.swing.JTextField txtIdProd;
    public javax.swing.JTextField txtIdProv;
    public javax.swing.JTextField txtIdUser;
    private javax.swing.JTextPane txtMensaje;
    public javax.swing.JTextField txtNombreCag;
    public javax.swing.JTextField txtNombreCortoMed;
    private javax.swing.JTextField txtNombreEmpresa;
    public javax.swing.JTextField txtNombreMed;
    public javax.swing.JTextField txtNombreProd;
    public javax.swing.JTextField txtNombreProv;
    public javax.swing.JTextField txtNombreUser;
    private javax.swing.JTextField txtPrecioNC;
    private javax.swing.JTextField txtPrecioNv1;
    public javax.swing.JTextField txtPrecioProduccProd;
    public javax.swing.JTextField txtPrecioVentaProd;
    private javax.swing.JTextField txtProdNC;
    private javax.swing.JTextField txtProdNv;
    private javax.swing.JTextField txtProdNv1;
    private javax.swing.JTextField txtRutEmpresa;
    private javax.swing.JTextField txtStockNv1;
    public javax.swing.JTextField txtTelefonoEmp;
    private javax.swing.JTextField txtTelefonoEmpresa;
    public javax.swing.JTextField txtTelefonoProv;
    private javax.swing.JTextField txtTotalNC;
    private javax.swing.JTextField txtTotalNv1;
    public javax.swing.JTextField txtUsuarioUser;
    public javax.swing.JTextField txtccEmp;
    public javax.swing.JTextField txtidCag;
    public javax.swing.JTextField txtidMed;
    public javax.swing.JTextField txtpApellidoEmp;
    public javax.swing.JTextField txtpNombreEmp;
    public javax.swing.JTextField txtsApellidoEmp;
    public javax.swing.JTextField txtsNombreEmp;
    // End of variables declaration//GEN-END:variables
}
