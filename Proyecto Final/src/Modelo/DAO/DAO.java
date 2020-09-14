/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

/**
 *
 * @author DIVISA
 */
public interface DAO {
    public String insertSql();
    public String updateSql();
    public String toString();
    public String selectSql(String condicion);
    public int getColumnas();
    public void loadData(String[] data);
}
