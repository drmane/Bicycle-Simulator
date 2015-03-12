/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Tiempo;

import java.util.Observable;

/**
 *
 * @author Daniel
 */
public class Reloj extends Observable{ //el reloj es un observable de la vista

    private int segundos;
    private int minutos;
    private int horas;
    
    private boolean tickProducido; //para indicar si se ha producido un tic

    /**
     * Constructor por defecto
     */
    public Reloj() {
        this.segundos = 0;
        this.minutos = 0;
        this.horas = 0;
        

        tickProducido = true;
    }

    /**
     * Constructor generador
     * @param segundos los segundos del reloj
     * @param minutos los minutos del reloj
     * @param horas  las hoas del reloj
     */
    public Reloj(int segundos, int minutos, int horas) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
        
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

    public boolean isTickProducido() {
        return tickProducido;
    }

    public void setTickProducido(boolean tickProducido) {
        this.tickProducido = tickProducido;
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
        
        tickProducido = true;
        
        this.setChanged(); //poner este metodo donde se produzcan cambios 
        notifyObservers(); //notifica a los observadores sobre los cambios del observable
    }
    
 
    @Override
      public String toString(){
         return getHorasFormatted() + ":" + getMinutosFormatted() + ":" + getSegundosFormatted();
      }
    
}
