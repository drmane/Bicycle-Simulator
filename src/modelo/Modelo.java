/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.ciclistas_bicicleta.ListaCiclistas;
import modelo.ciclistas_bicicleta.Ciclista;
import modelo.ciclistas_bicicleta.Bicicleta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import modelo.factores_externos.eolo.Eolo;
import modelo.factores_externos.pendiolo.PendioloCurviolo;
import modelo.Tiempo.RelojAplicacion;
import modelo.Tiempo.RelojSistema;

/**
 * Una clase que agrupa todas nuestras clases de este modelo (para poder usar
 * correctamente MVC)
 *
 * @author Daniel
 */
public class Modelo extends Observable implements Ejecucion {
    
    boolean activo;
  

    private ArrayList<Ejecucion> listaEjecutable;
    
    private PendioloCurviolo pendiolo;
    private Eolo eolo;
    ListaCiclistas listaCiclistas;
    private RelojAplicacion reloj;
    private RelojSistema relojSistema;

    /**
     * Constructor por defecto del modelo
     */
    public Modelo() {
        activo = true;
        
        listaEjecutable = new ArrayList();
        
        pendiolo = new PendioloCurviolo();
        reloj = new RelojAplicacion();
        eolo = new Eolo(reloj);
        
        relojSistema = new RelojSistema();
        
        listaCiclistas = new ListaCiclistas();
    }

    public PendioloCurviolo getPendiolo() {
        return pendiolo;
    }

    public void setPendiolo(PendioloCurviolo pendiolo) {
        this.pendiolo = pendiolo;
    }

    public Eolo getEolo() {
        return eolo;
    }

    public void setEolo(Eolo eolo) {
        this.eolo = eolo;
    }

    public ListaCiclistas getListaCiclistas() {
        return listaCiclistas;
    }

    public void setListaCiclistas(ListaCiclistas listaCiclistas) {
        this.listaCiclistas = listaCiclistas;
    }

    public RelojAplicacion getReloj() {
        return reloj;
    }

    public void setReloj(RelojAplicacion reloj) {
        this.reloj = reloj;
    }

    public RelojSistema getRelojSistema() {
        return relojSistema;
    }

    public void setRelojSistema(RelojSistema relojSistema) {
        this.relojSistema = relojSistema;
    }
    
    

    @Override
    public void ejecutar() {
        
        inicializarListaEjecucion();
        
        Iterator it = listaEjecutable.iterator();
        
        //primera ejecucion
        while(it.hasNext()){ //ejecuta todos los que tienen que ejecutarse por primera vez
            ((Ejecucion)it.next()).ejecutar();
        }
        
        new Thread(relojSistema).start(); //ejecuta el reloj del sistema
        //esta en un Thread para no bloquear la ejecucion normal de la aplicacion

        this.setChanged(); //poner este metodo donde se produzcan cambios 
        notifyObservers(); //notifica a los observadores sobre los cambios del observable

        //notificara a la vista que ya se puede mostrar

        while (activo) {
           //los que se van a ejecutar(del modelo) van aqui
            Iterator itLoop = listaEjecutable.iterator();
            
            while(itLoop.hasNext()){ //ejecuta todos los que tienen que ejecutarse por primera vez
                ((Ejecucion)itLoop.next()).ejecutar();
            }
            
            if(!listaCiclistas.isListaFin())
                listaCiclistas.comprobarFinCarrera();
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /**
     * Permite anadir n ciclistas a la aplicacion
     * @param n los n ciclistas a anadir
     */
    public void inicializarCiclistas(int n){
        for(int i = 0; i < n; i++){
            listaCiclistas.anadirCiclista( new Ciclista(new Bicicleta(eolo, pendiolo))); 
        }   
    }
    
    /**
     * Inicializa la lista de objetos ejecutables
     */
    public void inicializarListaEjecucion(){
        listaEjecutable.add(eolo);
        listaEjecutable.add(reloj);
        listaEjecutable.add(listaCiclistas);
    }
}
