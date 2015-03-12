/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciclistas_bicicleta;

import constantes.Constantes;
import java.util.Observable;
import modelo.Ejecucion;

/**
 * Clase que simula un ciclista
 *
 * @author Daniel
 */
public class Ciclista extends Observable implements Ejecucion {

    private double masa; //en kg
    private double altura; //en metros
    private double pesoDeCiclista; //peso = masa * gravedad
    private int cadencia; //numero de pedaladas por minuto
    private double tiempoDeDuracionDePedalada; // lo que tarda en dar la pedalada actual 
    private double contadorTiempoDeDuracionDePedalada;
    private double IntervaloEntreCadaPedalada; //el IntervaloEntreCadaPedalada de la pedalada
    private double contadorIntervaloEntreCadaPedalada; // Cuando llege a 0 se produce una pedalada
    private double fuerza; //como la energia, si se gasta el ciclista abandona
    private Bicicleta bicicleta; //una referencia a la bicicleta
 private  double aceleracionProducidaPorCiclista;
    private double aceleracionATransmitir;

    /**
     * Constructor generador del ciclista
     *
     * @param bicicleta el objeto bicicleta del ciclista
     */
    public Ciclista(Bicicleta bicicleta) {

        masa = Constantes.masaCiclista;
        altura = Constantes.altura;

        pesoDeCiclista = masa * Constantes.gravedad;

        cadencia = Constantes.cadenciaInicial; //la cadencia inicial

        tiempoDeDuracionDePedalada = Constantes.duracionDePedaladaInicial;

        contadorTiempoDeDuracionDePedalada = tiempoDeDuracionDePedalada;


        IntervaloEntreCadaPedalada = getIntervaloEntreCadaPedalada();

        contadorIntervaloEntreCadaPedalada = IntervaloEntreCadaPedalada;

        fuerza = Constantes.fuerzaInicial;

        this.bicicleta = bicicleta;

        aceleracionATransmitir = 0;
    }

    public double getIntervaloEntreCadaPedalada() {

        if (cadencia > 0) {
            IntervaloEntreCadaPedalada = 60000 / (double) cadencia;
        } else {
            IntervaloEntreCadaPedalada = 0;
        }

        return IntervaloEntreCadaPedalada;
    }

    public void setIntervaloEntreCadaPedalada(double IntervaloEntreCadaPedalada) {

        if (cadencia > 0) {
            this.IntervaloEntreCadaPedalada = getIntervaloEntreCadaPedalada();
            this.contadorIntervaloEntreCadaPedalada = IntervaloEntreCadaPedalada - getContadorIntervaloEntreCadaPedalada();
        } else {
            this.IntervaloEntreCadaPedalada = 0;
        }

    }

    public double getContadorIntervaloEntreCadaPedalada() {
        return contadorIntervaloEntreCadaPedalada;
    }

    public void setContadorIntervaloEntreCadaPedalada(double contadorIntervaloEntreCadaPedalada) {
        this.contadorIntervaloEntreCadaPedalada = contadorIntervaloEntreCadaPedalada;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return pesoDeCiclista;
    }

    public void setPeso(double peso) {
        this.pesoDeCiclista = peso;
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int cadencia) {
        this.cadencia = cadencia;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public double getAceleracionATransmitir() {
        return aceleracionATransmitir;
    }

    public void setAceleracionATransmitir(double aceleracionATransmitir) {
        this.aceleracionATransmitir = aceleracionATransmitir;
    }
    
    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
        
        //se notifican los cambios
        setChanged();
        notifyObservers();
    }

    public double getTiempoDeDuracionDePedalada() {
        return tiempoDeDuracionDePedalada;
    }

    public void setTiempoDeDuracionDePedalada(double tiempoDeDuracionDePedalada) {
        this.tiempoDeDuracionDePedalada = tiempoDeDuracionDePedalada;
    }

    public void aumentarTiempoDeDuracionDePedalada() {
        if(tiempoDeDuracionDePedalada < getIntervaloEntreCadaPedalada()){
        this.setTiempoDeDuracionDePedalada(tiempoDeDuracionDePedalada +1 );
        setChanged();
        notifyObservers();
        } else {
            Constantes.logger.error("ERROR!! No se puede aumentar mas la la duracion de pedalada");
        }  
        
    }
    
