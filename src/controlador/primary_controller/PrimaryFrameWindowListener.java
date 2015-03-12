/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.primary_controller;

import controlador.InterfazControlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.Modelo;
import vista.ventanas.PrimaryFrame;
import vista.ventanas.ViewInterface;

/**
 * Clase que implementa el cerrado de la aplicacion
 * Hereda de window adapter ya que aparecen en esa clase las operaciones por defecto del WindowListener
 * al cerrar la aplicación
 * @author Daniel
 */
public  class PrimaryFrameWindowListener extends WindowAdapter implements  InterfazControlador {

    
    private Modelo modelo; //la residencia de estudiantes
    private PrimaryFrame primaryFrame;

    
    /**
     * Listener de la ventana principal de la aplicacion.
     * Pone inactivo al modelo para que se acabe la ejecucion de la aplicacion
     * @param e el evento producido al cerrar la ventana
     */
    @Override
    public void windowClosing(WindowEvent e) {
       modelo.setActivo(false);
    }

    /**
     * Permite añadir la vista al controlador
     * @param v la vista que se desea añadir
     */
    @Override
    public void addView(ViewInterface v) {
       primaryFrame = (PrimaryFrame)v;
    }

    /**
     * Permite añadir el modelo al controlador
     * @param m el modelo que se desea añadir
     */
    @Override
    public void addModel(Modelo m) {
        modelo = m;
    }

    /**
     * Permite inicializar la vista
     * Actualmente esta operacion no esta soportada
     */
    @Override
    public void initView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
