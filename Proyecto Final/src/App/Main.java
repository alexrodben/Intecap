/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.LoginControlador;
import Vista.LoginVista;

/**
 *
 * @author DIVISA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginVista vista = new LoginVista();
        LoginControlador controlador = new LoginControlador(vista);
        vista.setVisible(true);
        controlador = null;
        vista = null;
    }
    
}
