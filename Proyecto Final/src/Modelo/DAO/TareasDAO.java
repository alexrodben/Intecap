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
public class TareasDAO implements DAO{
    private final String tabla = "tbl_tareas";
    private String id,nombre,descripcion,fecha,usuario_id,estado_id;

    public TareasDAO(String id, String nombre, String descripcion, String fecha, String usuario_id, String estado_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario_id = usuario_id;
        this.estado_id = estado_id;
    }

    public TareasDAO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(String estado_id) {
        this.estado_id = estado_id;
    }

    @Override
    public String toString() {
        return "Tareas{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", usuario_id=" + usuario_id + ", estado_id=" + estado_id + '}';
    }
    
    @Override
    public String insertSql(){
        return "INSERT INTO " + tabla + " (id, nombre, descripcion, fecha, usuario_id, estado_id) VALUES (" + id + ", '" + nombre + "', '" + descripcion + "', '" + fecha + "', '" + usuario_id + "', '" + estado_id + "')";
    }
    
    @Override
    public String updateSql(){
        return "UPDATE INTO " + tabla + " SET id=" + id + ", nombre='" + nombre + "', descripcion='" + descripcion + "', fecha='" + fecha + "', usuario_id='" + usuario_id + "', estado_id='" + estado_id + "' WHERE ";

    }

    @Override
    public void loadData(String[] data) {
        int i = 0;
        this.id = data[i]; i++;
        this.nombre = data[i]; i++;
        this.descripcion = data[i]; i++;
        this.fecha = data[i]; i++;
        this.usuario_id = data[i]; i++;
        this.estado_id = data[i]; i++;
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