    //PONER QUE NO SE PUEDE AUMENTAR O DISMINUTIR MAS O MENOS DE LOS PARAMETROS ESTABELCIDOS
    //si la candencia es 0 el cilista no pedalada de por si

    public void disminuirTiempoDeDuracionDePedalada() {
        if (this.tiempoDeDuracionDePedalada > 1 && tiempoDeDuracionDePedalada > Constantes.tiempoDeIteracion) {
            this.tiempoDeDuracionDePedalada = tiempoDeDuracionDePedalada - 1;
            setChanged();
            notifyObservers();
        } else {
            Constantes.logger.error("ERROR!! No se puede disminuir mas la la duracion de pedalada");
        }
    }

    /**
     * Se calcula el gasto producido mendiante F = m*a, donde la aceleracion es
     * la que el ciclista aplica a la bicicleta
     *
     * @return devuelve la fuerza astada
     */
    public double calcularGastoFuerzaPedalada() {

        
        return (getMasa() + bicicleta.getMasa()) * calcularAceleracionParaGastoDeFuerza();
    }

    /**
     * Calcula la aceleraicion total compuesta por la aceleracion producida por
     * el cilcista + la aceelarcion de factores externos
     *
     * @return la aceleracion resultarnte
     */
    public double calcularAceleracionResultante() {

           return  aceleracionProducidaPorCiclista * 1000;
           
           //+ bicicleta.calcularAceleracionFactoresExternos(); demasiado fuertes las aceleraciones, da errores
        
   }
    
      public double calcularAceleracionParaGastoDeFuerza() {

        //falta la producida por factores externos, si se pone da algun fallo
        double aceleracionResultante = aceleracionProducidaPorCiclista;
         double aceleracionFE =  bicicleta.calcularAceleracionFactoresExternos() ;
         
         
         
         //si la aceleracion producida por factores externos es negativa se gastara mas fuerza
         // se generara el triple de fuerza, en lineas futuras, este factor vendra dado por la fuerza del viento y pendiente
        if(aceleracionFE < 0 )
        {
            aceleracionResultante = aceleracionResultante * 3 ;
        }
        else
        {
            if(aceleracionFE > aceleracionProducidaPorCiclista)
                aceleracionResultante=0;
        }
        
        return aceleracionResultante;
    }
    
    
      

    /**
     * El cicilista "da una Pedalada" aunque esta se produsca en vacio, si se
     * produce en vacio, la aceleraación que se transmite es 0
     *
     * @param tiempoPedalada
     */
    public void darPedalada(double AceleracionATransmitir)
    { 
        setFuerza(getFuerza() - calcularGastoFuerzaPedalada()); //disminuye la fuerza respecto a la aceleracion del ciclista
        bicicleta.acelera(AceleracionATransmitir);     
    }
    
    /**
     * Aumenta la cadencia
     */
    public void aumentarCadencia() {

        //REVISAR, CREO QUE ESTA BIEN
        if (cadencia < Constantes.maxCadencia && (60000 / ((double) cadencia+1)) > getTiempoDeDuracionDePedalada()) {
            cadencia++; //aumenta la cadencia
            setIntervaloEntreCadaPedalada(60000 / ((double) cadencia)); //cambia el IntervaloEntreCadaPedalada

            setChanged();
            notifyObservers();
        } else {
            Constantes.logger.error("ERROR!! No se puede aumentar mas la cadencia");
        }
    }

    /**
     * Disminuyo la cadencia
     */
    public void disminuirCadencia() {
        if (cadencia >= 1) {
            cadencia--; //aumenta la cadencia
            setIntervaloEntreCadaPedalada(60000 / ((double) cadencia)); //cambia el IntervaloEntreCadaPedalada

            setChanged();
            notifyObservers();
        } else {
            Constantes.logger.error("ERROR!! No se puede disminuir mas la cadencia");
        }
    }

    /**
     * Para completamente la bicicleta de forma instantanea
     */
    public void frenaTotal(){
        bicicleta.setVelocidad(0);
    }
    
    /**
     * Frena la bicicleta 10 m/s
     * Si la velocidad es menor que 10, la para completamente
     */
    public void frenaMas(){
        double nuevaVelocidad = bicicleta.getVelocidad() - 10;
        
        if(nuevaVelocidad < 0)
            bicicleta.setVelocidad(0);
        else
            bicicleta.setVelocidad(nuevaVelocidad);
    }
    
