/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import Modelo.DataModelo;
import Vista.DataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author DIVISA
 */
public class DataControlador extends Controlador implements ActionListener{
    private final DataModelo modelo = new DataModelo();
    private JButton guardar, cancelar;
    private JFormattedTextField fecha;
    private JTextArea descripcion;
    private JTextField titulo;
    private DataView vista;
    private boolean modo;
            
    //Constructore de insertar
    public DataControlador(DataView view, JTable jTable, UsuariosDAO usuario) {
        modo = true;
        vista = view;
        this.jTable = jTable;
        this.usuario = usuario;
        this.initComponents();
    }

    //Constructor de editar
    public DataControlador(DataView view, JTable jTable, UsuariosDAO usuario, String id) {
        modo = false;
        vista = view;
        this.jTable = jTable;
        this.usuario = usuario;
        this.initComponents();
        edit(id);
    }

    //Constructor de mostrar
    public DataControlador(DataView view, String id) {
        vista = view;
        this.initComponents();
        edit(id);
        fecha.setEditable(false);
        guardar.setVisible(false);
        titulo.setEditable(false);
        descripcion.setEditable(false);
    }

    //Constructor de elimnar
    public DataControlador(JTable jTable, String id, UsuariosDAO usuario) {
        this.usuario = usuario;
        this.jTable = jTable;
        modelo.eliminar(id);
        super.getTabla();
    }
    
    public void initComponents(){
        titulo = vista.jTextField;
        descripcion = vista.jTextArea;
        guardar = vista.jButtonGuardar;
        cancelar = vista.jButtonCancelar;
        fecha = vista.jFormattedTextField;
        cancelar.addActionListener(this);
        guardar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == guardar) guardar();
        if(actionEvent.getSource() == cancelar) vista.setVisible(false);
    }
    
    private void guardar(){
        if(fecha.getText().isEmpty() && titulo.getText().isEmpty() && descripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(vista, "Rellene todos los datos");
        }else{
            if(modo){
                modelo.guardar(new TareasDAO(null, titulo.getText(), descripcion.getText(), fecha.getText(), usuario.getId(), "1"));
            }else{
                tareas.setFecha(fecha.getText());
                tareas.setTitulo(titulo.getText());
                tareas.setDescripcion(descripcion.getText());
                modelo.actualizar(tareas);
            }
            super.getTabla();
            fecha.setText("");
            titulo.setText("");
            descripcion.setText("");
            vista.setVisible(false);
        }
    }
    
    private void edit(String id){
        modelo.mostrar(id, tareas);
        fecha.setText(tareas.getFecha());
        titulo.setText(tareas.getTitulo());
        descripcion.setText(tareas.getDescripcion());
    }
            
}
