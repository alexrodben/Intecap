/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import java.util.logging.Logger;

/**
 *
 * @author DIVISA
 */
public class InicioModelo extends Modelo{
    private static final Logger LOG = Logger.getLogger(LoginModelo.class.getName());

    public InicioModelo() {
        usuarios = new UsuariosDAO();
        tareas = new TareasDAO();
    }
    
}
