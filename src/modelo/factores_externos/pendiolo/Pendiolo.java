/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

import constantes.Constantes;
import controlador.Loader;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.TreeMap;
import java.util.StringTokenizer;

/**
 * Clase que simula un mapa con una serie de posiciones y pendiente *Nota: cada
 * bicicleta se gestiona su pendiente
 *
 * @author usuario_local
 */
public class Pendiolo extends Observable {

    Map<Double, Double> mapaPendiente;
    //punto kilometrico, inclinacion
    
    
    /**
     * Constructor por defecto de pendiolo
     */
    public Pendiolo() {
        mapaPendiente = new TreeMap<Double, Double>();
        inicializarPendiente();
    }
    
    /**
     * Calcula la inclinacion producida por la pendiente en un punto
     * @param recorrido la posicion de la entidad que esta en ese punto del mapa
     * @return la aceleracion producida por la pendiente
     */
    private double calcularInclinacionPendiente(double recorrido) {

        double pendienteBuscada = 0;

        //consigo un set de posiciones
        Set keys = mapaPendiente.keySet();

        Iterator i = keys.iterator(); 
        //recorro el mapa
        while(i.hasNext()) {
            double key = (double) i.next(); //cojo la clave

            if (key * 1000 <= recorrido) //si la clave es menor que la posicion, la pendiente es esa
            {
                pendienteBuscada = (double) mapaPendiente.get(key); 
            }
        }

        return pendienteBuscada;

    }

    /**
     * Calcula la aceleracion en funcion del punto kilometrico de la bici
     *
     * @param puntoKilometrico el punto kilometrico
     * @return la aceleracion correspondiente en metros / segundo
     */
    public double getAceleracionPendiente(double puntoKilometrico) {

        double pendiente = calcularInclinacionPendiente(puntoKilometrico); //consigo la pendiente 

        //lo de 100, no lo pone el profesor, pero sino es una bicicleta irreal
        return (double) (pendiente * Constantes.gravedad)/ (100*1000);  //calculo la aceleracion
    }
    
    /**
     * Devuelve la pendiente de la entidad que trabaja con pendiolo
     * @param recorrido la posicion de la entidad (bicicleta)
     * @return el valor de la pendiente
     */
    public double getPendiente(double recorrido){
        return calcularInclinacionPendiente(recorrido); //consigo la pendiente 
    }

    /**
     * Devuelve el sentido de la pendiente
     *
     * @param pendiente el valor numerico de la pendiente
     * @return el sentido de la pendiente asociado al valor numerico
     */
    public SentidoPendiente getSentido(double pendiente) {
        return SentidoPendiente.calcularEnum(pendiente);
    }

    /**
     * Inicializa los valores de la pendiente desde archivo de texto
     */
    private void inicializarPendiente() {
        Loader entrada = new Loader("pendiente.txt");

        String id;
        String posicion;
        String pendiente;
        String sentido;

        double pendienteAux;

        String archivo = entrada.leerArchivo();

        StringTokenizer archivoAux = new StringTokenizer(archivo, " \n \t \r \f ");

        while (archivoAux.hasMoreTokens()) {
            //mira el id
            id = archivoAux.nextToken();

             if(id.equals("Pendiente")){ //si es pendiolo
                //mira la posicion
                posicion = archivoAux.nextToken();

                //mira el valor de la pendiente
                pendiente = archivoAux.nextToken();

                //mira el sentido de la pendiente
                sentido = archivoAux.nextToken();

                //calcula la pendiente como numero         
                pendienteAux = Double.valueOf(pendiente) * SentidoPendiente.valueOf(sentido).getFactor();
                
                            //lo mete en el mapa
                mapaPendiente.put(Double.valueOf(posicion).doubleValue(), pendienteAux);
             }
        }
        
        entrada.cerrarLoader();
    }

    public Map<Double, Double> getMapaPendiente() {
        return mapaPendiente;
    }

    public void setMapaPendiente(Map<Double, Double> mapaPendiente) {
        this.mapaPendiente = mapaPendiente;
    }
}
