/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.Tareas;
import Modelo.DAO.Usuarios;
import Modelo.DAO.UsuariosRoles;

/**
 *
 * @author DIVISA
 */
public class Modelo {
    protected Connect connect = new Connect();
    protected UsuariosRoles usuariosRoles;
    protected Usuarios usuarios;
    protected Tareas tareas;
    
}
