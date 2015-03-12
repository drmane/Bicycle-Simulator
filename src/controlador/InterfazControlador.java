/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Modelo;
import vista.ventanas.ViewInterface;

/**
 * El interfaz de deben implementar todas las clases que sean controladores.
 * @author Daniel
 */
public interface InterfazControlador {
    
    /**
     * Permite añadir una referencia de la vista al controlador
     * @param v la vista que se desea añadir
     */
    public void addView(ViewInterface v);
    
    /**
     * Permite añadir una referencia del modelo al controlador
     * @param m el modelo que se desea añadir
     */
    public void addModel(Modelo m);
    
    /**
     * Permite inicializar la vista
     */
    public void initView();
}
