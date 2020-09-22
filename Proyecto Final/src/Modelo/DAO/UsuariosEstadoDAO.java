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
public class UsuariosEstadoDAO implements DAO{
    private final String tabla = "tbl_uuarios_roles";
    private String id,descripcion;

    public UsuariosEstadoDAO(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public UsuariosEstadoDAO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UsuariosRoles{" + "id=" + id + ", descripcion=" + descripcion + ", =" + '}';
    }

    @Override
    public String insertSql() {
        return "INSERT INTO " + tabla + " (id, descripcion) VALUES (" + id + ", '" + descripcion + "')";
    }

    @Override
    public String updateSql() {
        return "UPDATE " + tabla + " SET id=" + id + ", descripcion='" + descripcion + "' WHERE";
    }

    @Override
    public int getColumnas() {
        return 2;
    }

    @Override
    public void loadData(String[] data) {
        int i = 0;
        this.id = data[i]; i++;
        this.descripcion = data[i]; i++;
    }

    @Override
    public String selectSql(String condicion) {
        if(condicion == null) return "SELECT * FROM " + tabla;
        else return "SELECT * FROM " + tabla + " WHERE " + condicion;
    }
    
    @Override
    public String deleteSql(String id) {
        return "DELETE FROM " + tabla + " WHERE id=" + id;
    }
}
