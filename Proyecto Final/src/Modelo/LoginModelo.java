/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.UsuariosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DIVISA
 */
public class LoginModelo extends Modelo{
    private static final Logger LOG = Logger.getLogger(LoginModelo.class.getName());

    public LoginModelo() {
        usuarios = new UsuariosDAO();
    }

    public boolean verificar(JTextField usuario, JPasswordField contraseña) {
        String condicion = " username='" + usuario.getText() + "' AND password ='" + String.valueOf(contraseña.getPassword()) +"'";
        ResultSet resultSet = super.connect.obtener(usuarios.selectSql(condicion));
        try{
            if(resultSet != null && resultSet.next()){
                String data[] = new String[usuarios.getColumnas()];
                for (int i = 0; i < usuarios.getColumnas(); i++) {
                    data[i] = resultSet.getString(i+1);
                }
                usuarios.loadData(data);
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            LOG.log(Level.SEVERE, "Error al verificar: ", e.getMessage());
            return false;
        }
    }
    
    public UsuariosDAO getData(){
        return usuarios;
    }
    
}
