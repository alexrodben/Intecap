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
public class UsuariosRoles implements DAO{
    private final String tabla = "tbl_uuarios_roles";
    private String id,descripcion,atributos;

    public UsuariosRoles(String id, String descripcion, String atributos) {
        this.id = id;
        this.descripcion = descripcion;
        this.atributos = atributos;
    }

    public UsuariosRoles() {
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

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "UsuariosRoles{" + "id=" + id + ", descripcion=" + descripcion + ", atributos=" + atributos + '}';
    }

    @Override
    public String insertSql() {
        return "INSERT INTO " + tabla + " (id, descripcion, atributos) VALUES (" + id + ", '" + descripcion + "', '" + atributos + "')";
    }

    @Override
    public String updateSql() {
        return "UPDATE " + tabla + " SET id=" + id + ", descripcion='" + descripcion + "', atributos='" + atributos + "' WHERE";
    }

    @Override
    public int getColumnas() {
        return 3;
    }

    @Override
    public void loadData(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
