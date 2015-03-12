/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.comandos;

import modelo.ciclistas_bicicleta.Ciclista;
import modelo.ciclistas_bicicleta.ListaCiclistas;

/**
 * Clase que cambia la cadencia y el tiempo de pedalada
 * Los cambios los realiza de uno en uno para hacerlos correctamente
 * En el caso de superar la cadencia o periodo maximo, se pone todo al maximo (cadencia y duracion de la pedalada)
 * @author Daniel
 */
public class ComandoCambiarCadenciaTiempoPedalada implements InterfazComando{

    private int idCiclista;
            

    private int cadencia;
            
    private double tiempoPedalada;
    
    private ListaCiclistas lista;

    public ComandoCambiarCadenciaTiempoPedalada(int idCiclista, int cadencia, double tiempoPedalada, ListaCiclistas lista) {
        this.idCiclista = idCiclista;
        this.cadencia = cadencia;
        this.tiempoPedalada = tiempoPedalada;
        this.lista = lista;
    }
            
    
    @Override
    public void ejecutarComando() {
        
        Ciclista ciclista = lista.getCiclista(Integer.valueOf(idCiclista) - 1);
      
        ciclista.setCadencia(cadencia);
        
        ciclista.setTiempoDeDuracionDePedalada(tiempoPedalada);
        
        //cambia la cadencia
        if(ciclista.getCadencia() < cadencia){
            
            int var = cadencia - ciclista.getCadencia(); //calcula la variacion de piñones
            
            for(int i = 0; i < var; i++){
                ciclista.aumentarCadencia();
            }
        }
        else if(ciclista.getCadencia() > cadencia){
            
            int var = ciclista.getCadencia() - cadencia;
            
            for(int i = 0; i < var; i++){
                ciclista.disminuirCadencia();
            } 
        }
        
        //cambia el tiempo en el que da la pedalada
        if(ciclista.getTiempoDeDuracionDePedalada() < tiempoPedalada){
            
            double var = tiempoPedalada - ciclista.getTiempoDeDuracionDePedalada(); //calcula la variacion de piñones
            
            for(int i = 0; i < var; i++){
                ciclista.aumentarCadencia();
            }
        }
        else if(ciclista.getTiempoDeDuracionDePedalada() > tiempoPedalada){
            
            double var = ciclista.getTiempoDeDuracionDePedalada() - tiempoPedalada;
            
            for(int i = 0; i < var; i++){
                ciclista.disminuirCadencia();
            } 
        }
    }   
}
