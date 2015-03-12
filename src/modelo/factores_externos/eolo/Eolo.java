/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.eolo;

import constantes.Constantes;
import controlador.Loader;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.StringTokenizer;
import modelo.Ejecucion;
import modelo.Tiempo.Reloj;

/**
 * Clase que simula el viento
 * @author usuario_local
 */
public class Eolo extends Observable implements Ejecucion {
    
    private Map<String,Double> mapaVientoVelocidad;
    //formato hora HH:MM:SS 
    //velocidad del viento
    
    private Map<String,SentidoViento> mapaVientoSentido;
    //formato hora HH:MM:SS 
    //sentido del viento
    
    Reloj reloj;
    
    //sentido actual
    private SentidoViento sentido;
    
    //velocidad actual
    private double velocidad;

    /**
     * Constructor por defecto
     */
    public Eolo(Reloj reloj) {
        
        this.reloj = reloj;
        
        mapaVientoVelocidad = new HashMap<String,Double>();
        mapaVientoSentido = new HashMap<String,SentidoViento>();
                
        inicializar();
    }

    public void setSentido(SentidoViento sentido) {
        this.sentido = sentido;
    }

    public void setVelocidadViento(double velocidad) {
        this.velocidad = velocidad;
    }

    public SentidoViento getSentido() {
        return sentido;
    }

    public double getVelocidadViento() {
        return velocidad;
    }
    
     /**
     * Permite anadir una hora de cambio de viento
     * Si se anade en una hora anterior a la que se esta, se anade pero nunca se ejecutara
     * Si existe esa hora, se sobreescribira
     * @param hora la hora a la que se desea que cambi el viento
     * @param sentido el sentido de la velocidad del viento que se desea anadir
     * @param velocidad la velocidad que llevara ese viento
     */
    public void anadirViento(String hora, String sentido, double velocidad){
         mapaVientoVelocidad.put(hora, Double.valueOf(velocidad)); //mete el valor de la velocidad
        mapaVientoSentido.put(hora, SentidoViento.valueOf(sentido)); //mete el valor del sentido
        
    }
    
    /**
     * Permite acceder a la aceleracion del viento en un instante de tiempo
     * @return la aceleracion del viento en ese instante en metros / segundos
     */
    public double getAceleracionViento(){
        
        double aceleracionAux = 0;
        
        if(mapaVientoVelocidad.containsKey(reloj.toString()))
        { 
            //actualiza la velocidad del vieno
            setVelocidadViento(mapaVientoVelocidad.get(reloj.toString()));
            
            //actualiza el sentido del viento
            setSentido(mapaVientoSentido.get(reloj.toString()));
            
            //calcula la aceleracion
            aceleracionAux = calcularAceleracionViento();
        }
        
        return aceleracionAux;
    }
    
    /**
     * Calcula la aceleracion del viento y la conviete en m/s
     * @return la aceleracion calculada
     */
    private double calcularAceleracionViento() {
        double B;
        
        B = Math.pow(getVelocidadViento() / Constantes.constanteViento, 3/2);
        
        B *= sentido.getFactor(); //pone el sentido a la aceleracion
        
        
        return 1000/60*(B / 100);
    }
    
    /**
     * Inicializa los valores del viento.
     * La inicializacion se eraliza a traves de archivo
     */
    private void inicializar(){
         Loader entrada = new Loader("viento.txt");
        
        String id;
        String hora;
        String sentido;
        String velocidad;
        
        //lee el archivo
        String archivo = entrada.leerArchivo();
        
        StringTokenizer archivoAux = new StringTokenizer(archivo, " \n \t \r \f ");
        
        while(archivoAux.hasMoreTokens()){
            //mira el id
            id = archivoAux.nextToken();
            
            //mira la hora
            hora = archivoAux.nextToken();
            
            //mira el sentido
            sentido = archivoAux.nextToken();
            
            //mira la velocidad
            velocidad = archivoAux.nextToken();
            
            mapaVientoVelocidad.put(hora, Double.valueOf(velocidad)); //mete el valor de la velocidad
            mapaVientoSentido.put(hora, SentidoViento.valueOf(sentido)); //mete el valor del sentido
            
        }
    }

    @Override
    public void ejecutar() {
        if((mapaVientoVelocidad.containsKey(reloj.toString()))&&reloj.isTickProducido()){ //si esta esa hora en el mapa
            //actualiza los datos actuales
            velocidad =(double) mapaVientoVelocidad.get(reloj.toString());
            sentido = (SentidoViento) mapaVientoSentido.get(reloj.toString());
            
            this.setChanged();  //ha habido un cambia
            this.notifyObservers(); //lo notifico   
        } 
    }
    
    /**
     * Devuelve la informacion de la aceleracion del viento como string
     * @return el string con la aceleracion del viento
     */
    public String infoAceleracionViento(){
        return String.format("%1$.4f", getAceleracionViento()) + " m/s2 ";
    }
    
    /**
     * Devuelve la informacion del viento como string
     * @return la informacion del viento como string
     */
    public String toString(){
        return infoAceleracionViento() + sentido.toString() + " " + String.format("%1$.2f", velocidad) + " " + "km/h";
    }
    
}
