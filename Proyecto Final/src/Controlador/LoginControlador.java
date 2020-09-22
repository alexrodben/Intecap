/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.UsuariosDAO;
import Modelo.LoginModelo;
import Vista.InicioVista;
import Vista.LoginVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DIVISA
 */
public class LoginControlador extends Controlador implements ActionListener{
    private final LoginModelo modelo;
    private final LoginVista vista;
    private final JButton login;
    private final JTextField usuario;
    private final JPasswordField contraseña;
    
    public LoginControlador(LoginVista vista) {
        this.vista = vista;
        this.login = vista.jButtonLogin;
        this.usuario = vista.jTextField;
        this.contraseña = vista.jPasswordField;
        this.modelo = new LoginModelo();
        usuario.requestFocus();
        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(usuario.getText().isEmpty() && String.valueOf(contraseña.getPassword()).isEmpty()){
            usuario.requestFocus();
            JOptionPane.showMessageDialog(vista, "No ha llenado todos los datos ", "Verificacion", JOptionPane.ERROR_MESSAGE);
        }else{
            if(modelo.verificar(usuario,contraseña)){
                UsuariosDAO usuario = modelo.getData();
                if(usuario.getEstado_id().equals("1")){
                    InicioVista vistaInicio = new InicioVista();
                    InicioControlador inicio = new InicioControlador(vistaInicio, usuario);
                    vista.setVisible(false);
                    vistaInicio.setVisible(true);
                    vistaInicio = null;
                    inicio = null;
                }else{
                    JOptionPane.showMessageDialog(vista, "Usuario no se encuentra Activo", "Verificacion", JOptionPane.ERROR_MESSAGE);
                    limpiar();
                }
            }else{
                JOptionPane.showMessageDialog(vista, "Usuario o contraseña son inconrrectos ", "Verificacion", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }
    }
    
    private void limpiar(){
        usuario.setText("");
        contraseña.setText("");
        usuario.requestFocus();
    }
    
}
