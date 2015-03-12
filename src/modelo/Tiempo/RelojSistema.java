/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Tiempo;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que simula el reloj del sistema
 * Para no bloquear la ejecucion, debe ejecutarse en un thread a parte
 * @author Daniel
 */
public class RelojSistema extends Observable implements Runnable{
    
    private int segundos;
    private int minutos;
    private int horas;
    
    /**
     * Constructor por defecto
     */
    public RelojSistema() {
        this.segundos = 0;
        this.minutos = 0;
        this.horas = 0;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
     public String getSegundosFormatted(){
        return String.format("%02d", getSegundos());
    }
    
    public String getMinutosFormatted(){
        return String.format("%02d", getMinutos());
    }
    
    public String getHorasFormatted(){
        return String.format("%02d", getHoras());
    }
    
    /**
     * Realiza un tick del reloj
     * es decir, pasa el tiempo
     */
    protected void tick()
    {
        segundos++;
        
        if(segundos > 59){
            segundos = 0;
            minutos++;
            
            if(minutos > 59){
                minutos = 0;
                horas++;
                
                if(horas > 23)
                    horas = 0;
            }
        }  
        
        setChanged(); //notifica que se ha pasado el tiempo
        notifyObservers();
    }
    
 
    @Override
      public String toString(){
         return getHorasFormatted() + ":" + getMinutosFormatted() + ":" + getSegundosFormatted();
      }

    @Override
    public void run() {
        
        while(true){ //lo ejecutara siempre
            tick();

            try 
            {
                Thread.sleep(1000); //duerme al hilo por un segundo
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(RelojSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
