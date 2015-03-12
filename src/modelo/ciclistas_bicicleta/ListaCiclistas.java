/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciclistas_bicicleta;

import constantes.Constantes;
import java.util.Vector;
import java.util.Iterator;
import java.util.Observable;
import modelo.Ejecucion;

/**
 * Clase que simula una lista de ciclistas
 * @author Daniel
 */
public class ListaCiclistas extends Observable implements Ejecucion{
    
    private Vector<Ciclista> listaCiclistas;
    private boolean listaFin;

    /**
     * Constructor por defecto
     */
    public ListaCiclistas() {
        listaCiclistas = new Vector();
        listaFin = false;
    }
    
    /**
     * Permite anadir un ciclista a la lista
     * @param ciclista el ciclista que se desea anadir
     */
    public void anadirCiclista(Ciclista ciclista){
        listaCiclistas.add(ciclista);
    }
    
    /**
     * Devuelve el tamano de la lista de los ciclistas
     * @return el numero de ciclistas en la lista
     */
    public int numeroCiclistas(){
        return listaCiclistas.size();
    }

    @Override
    public void ejecutar() {
       Iterator it = listaCiclistas.iterator();
       
       //recorre la lista de los ciclistas y los ejecuta
       while(it.hasNext()){
           ((Ciclista)it.next()).ejecutar();
       }
    }
    
    /**
     * Comprueba si la carrera ha acabado
     * Manda un mensaje al logger
     */
    public void comprobarFinCarrera(){
        int numeroBicicletasAcabadas = 0;

        
        Vector<Ciclista> listaCiclistasVector = listaCiclistas;
        
        Iterator it = listaCiclistasVector.iterator();
        
        while(it.hasNext()){
            Bicicleta bici = ((Ciclista)it.next()).getBicicleta();
            if(bici.isActivo() == false){
                numeroBicicletasAcabadas ++;
            }
        }
        
        if(((numeroBicicletasAcabadas == listaCiclistas.size()) &&(!listaFin))){
            listaFin = true;
            setChanged();
            notifyObservers();
            Constantes.logger.info("La carrera ha finalizado");
        }
    }
    
    /**
     * Permine acceder a un ciclista
     * @param n el ciclista enesimo al que queremos acceder
     * @return el ciclista enesimo
     */
    public Ciclista getCiclista(int n){
        return listaCiclistas.get(n);
    }

    /**
     * Devuelve el vector de los ciclistas
     * @return el vector de los ciclistas
     */
    public Vector<Ciclista> getListaCiclistasEstructura() {
        return listaCiclistas;
    }  
    
    /**
     * Devuelve el nombre del ciclista enesimo
     * @param n el ciclista enesimo
     * @return la cadena de caracteres con el nombre del ciclista
     */
    public char[] infoCiclista(int n){
        String palabra = "Ciclista " + String.valueOf(n + 1);

        return palabra.toCharArray();
    }

    public boolean isListaFin() {
        return listaFin;
    }

    public void setListaFin(boolean listaFin) {
        this.listaFin = listaFin;
    }
}
