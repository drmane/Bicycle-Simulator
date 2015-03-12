/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.comandos;

import modelo.ciclistas_bicicleta.Bicicleta;
import modelo.ciclistas_bicicleta.ListaCiclistas;

/**
 * InterfazComando que cambia el plato
 * Si se quiere aumentar a uno superior al limite, se aumenta al maximo
 * @author Daniel
 */
public class ComandoCambiaPlato implements InterfazComando{
    
    private String numBici;
    private String nuevoPlato;
    private ListaCiclistas lista;

    /**
     * Constructor del comando
     * @param numBici el numero de la bicicleta a cambiar(numero para los usuarios)
     * @param nuevoPlato el plato a cambiar (plato para los usuarios)
     * @param lista donde se localiza la lista de bicicletas
     */
    public ComandoCambiaPlato(String numBici, String nuevoPlato, ListaCiclistas lista) {
        this.numBici = numBici;
        this.nuevoPlato = nuevoPlato;
        this.lista = lista;
    }

    @Override
    public void ejecutarComando() {
        Bicicleta bicicleta = (lista.getCiclista(Integer.valueOf(numBici) - 1)).getBicicleta();
        
        
        int nuevoPlatoDato = Integer.valueOf(nuevoPlato);
        nuevoPlatoDato--; //pasa al formato del programa
        
        if(bicicleta.getPlatoActual() < nuevoPlatoDato){
            
            int var = nuevoPlatoDato - bicicleta.getPlatoActual(); //calcula la variacion de platos
            
            for(int i = 0; i < var; i++){
                bicicleta.aumentarPlato();
            }
        }
        else if(bicicleta.getPlatoActual() > nuevoPlatoDato){
            
            int var = bicicleta.getPlatoActual() - nuevoPlatoDato;
            
            for(int i = 0; i < var; i++){
                bicicleta.disminuirPlato();
            }
            
        }
    }
}
