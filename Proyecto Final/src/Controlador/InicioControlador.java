/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import Vista.DataView;
import Vista.InicioVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author DIVISA
 */
public class InicioControlador extends Controlador implements ActionListener, MouseListener{
    private static final Logger LOG = Logger.getLogger(InicioControlador.class.getName());
    private final InicioVista vista;
    private final JLabel jLabel;
    private final JButton agregar, editar, eliminar;
    private int fila;
    private String id, sql;

    public InicioControlador(InicioVista vista, UsuariosDAO usuario) {
        this.usuario = usuario;
        this.tareas = new TareasDAO();
        this.vista = vista;
        jTable = vista.jTable;
        jLabel = vista.jLabelTitulo;
        agregar = vista.jButtonAgregar;
        eliminar = vista.jButtonEliminar;
        editar = vista.jButtonModificar;
        //Listener
        editar.addActionListener(this);
        agregar.addActionListener(this);
        eliminar.addActionListener(this);
        jTable.addMouseListener(this);
        jLabel.setText("TAREAS DE: " + usuario.getNombre().toUpperCase());
        super.getTabla();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == editar) editar();
        if(ae.getSource() == agregar) agregar();
        if(ae.getSource() == eliminar) eliminar();
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        JTable table = (JTable) me.getSource();
        TableModel tableModel = jTable.getModel();
        fila = table.rowAtPoint(me.getPoint());
        id = tableModel.getValueAt(fila, 0).toString();
        eliminar.setEnabled(true);
        editar.setEnabled(true);
        if (me.getClickCount() == 2) {
            mostrar();
        }
    }
    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}

    private void editar() {
        DataView view = new DataView(vista);
        DataControlador c = new DataControlador(view, jTable, usuario, id);
        view.setVisible(true);
        view = null;
        c = null;
    }

    private void eliminar() {
        int respuesta = JOptionPane.showConfirmDialog(vista,"¿Desea Eliminar la tarea?");  
        if(respuesta ==JOptionPane.YES_OPTION){  
            DataControlador c = new DataControlador(jTable, id, usuario);
            c = null;
        }  
    }
    
    private void agregar() {
        DataView view = new DataView(vista);
        DataControlador c = new DataControlador(view, jTable, usuario);
        view.setVisible(true);
        view = null;
        c = null;
    }

    private void mostrar() {
        DataView view = new DataView(vista);
        DataControlador c = new DataControlador(view, id);
        view.setVisible(true);
        view = null;
        c = null;
    }
    
}
