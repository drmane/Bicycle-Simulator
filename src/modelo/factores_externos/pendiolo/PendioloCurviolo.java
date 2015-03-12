/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

import controlador.Loader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Daniel
 */
public class PendioloCurviolo extends Pendiolo {
    
    Map<Double, Double> mapaCurvas;

    //punto kilometrico, velocidad maxima
    
    /**
     * Constructor por defecto de la clase
     */
    public PendioloCurviolo() {
        super();
        mapaCurvas = new TreeMap<Double, Double>();
        inicializarCurvas();
    } 
    

    /**
     * Permite inicializarPendiente el mapa de las curvas
     */
    private void inicializarCurvas() {
        Loader entrada = new Loader("pendiente.txt");

        String id;
        
        String posicion;
        String velocidadMax;

        double pendienteAux;

        String archivo = entrada.leerArchivo();

        StringTokenizer archivoAux = new StringTokenizer(archivo, " \n \t \r \f ");

        while (archivoAux.hasMoreTokens()) {
            //mira el id
            id = archivoAux.nextToken();
            
           if(id.equals("Curva")){
                //mira la posicion
                posicion = archivoAux.nextToken();
                
                //mira la velocidad maxima de la curva
                velocidadMax = archivoAux.nextToken();
                
                mapaCurvas.put(Double.valueOf(posicion), Double.valueOf(velocidadMax));
            }
        }     
        entrada.cerrarLoader();
    }

    public Map<Double, Double> getMapaCurvas() {
        return mapaCurvas;
    }
    
    /**
     * Permite acceder a la velocidad limite de la curva muy proxima a esa posicion
     * @param posicion la posicion que se quiere saber la velocidad de la curva mas proxima
     * @return la velocidad de la curva mas proxima, -1 si no hay una curva proxima
     */
    public double comprobarCurva(double posicion){
        double velocidadCurvaBuscada = -1;
        boolean curvaEncontrada = false;

        //consigo un set de posiciones
        Set keys = mapaCurvas.keySet();

        Iterator i = keys.iterator(); 
        //recorro el mapa
        while((i.hasNext()&&(!curvaEncontrada))) {
            double key = (double) i.next(); //cojo la clave

            if (posicion >= key * 1000) //si hemos cruzado la curva
            {
                //miramos si la diferencia entre donde esta la bici y donde esta la curva es pequeña
                //asi la consideramos esa curva
                double variacion = posicion - (key * 1000);
                
                //aproximacion para saber cual es la curva mas cercana    
                if(variacion  < 500){
                    velocidadCurvaBuscada = (double) mapaCurvas.get(key); 
                    curvaEncontrada = true;
                }
            }
        }
        
        return velocidadCurvaBuscada;
    }
}
