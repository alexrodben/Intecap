/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author DIVISA
 */
public class Controlador{
    private static final Logger LOG = Logger.getLogger(Controlador.class.getName());
    
    protected Modelo modelo = new Modelo();

    protected void loadDataTable(String sqlString, JTable jTable){
        try{
            modelo.loadTable(sqlString, jTable, false);
        }catch(Exception e ){
            LOG.severe(e.getMessage());
        }
    }
    
    protected void quitarColumnaJTable(JTable jTable, int[] columna){
        try {
            for (int i = 0; i < columna.length; i++) {
                jTable.removeColumn(jTable.getColumnModel().getColumn(columna[i]));
            }
        } catch (Exception e) {
            LOG.severe(e.getMessage());
        }
    }
    protected void anchoColumnaJTable(JTable jTable, int[][] index){
        try {
            for (int i = 0; i < index.length; i++) {
                jTable.getColumnModel().getColumn(index[i][0]).setMaxWidth(index[i][1]);
                jTable.getColumnModel().getColumn(index[i][0]).setMinWidth(index[i][1]);
            }
        } catch (Exception e) {
            LOG.severe(e.getMessage());
        }
    }

    
}
