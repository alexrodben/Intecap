/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JRoque
 */
public class Connect{
    private Logger logger = Logger.getLogger(getClass().getName()); 
    private final String driver = "com.mysql.jdbc.Driver";
    private Connection connection;
    private Statement statement;
    private String url, ipserver, database, username, password, error;
    public boolean check = false;

    //Constructor para local
    public Connect(){
        this.ipserver = "127.0.0.1";
        this.database = "db_tareas";
        this.username = "root";
        this.password = "";
        connect();
    }
    
    //Constructos para archivos
    public Connect(String ipserver, String database, String username, String password){
        this.ipserver = ipserver;
        this.database = database;
        this.username = username;
        this.password = password;
        connect();
    }
   
    //----------------------Metodo que habilita la conexion con la base de datos
    private void connect(){
        url = "jdbc:mysql://" +  ipserver + "/" + database;
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, username, password);
            check = true;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            logger.severe(e.getMessage());
            check = false;
        }
    }

    //----------------------Desconectar de la Base de Datos
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    //----------------------Metodo para Obtener los datos de la Base de Datos
    public ResultSet obtener (String sql){
        try {
            disconnect();
            connect();
            statement = connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(sql);
            statement = null;
            return resultSet;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            error = e.getMessage();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    //----------------------Metodos para consultas a la Base de Datos ( Insertar Borrar Modificar)
    public int consulta (String sql){
        System.out.println(sql);
        int resultado = 0;
        try {
            connect();
            statement = connection.createStatement();
            resultado = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                resultado = rs.getInt(1);
            }
            disconnect();
            return resultado;
        } catch (SQLException e) {
            logger.severe(e.getMessage());
            error = e.getMessage();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
    public String getError(){
        return error;
    }
    
}
