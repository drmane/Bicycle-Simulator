/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciclistas_bicicleta;

import constantes.Constantes;
import java.awt.Color;
import java.util.Observable;
import modelo.factores_externos.eolo.Eolo;
import modelo.factores_externos.pendiolo.PendioloCurviolo;
import modelo.Tiempo.RelojAplicacion;
import vista.colorgenerator.ColorGenerator;

/**
 * Clase que simula una bicicleta
 *
 * @author Daniel
 */
public class Bicicleta extends Observable {
    
    private boolean activo;
    
    private boolean destruida; //por si se destruye en una curva

    private double velocidad; // en m/s seguro
    private double aceleracion; // en m/s2 seguro
    private double radio; // en metros seguro
    private int[] platos;
    private int[] pinones;
    private int platoActual;
    private int pinonActual;
    private double masa;
    private double PesoDeBicicleta; // peso = masa * gravedad
    private double distanciaRecorrida; // en metros 
    private Eolo eolo; //para saber el viento actual
    private PendioloCurviolo pendiolo;
    private double pendienteActual; //guarda informacion sobre la pendiente y el sentido
    //si es +, la pendiente es descendente (significa que la aceleracion es positiva)
    //si es -, la pendiente es ascendente (significa que la aceleracion es negatica)

    private Color color; //el color de la bicicleta

