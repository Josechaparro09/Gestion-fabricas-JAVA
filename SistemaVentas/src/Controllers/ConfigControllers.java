/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.Admin;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Yurainis
 */
public class ConfigControllers implements MouseListener{

    private Admin view;

    public ConfigControllers(Admin view) {
        this.view = view;
        this.view.JLabelCategorias.addMouseListener(this);
        this.view.JLabelClientes.addMouseListener(this);
        this.view.JLabelConfig.addMouseListener(this);
        this.view.JLabelMedidas.addMouseListener(this);
        this.view.JLabelNuevaCompra.addMouseListener(this);
        this.view.JLabelNuevaVenta.addMouseListener(this);
        this.view.JLabelProveedor.addMouseListener(this);
        this.view.JLabelUsers.addMouseListener(this);
        this.view.JLabelProductos.addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.JLabelConfig) {
            view.jTabbedpane1.setSelectedIndex(9);
            
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
        if (e.getSource()== view.JLabelCategorias) {
            view.JPanelCategorias.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelClientes) {
            view.JPanelClientes.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelConfig) {
            view.JPanelConfig.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelMedidas) {
            view.JPanelMedidas.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelNuevaCompra) {
            view.JPanelNuevaCompra.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelNuevaVenta) {
            view.JPanelNuevaVenta.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelProveedor) {
            view.JPanelProveedor.setBackground(new Color(13, 71, 161));
        }else if (e.getSource() == view.JLabelUsers) {
            view.JPanelUsers.setBackground(new Color(13, 71, 161));
        }else {
            view.JPanelProductos.setBackground(new Color(13, 71, 161));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()== view.JLabelCategorias) {
            view.JPanelCategorias.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelClientes) {
            view.JPanelClientes.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelConfig) {
            view.JPanelConfig.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelMedidas) {
            view.JPanelMedidas.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelNuevaCompra) {
            view.JPanelNuevaCompra.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelNuevaVenta) {
            view.JPanelNuevaVenta.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelProveedor) {
            view.JPanelProveedor.setBackground(new Color(18, 90, 173));
        }else if (e.getSource() == view.JLabelUsers) {
            view.JPanelUsers.setBackground(new Color(18, 90, 173));
        }else {
            view.JPanelProductos.setBackground(new Color(18, 90, 173));
        }
        
    }
    
}
