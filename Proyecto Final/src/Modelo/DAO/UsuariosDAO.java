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
public class UsuariosDAO implements DAO{
    private String tabla = "tbl_usuarios";
    private String id,roles_id,username,password,intentos, nombre;

    public UsuariosDAO(String id, String roles_id, String username, String password, String intentos, String nombre) {
        this.id = id;
        this.roles_id = roles_id;
        this.username = username;
        this.password = password;
        this.intentos = intentos;
        this.nombre = nombre;
    }

    public UsuariosDAO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(String roles_id) {
        this.roles_id = roles_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", roles_id=" + roles_id + ", username=" + username + ", password=" + password + ", intentos=" + intentos + ", nombre=" + nombre + '}';
    }

    @Override
    public String insertSql() {
        return "INSERT INTO " + tabla + " (id, roles_id, username, password, intentos, nombre) VALUES (" + id + ", '" + roles_id + "', '" + username + "', '" + password + "', '" + intentos + "', '" + nombre + "')";
    }

    @Override
    public String updateSql() {
        return "UPDATE " + tabla + " SET id='" + id + "', roles_id='" + roles_id + "', username='" + username + "', password='" + password + "', intentos='" + intentos + "', nombre='" + nombre + "' WHERE";
    }

    @Override
    public void loadData(String[] data) {
        int i = 0;
        this.id = data[i]; i++;
        this.roles_id = data[i]; i++;
        this.username = data[i]; i++;
        this.password = data[i]; i++;
        this.intentos = data[i]; i++;
        this.nombre = data[i]; i++;
    }
    
    @Override
    public int getColumnas(){
        return 6;
    }
    
    @Override
    public String selectSql(String condicion) {
        if(condicion == null) return "SELECT * FROM " + tabla;
        else return "SELECT * FROM " + tabla + " WHERE " + condicion;
    }

}
