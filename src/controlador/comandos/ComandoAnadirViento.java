/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.comandos;

import modelo.factores_externos.eolo.Eolo;
import modelo.Modelo;

/**
 *
 * @author Daniel
 */
public class ComandoAnadirViento implements InterfazComando {
    
    private String hora;

    private String sentido;

    private double velocidad;
    
    Eolo eolo;

    /**
     * Constructor del comando
     * @param hora la hora a la que se ejecutara el viento
     * @param sentido el sentido del viento
     * @param velocidad la velocidad del viento
     * @param eolo el modelo donde se ubica el viento
     */
    public ComandoAnadirViento(String hora, String sentido, double velocidad, Eolo eolo) {
        this.hora = hora;
        this.sentido = sentido;
        this.velocidad = velocidad;
        this.eolo = eolo;
    }
    
    @Override
    public void ejecutarComando() {
        eolo.anadirViento(hora, sentido, velocidad);
    } 
}
