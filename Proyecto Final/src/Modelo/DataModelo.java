/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.TareasDAO;
import java.sql.ResultSet;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DIVISA
 */
public class DataModelo extends Modelo{
    private static final Logger LOG = Logger.getLogger(DataModelo.class.getName());
    
    public void guardar(TareasDAO tareas) {
        tareas.setFecha(super.convertDateSQL(tareas.getFecha()));
        int response = super.connect.consulta(tareas.insertSql());
        if(response > 0) 
            JOptionPane.showMessageDialog(null, "Nueva tarea creada correctamente");
    }

    public void actualizar(TareasDAO tareas) {
        tareas.setFecha(super.convertDateSQL(tareas.getFecha()));
        int response = super.connect.consulta(tareas.updateSql()+"id="+tareas.getId());
        if(response > 0) 
            JOptionPane.showMessageDialog(null, "Tarea actualizada correctamente");
    }

    public void mostrar(String id, TareasDAO tareas) {
        ResultSet resultSet = super.connect.obtener(tareas.selectSql("id="+id));
        String[] data = new String[tareas.getColumnas()];
        try{
            resultSet.next();
            for (int i = 0; i < tareas.getColumnas(); i++) {
                data[i] = resultSet.getString(i+1);
            }
        }catch( Exception e){
            LOG.severe(e.getMessage());
        }
        tareas.loadData(data);
        tareas.setFecha(super.revertDateSQL(tareas.getFecha()));
    }

    public void eliminar(String id) {
        TareasDAO tareas = new TareasDAO();
        System.out.println(tareas.deleteSql(id));
        int response = super.connect.consulta(tareas.deleteSql(id));
        if(response > 0) 
            JOptionPane.showMessageDialog(null, "Tarea eliminada correctamente");
    }
    
}
