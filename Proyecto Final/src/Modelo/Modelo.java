/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import Modelo.DAO.UsuariosEstadoDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIVISA
 */
public class Modelo {
    private static final Logger LOG = Logger.getLogger(Modelo.class.getName());
    
//    protected Connect connect = new Connect();
    protected Connect connect = new Connect("108.167.143.239", "divisagt_tareas", "divisagt_root", "@Programador98");
    protected UsuariosEstadoDAO usuariosRoles;
    protected UsuariosDAO usuarios;
    protected TareasDAO tareas;
    
   public void loadTable(final String sqlString, JTable jTable, boolean editable){
       try{
            DefaultTableModel defaultTableModel = new DefaultTableModel(){
               @Override public boolean isCellEditable(int rowIndex, int columnIndex) { return editable;}
             };
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
   
    public String convertDateSQL(String oldDate){
        try {
            SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {date = parseador.parse(oldDate);}
            catch(ParseException e) {
                LOG.severe("error en fecha"+e.getMessage());}
            return formateador.format(date);
        } catch (Exception e) {
            LOG.severe(e.getMessage());
            return "";
        }
    }
   
    public String revertDateSQL(String oldDate){
        try {
            SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
            Date date = null;
            try {date = parseador.parse(oldDate);}
            catch(ParseException e) {System.err.println("error en fecha"+e.getMessage());}
            return formateador.format(date);
        } catch (Exception e) {
            LOG.severe(e.getMessage());
            return "";
        }
    }
    
}
