/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.comandos;

import modelo.ciclistas_bicicleta.Bicicleta;
import modelo.ciclistas_bicicleta.ListaCiclistas;

/**
 * InterfazComando que cambia el pinon
 * Si se quiere aumentar a uno superior al limite, se aumenta al maximo
 * @author Daniel
 */
public class ComandoCambiaPinon implements InterfazComando{
    
    private String numBici;
    private String nuevoPinon;
    private ListaCiclistas lista;

    /**
     * Constructor del comando
     * @param numBici el numero de la bicicleta a cambiar(numero para los usuarios)
     * @param nuevoPinon el pinon a cambiar (plato para los usuarios)
     * @param lista donde se localiza la lista de bicicletas
     */
    public ComandoCambiaPinon(String numBici, String nuevoPinon, ListaCiclistas lista) {
        this.numBici = numBici;
        this.nuevoPinon = nuevoPinon;
        this.lista = lista;
    }

    @Override
    public void ejecutarComando() {
        Bicicleta bicicleta = (lista.getCiclista(Integer.valueOf(numBici) - 1)).getBicicleta();
        
        
        int nuevoPinonDato = Integer.valueOf(nuevoPinon);
        nuevoPinonDato--; //pasa al formato del programa
        
        if(bicicleta.getPinonActual() < nuevoPinonDato){
            
            int var = nuevoPinonDato - bicicleta.getPinonActual(); //calcula la variacion de pinones
            
            for(int i = 0; i < var; i++){
                bicicleta.aumentarPinon();
            }
        }
        else if(bicicleta.getPinonActual() > nuevoPinonDato){
            
            int var = bicicleta.getPinonActual() - nuevoPinonDato;
            
            for(int i = 0; i < var; i++){
                bicicleta.disminuirPinon();
            } 
        }
    }  
}
