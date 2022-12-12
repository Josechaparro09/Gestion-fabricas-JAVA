
package Controllers;

import Models.Usuario;
import Models.UsuarioDao;
import Views.Admin;
import Views.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class LoginControllers implements MouseListener{
    
    private Usuario us;
    private UsuarioDao usDao;
    private Login view;

    public LoginControllers(Usuario us, UsuarioDao usDao, Login view) {
        this.us = us;
        this.usDao = usDao;
        this.view = view;
        this.view.jPaneEntrar.addMouseListener(this);
        this.view.setLocationRelativeTo(null);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==view.jPaneEntrar) {
            
            if (view.txtUsuario.getText().equals("") || String.valueOf(view.txtClave.getPassword()).equals("")){
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }else{
                String usuario=view.txtUsuario.getText();
                String clave =String.valueOf(view.txtClave.getPassword());
                us = usDao.login(usuario, clave);
                if (us.getUsuario() != null){
            
                    var admin = new Admin();
                    admin.setVisible(true);
                    this.view.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                }
            }
                
        }else{
            
           int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir" , "pregunta" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
            if (pregunta==0) {
                System.exit(0);
            }
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
    
    
}
