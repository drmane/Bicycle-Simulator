/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Tiempo;

import constantes.Constantes;
import modelo.Ejecucion;

/**
 *
 * @author usuario_local
 */
public class RelojAplicacion extends Reloj implements Ejecucion {
    private static int relacionIteracionSegundo;
    
    //variable estatica que permite cambiar la relacion impulsosegundo en tiempo de ejecucion

    private int ContadorDuracionDeIteracion;

    public int getContadorDuracionDeIteracion() {
        return ContadorDuracionDeIteracion;
    }

    public void setContadorDuracionDeIteracion(int ContadorDuracionDeIteracion) {
        this.ContadorDuracionDeIteracion = ContadorDuracionDeIteracion;
    }

    /**
     * Constructor por defecto
     */
    public RelojAplicacion() {
        super();
        this.relacionIteracionSegundo = 1000;
        this.ContadorDuracionDeIteracion = Constantes.tiempoDeIteracion;
    }

    /**
     * Constructor generador
     *
     * @param segundos los segundos 
     * @param minutos los minutos
     * @param horas las horas
     */
    public RelojAplicacion(int segundos, int minutos, int horas) {
        super(segundos, minutos, horas);
        
    }
    
    /**
     * Permite acceder de manera estatica a la relacion impulso/ segundo
     * @return 
     */
    public static int getrelacionIteracionSegundo() {
        return relacionIteracionSegundo;
    }

    public void setrelacionIteracionSegundo(int periodoImpulsos) {
        RelojAplicacion.relacionIteracionSegundo = periodoImpulsos;
    }

    @Override
    public void ejecutar() { 

        //Cuando hayan pasado las itereaciones necesarias para llegar el tiempo de iteracion, se realiza 1 seg de reloj
        if (ContadorDuracionDeIteracion == 0) {
            tick(); //en cada ejecucion hara un tick del reloj real
            ContadorDuracionDeIteracion = Constantes.tiempoDeIteracion;

            
        } else {
            setTickProducido(false); //para indicar de algun modo que no se ha producido un tick
            ContadorDuracionDeIteracion-- ;
        }
    }
}