    /**
     * Frena la bicicleta 5 m/s
     * Si la velocidad es menor que 5, la para completamente
     */
    public void frenaMenos(){
        double nuevaVelocidad = bicicleta.getVelocidad() - 5;
        
        if(nuevaVelocidad < 0)
            bicicleta.setVelocidad(0);
        else
            bicicleta.setVelocidad(nuevaVelocidad);
    }
   
    @Override
    public void ejecutar() {

         if(bicicleta.isActivo()){ //si esta activa la bicicleta, se jeecuta, sino no
        
        //cuidado, hay de 2 a 4 bicis que se ejecutan, si se debuggea hay que tenerlo en cuenta
        bicicleta.actualizarPendiente();

        //Si ya ha terminado mi pedalada. no produzco mas acelarcion
        if (contadorTiempoDeDuracionDePedalada >= tiempoDeDuracionDePedalada) {
            aceleracionProducidaPorCiclista = calcularAceleracionCiclista();
            contadorTiempoDeDuracionDePedalada = 0;
        
        } //si sigo dando la pedalada calcular la aceleracion 
        else {  
            aceleracionProducidaPorCiclista = 0;
            contadorTiempoDeDuracionDePedalada = contadorTiempoDeDuracionDePedalada + Constantes.tiempoDeIteracion;
        }


        //Si ya he esperado lo sufciente para la pedalada
        if (contadorIntervaloEntreCadaPedalada >= IntervaloEntreCadaPedalada) {
            contadorIntervaloEntreCadaPedalada = 0;
        } else {

            contadorIntervaloEntreCadaPedalada =  contadorIntervaloEntreCadaPedalada  + Constantes.tiempoDeIteracion;
        }

         aceleracionATransmitir = calcularAcelaracionAtransmitir() ;
                 
        // se "da la pedala" aunque en realidad el cilista no la de, el metodo se podria entender como ejecuta bicicleta
        
        darPedalada(aceleracionATransmitir);
        }
    }
    
    /**
     * Calcula la aceleracion producida por el cilcista
     *
     * @return Devuelve la aceleracion en m/ms^2
     */
    public double calcularAceleracionCiclista() {
        // a= e/t^2
        //a = m /s^2
        // se multipliza por 1000 para pasar de ms a s     
        return (bicicleta.calcularEspacioPorCadaPedalada() / (Math.pow(tiempoDeDuracionDePedalada, 2)));

    }
    
    /**
     * Calcula la aceleracion que va a trasmitir a la bicicleta
     * @return la aceleracion que va a trasmitir a la bicicleta
     */
     public double calcularAcelaracionAtransmitir()
     {
        double aceleracionResultante = calcularAceleracionResultante();
        double aceleracionTrasmitir = 0;
       
         
        //si la resultante es 0, la acelaracion a trasminir es 0
         if(aceleracionResultante == 0){ 
             aceleracionTrasmitir = 0; 
         }
         else if(aceleracionResultante < 0){ //si la resultante es menor que 0, la 
             //debe cambiar el tiempo de pedalada para que la de mas rapido
             
             aceleracionTrasmitir = Math.abs(aceleracionResultante);
         }
         else{ //sino, es la resultante de las aceleraciones
            aceleracionTrasmitir = aceleracionResultante;
         }
       
         return aceleracionTrasmitir;
     }
     
    /**
     * Permite conseguir la informacion de la cadencia del ciclista
     *
     * @return el string con la informacion de la cadencia del ciclista
     */
    public String infoCadencia() {
        return String.valueOf(getCadencia());
    }
    
    /**
     * Permite conseguir la informacion de la duracion de la pedalada del ciclista
     * @return el string con la informacion de la duracion de la pedalada del ciclista
     */
    public String infoTiempoDeDuracionDePedalada() {
        return String.valueOf(getTiempoDeDuracionDePedalada());
    }

    /**
     * Permite conseguir la informacion del IntervaloEntreCadaPedalada del
     * ciclista
     *
     * @return el string con la informacion del IntervaloEntreCadaPedalada del
     * ciclista
     */
    public String infoPeriodo() {
        return String.format("%1$.2f", getIntervaloEntreCadaPedalada());
    }
    
    /**
     * Permite conseguir la informacion de de la fuerza del ciclista
     * 
     * @return el string con la informacion de la fuerza del ciclista
     */
     public String infoFuerza() {
        return String.format("%1$.2f", getFuerza());
    }
}
