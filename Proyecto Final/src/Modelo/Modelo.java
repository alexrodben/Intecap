/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import Modelo.DAO.UsuariosRolesDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIVISA
 */
public class Modelo {
    private static final Logger LOG = Logger.getLogger(Modelo.class.getName());
    
    protected Connect connect = new Connect();
    protected UsuariosRolesDAO usuariosRoles;
    protected UsuariosDAO usuarios;
    protected TareasDAO tareas;
    
   public void loadTable(final String sqlString, JTable jTable, boolean editable){
       try{
            DefaultTableModel defaultTableModel = new DefaultTableModel(){
               @Override public boolean isCellEditable(int rowIndex, int columnIndex) { return editable;}
             };
            System.out.println(sqlString);
            ResultSet resultSet = connect.obtener(sqlString);
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            Object[] etiquetas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++)
                etiquetas[i] = metaDatos.getColumnLabel(i+1).toUpperCase();           
            defaultTableModel.setColumnIdentifiers(etiquetas);            
            if(resultSet != null)
                while(resultSet.next()){
                    Object [] fila = new Object[numeroColumnas];
                    for (int i=0; i < numeroColumnas; i++)
                        fila[i] = resultSet.getObject(i+1); 
                    defaultTableModel.addRow(fila);
                }
            jTable.setModel(defaultTableModel);
        }catch(SQLException e){
            LOG.severe(e.getMessage());
        }
    }
    
    
}
