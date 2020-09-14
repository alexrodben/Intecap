/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.TareasDAO;
import Modelo.DAO.UsuariosDAO;
import Vista.InicioVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author DIVISA
 */
public class InicioControlador extends Controlador implements ActionListener, MouseListener{
    private static final Logger LOG = Logger.getLogger(InicioControlador.class.getName());
    
    private final UsuariosDAO usuario;
    private final TareasDAO tareas;
    private final InicioVista vista;
    private JTable jTable;
    private JLabel jLabel;
    private JButton agregar, editar, eliminar, limpiar, buscar;
    private int fila;
    private String id, sql;

    public InicioControlador(InicioVista vista, UsuariosDAO usuario) {
        this.usuario = usuario;
        this.tareas = new TareasDAO();
        this.vista = vista;
        jTable = vista.jTable;
        jLabel = vista.jLabelTitulo;
        agregar = vista.jButtonAgregar;
        buscar = vista.jButtonBuscar;
        eliminar = vista.jButtonEliminar;
        editar = vista.jButtonModificar;
        limpiar = vista.jButtonLimpiar;
        //Listener
        buscar.addActionListener(this);
        editar.addActionListener(this);
        limpiar.addActionListener(this);
        agregar.addActionListener(this);
        eliminar.addActionListener(this);
        jTable.addMouseListener(this);
        getTabla();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == buscar) buscar();
        if(ae.getSource() == editar) editar();
        if(ae.getSource() == limpiar) limpiar();
        if(ae.getSource() == agregar) agregar();
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

    private void buscar() {
    }

    private void editar() {

    }

    private void limpiar() {

    }

    private void agregar() {

    }

    private void mostrar() {

    }
    
    private void getTabla(){
        sql = tareas.selectSql("usuario_id="+usuario.getId());
        condicional();
        sql += " ORDER BY id DESC";
        super.loadDataTable(sql, jTable);
        super.anchoColumnaJTable(jTable, new int[][] { {3,150}});
        super.quitarColumnaJTable(jTable, new int[] {5,4,0});
    }    
    
    private boolean condicional(){
/*        if(!busqueda.isEmpty()){
            sql += " WHERE " + columna + " LIKE '%"+busqueda+"%'";
            System.out.println(sql);
            return true;
        }*/
        return false;
    }
    
    
    
}