    /**
     * Constructor generador de la bicicleta
     *
     * @param eolo el objeto viento de la bicicleta
     * @param pendiolo el objeto pendiente de la bicicleta
     */
    public Bicicleta(Eolo eolo, PendioloCurviolo pendiolo) {
        
        activo = true;

        destruida = false;
        
        velocidad = 0;
        aceleracion = 0;

        radio = Constantes.radio;

        platos = new int[]{36, 42, 53};

        pinones = new int[]{16, 18, 21, 23, 25, 28, 32};//los valores de los dientes de los pinones tienen un valor por defecto

        setPlatoActual(Constantes.platoInicial);

        setPinonActual(Constantes.pinonInicial);

        masa = Constantes.masaBicicleta;

        PesoDeBicicleta = masa * Constantes.gravedad;

        distanciaRecorrida = 0;

        this.eolo = eolo;

        this.pendiolo = pendiolo;
        
        color = ColorGenerator.generateColor(); //genera un color aleatorio

    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;

        this.setChanged();
        this.notifyObservers(platoActual);
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {      
        this.aceleracion = aceleracion;
        
        if(aceleracion != 0){
            setChanged(); //si no es 0, notifica el cambio
            notifyObservers("Cambio Aceleracion");
        }
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public int getPlatoActualDientes() {
        return platos[platoActual];
    }
    
    public int getPlatoActual() {
        return platoActual;
    }

    public void setPlatoActual(int platoActual) {
        this.platoActual = platoActual;

        this.setChanged();
        this.notifyObservers(platoActual);
    }

    public int getPinonActualDientes() {
        return pinones[pinonActual];
    }
    
    public int getPinonActual() {
        return pinonActual;
    } 

    public void setPinonActual(int pinonActual) {
        this.pinonActual = pinonActual;

        this.setChanged();
        this.notifyObservers(pinonActual);
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getPeso() {
        return PesoDeBicicleta;
    }

    public void setPeso(double peso) {
        this.PesoDeBicicleta = peso;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        
        this.distanciaRecorrida = distanciaRecorrida;

        this.setChanged();
        this.notifyObservers(platoActual);
    }

    /**
     * Devuelve la distancia recorrida en km
     *
     * @return el valor de la distancia recorrida en KM
     */
    public double getDistanciaRecorridaKM() {
        return distanciaRecorrida / 1000;
    }

    public double getPendienteActual() {
        return pendienteActual;
    }

    public double getPendienteActualSentido() {
        return -getPendienteActual();
    }

    public void setPendienteActual(double pendienteActual) {
        this.pendienteActual = pendienteActual;
    }

    public Eolo getEolo() {
        return eolo;
    }

    public void setEolo(Eolo eolo) {
        this.eolo = eolo;
    }

    public PendioloCurviolo getPendiolo() {
        return pendiolo;
    }

    public void setPendiolo(PendioloCurviolo pendiolo) {
        this.pendiolo = pendiolo;
    }

    public Color getColor() {
        return color;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Calcula el diametro de la rueda de la bicicleta
     *
     * @return el diametro de la rueda de la bicicleta
     */
    public double calcularDiametroBicicleta() {
        return 2 * getRadio();
    }

    /**
     * Calcula el recorrido lineal de la rueda
     *
     * @return devuelve el recorrido lineal de la rueda en metros
     */
    public double calcularRecorridoLineal() {
        //lo que avanza la bicicleta por cada pedalada, perimetro de la bicicleta
        return Constantes.PI * calcularDiametroBicicleta();
    }

    /**
     * Aumenta el plato en uno si es posible
     */
    public void aumentarPlato() {
        if (getPlatoActual() < Constantes.maxPlatos - 1) {
            setPlatoActual(getPlatoActual() + 1);
        } else {
            Constantes.logger.error("Solo hay " + Constantes.maxPlatos + "platos");
        }
    }

    public boolean isDestruida() {
        return destruida;
    }

    public void setDestruida(boolean destruida) {
        this.destruida = destruida;
    }

    /**
     * Disminuye el plato en uno si es posible
     */
    public void disminuirPlato() {
        if (getPlatoActual() > 0) {
            setPlatoActual(getPlatoActual() - 1);
        } else {
           Constantes.logger.error("No se puede disminuir a un plato menor");
        }
    }

    /**
     * Aumenta el pinon en uno si es posible
     */
    public void aumentarPinon() {
        if (getPinonActual() < Constantes.maxPinones - 1) {
            setPinonActual(getPinonActual() + 1);
        } else {
            Constantes.logger.error("Solo hay " + Constantes.maxPinones + "pinones");
        }
    }

    /**
     * Disminuye el pinon si es posible
     */
    public void disminuirPinon() {
        if (getPinonActual() > 0) {
            setPinonActual(getPinonActual() - 1);
        } else {
            Constantes.logger.error("No se puede disminuir a un pinon menor");
        }
    }
    /**
     * Calcula la relacion de trasnmision dada por la division entre el playo actual y el pinon actual
     * @return la ralacion de transmision
     */
    public double calcularRelacionDeTransmision()
    {
        return getPlatoActualDientes()/(double)getPinonActualDientes();
    }
    
    /**
     * Calcula el espacio por cada pedalada que viene dado por el recorrido lineal de la rueda y la realcion de trasnmision de la bicicleta
     * @return el espacio por pedalada en metros
     */
    public double calcularEspacioPorCadaPedalada()
    {
        return calcularRecorridoLineal() * calcularRelacionDeTransmision();
        
    }
    
 
    /**
     * Suma la aceleracion da la pendiente más la aceleracion del viento
     * @return  Devuelve la aceleracion de factores externos en m/s^2
     */
    public double calcularAceleracionFactoresExternos() {


       return pendiolo.getAceleracionPendiente((int) getDistanciaRecorrida()) + eolo.getAceleracionViento();
    }

    /**
     * Permite actualizar la pendiente de la bicicleta
     */
    public void actualizarPendiente() {
        //calcula la pendiente
        double pendienteAux = pendienteActual;
        
        pendienteActual = pendiolo.getPendiente(distanciaRecorrida); //calcula la nueva pendiente
        
        if(pendienteAux != pendienteActual){ //sino son iguales, se produce un cambio de pendiente
            setChanged();
            notifyObservers("Cambio Pendiente"); 
        }
    }

    /**
     * Permite acelerar a la bicicleta
     *
     * @param aceleracion la aceleracion que se le debe de dar a la bicicleta
     * @param tiempo el tiempo que va a acelerar
     */
    public void acelera(double aceleracion) {
       
        
        setAceleracion(aceleracion); //se cambia la aceleracion
        setVelocidad((getVelocidad() + aceleracion * Constantes.tiempoDeIteracion / RelojAplicacion.getrelacionIteracionSegundo())); // se pasa a segundo los milisegundos
        comprobarFin();
        desplazar(); //desplaza la bicicleta
        
    }

    /**
     * Desplaza la bicicleta una distancia
     *
     * @param tiempo el iempo que va a durar el desplazamiento
     */
    public void desplazar() {
        //se pasa a segundos, ya que la constante esta en milisegundos
        setDistanciaRecorrida(getDistanciaRecorrida() + velocidad * Constantes.tiempoDeIteracion/1000);// se pasa a segundos

        comprobarCurva(); //comprueba si se ha chocado en la curva
        comprobarFin();
    }
    
    /**
     * Permite comprobar si se ha llegado al final de la carrera
     * Si ha llegado, desactiva la bicicleta
     */
    private void comprobarFin(){
        
        if(distanciaRecorrida >= Constantes.finalCarrerra * 1000){
            setActivo(false);
        }
    }
    
    /**
     * Comprueba si lleva la velocidad apropiada para la curva mas cercana
     */
    private void comprobarCurva(){
        double velocidadLimite = pendiolo.comprobarCurva(distanciaRecorrida);
        
        if(velocidadLimite != -1){
            if(velocidad > velocidadLimite){ //si te has pasado de velocidad
                destruida = true; //la carrera acaba
                setActivo(false);
                
                Constantes.logger.info("La bici ha tenido un accidente");
            }
        }
    }

    /**
     * Permite conseguir la informacion de los platos
     *
     * @return el string de la informacion de los platos
     */
    public String infoPlatos() {
        return String.valueOf(platoActual + 1) + " con " + String.valueOf(platos[platoActual]) + " dientes";
    }

    /**
     * Permite conseguir la informacion de los pinones
     *
     * @return el string de la informacion de los pinones
     */
    public String infoPinon() {
        return String.valueOf(pinonActual + 1) + " con " + String.valueOf(pinones[pinonActual]) + " dientes";
    }

    /**
     * Permite conseguir la informacion de la velocidad
     *
     * @return el string de la informacion de la velocidad
     */
    public String infoVelocidad() {
        return String.format("%1$.2f", velocidad) + " m/s";
    }

    /**
     * Permite conseguir la informacion de la distancia recorrida
     *
     * @return el strnig de la informacion recorrida
     */
    public String infoDistanciaRecorrida() {
        return String.format("%1$.3f", getDistanciaRecorridaKM()) + " km";
    }

    /**
     * Permite conseguir la informacion de la pendiente
     *
     * @return el string de la informacion de la pendiente
     */
    public String infoPendiente() {
        //la pendiente actual es en valor absoluto
        return String.format("%1$.2f", Math.abs(pendienteActual)) + "% " + String.format("%1$.2f", pendiolo.getAceleracionPendiente(getDistanciaRecorrida())) + " m/s2 " + pendiolo.getSentido(pendienteActual).toString();
    }
    
    /**
     * Permite conseguir la informacion de la aceleracion que lleva la bicicleta
     * 
     * @return la aceleracion de la bicicleta en metros / segundo al cuadrado 
     */
    public String infoAceleracion(){
        return String.format("%1$.4f",aceleracion) + " m/s2";
    }
    
    /**
     * Permite obtener la aceleracion producida por la pendiente
     * @return la aceleracion producida por la pendiente como String
     */
    public String infoPendienteAceleracion(){
        return String.format("%1$.4f", pendiolo.getAceleracionPendiente(getDistanciaRecorrida())) + " m/s2";
    }
}
