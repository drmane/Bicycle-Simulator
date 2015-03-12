/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.primary_controller;

import constantes.Constantes;
import controlador.InterfazControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComboBox;
import modelo.ciclistas_bicicleta.Bicicleta;
import modelo.ciclistas_bicicleta.Ciclista;
import modelo.factores_externos.eolo.Eolo;
import modelo.ciclistas_bicicleta.ListaCiclistas;
import modelo.Modelo;
import vista.ventanas.PrimaryFrame;
import vista.mapa.MapView;
import vista.ventanas.ViewInterface;

/**
 * El controador principal de la aplicacion
 * @author Daniel
 */
public class PrimaryController implements InterfazControlador, ActionListener, Observer{
    
    private PrimaryFrame primaryFrame;
    private Modelo modelo; 
    
    private Ciclista ciclistaActual;
    
    @Override
    public void addModel(Modelo m) {
        modelo = m;
    }
    
    @Override
    public void addView(ViewInterface v) {
        primaryFrame = (PrimaryFrame)v;
    }

    /**
     * Devuelve el ciclista actual
     * @return el ciclista actual
     */
    public Ciclista getCiclistaActual() {
        return ciclistaActual;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object o = e.getSource();
        
        if(o instanceof JComboBox){
            JComboBox comboBoxAux = (JComboBox) o;
            cambiarCiclistaActual(comboBoxAux.getSelectedIndex());
            Constantes.logger.info("Se ha seleccionado el ciclista " + (comboBoxAux.getSelectedIndex()+1));
        }
      
        if(command.equals("Aumentar Plato")){
            ciclistaActual.getBicicleta().aumentarPlato();
            Constantes.logger.info("Se ha aumentado el plato");
        }
        else if (command.equals("Disminuir Plato")){
            ciclistaActual.getBicicleta().disminuirPlato();
            Constantes.logger.info("Se ha disminuido el plato");
        }
        else if (command.equals("Aumentar Pinon")){
            ciclistaActual.getBicicleta().aumentarPinon();
            Constantes.logger.info("Se ha aumentado el pinon");
        }
        else if (command.equals("Disminuir Pinon")){
            ciclistaActual.getBicicleta().disminuirPinon();
            Constantes.logger.info("Se ha disminuido el pinon");
        }   
        else if (command.equals("Aumentar Tiempo")){
            ciclistaActual.aumentarTiempoDeDuracionDePedalada();
            Constantes.logger.info("Se ha aumentado el tiempo de duracion de pedalada");
        }
            else if (command.equals("Disminuir Tiempo")){
            ciclistaActual.disminuirTiempoDeDuracionDePedalada();
            Constantes.logger.info("Se ha disminudo el tiempo de duracion de pedalad");
        }
        else if (command.equals("Aumentar Cadencia")){
            ciclistaActual.aumentarCadencia();
            Constantes.logger.info("Se ha aumentado la cadencia");
        }
         else if (command.equals("Disminuir Cadencia")){
            ciclistaActual.disminuirCadencia();   
            Constantes.logger.info("Se ha disminuido la cadencia");
        }
         else if(command.equals("Frena Total")){
             ciclistaActual.frenaTotal();
             Constantes.logger.info("Se ha frenado totalmente");
         }
         else if(command.equals("Mas Freno")){
             ciclistaActual.frenaMas();
             Constantes.logger.info("Se ha frenado bastante");
         }
             else if(command.equals("Menos Freno")){
             ciclistaActual.frenaMenos();
             Constantes.logger.info("Se ha frenado un poco");
         }
    }
    
    /**
     * Inicializa los primeros datos de la visa
     */
    public void initView(){
        ciclistaActual = modelo.getListaCiclistas().getCiclista(0); //el primer ciclista es el de la posicion 0
        
        MapView mapa = (MapView) primaryFrame.getjPanel1(); //asignamos la bicicleta al mapa
        mapa.asignarListaCiclistas(modelo.getListaCiclistas());
        mapa.calcularMapaPendientes(); //calcula el mapa a pintar
        mapa.calcularCurvas();
        
        ciclistaActual.getBicicleta().addObserver((Observer)this); //a la bicicleta la observa este controlador
       
        inicializarComboBox();
    
        initWindowListener();
        
        primaryFrame.getjFormattedTextField1().setText(ciclistaActual.infoCadencia());  //inicializa los campos correspondientes al ciclista
        primaryFrame.getjFormattedTextField3().setText(ciclistaActual.infoPeriodo());
        primaryFrame.getjFormattedTextField11().setText(ciclistaActual.infoTiempoDeDuracionDePedalada());
        primaryFrame.getjFormattedTextField2().setText(ciclistaActual.infoFuerza());
        
        
        primaryFrame.getjFormattedTextField9().setText(modelo.getEolo().toString()); //inicializa el campo de eolo
        primaryFrame.getjFormattedTextField10().setText(ciclistaActual.getBicicleta().infoPendiente()); //inicializa el campo de la pendiente
        
        primaryFrame.getjFormattedTextField7().setText(ciclistaActual.getBicicleta().infoPlatos()); //informacion de los platos
        primaryFrame.getjFormattedTextField8().setText(ciclistaActual.getBicicleta().infoPinon()); //informacion de los pinones
    
        primaryFrame.getjFormattedTextField5().setText(ciclistaActual.getBicicleta().infoDistanciaRecorrida()); //informacion de la distancia recorrida
        primaryFrame.getjFormattedTextField6().setText(ciclistaActual.getBicicleta().infoVelocidad()); //la informacion de la velocidad

        
        primaryFrame.setVisible(true);
    }
    
    /**
     * Permite inicializar el WindowListener del PrimaryFrame
     * Se usa el listener para desactivar la ejecucion de la aplicaion al cerrar
     */
    public void initWindowListener(){
        PrimaryFrameWindowListener listener = new PrimaryFrameWindowListener();
        
        listener.addModel(modelo);
        listener.addView(primaryFrame);
        
        primaryFrame.addWindowListener(listener); 
    }
    
    /**
     * Inicializa el combox
     */
    public void inicializarComboBox(){
        Iterator it = modelo.getListaCiclistas().getListaCiclistasEstructura().iterator();
        int i = 0;
        
        while(it.hasNext()){
            primaryFrame.getjComboBox1().addItem("Ciclista " + (i+1));
            it.next();
            i++;
        }   
    }
    
    /**
     * Permite cambiar el ciclista actual
     * @param nuevoCiclista el id del nuevo ciclista que se quiere poner
     */
    public void cambiarCiclistaActual(int nuevoCiclista){
        ciclistaActual = modelo.getListaCiclistas().getCiclista(nuevoCiclista);
    }
    
    /**
     * Devuelve el mapa donde se pintan las bicicletas
     * @return el mapa donde se pintan las bicicletas
     */
    public MapView getMapaPintar(){
        return (MapView)primaryFrame.getjPanel1();
    }

    @Override
    public void update(Observable o, Object arg) {
         if (o instanceof Modelo) {
            primaryFrame.setVisible(true);
            //this.getSecondFrame().setVisible(true);
        } else if (o instanceof Eolo) {
            primaryFrame.getjFormattedTextField9().setText(modelo.getEolo().toString());
        } else if (o instanceof Bicicleta) {
            //actualiza los campos referidos a la bicicleta
            primaryFrame.getjFormattedTextField7().setText(ciclistaActual.getBicicleta().infoPlatos()); //platos

            primaryFrame.getjFormattedTextField8().setText(ciclistaActual.getBicicleta().infoPinon()); //pinon

            primaryFrame.getjFormattedTextField6().setText(ciclistaActual.getBicicleta().infoVelocidad()); //velocidad

            primaryFrame.getjFormattedTextField5().setText(ciclistaActual.getBicicleta().infoDistanciaRecorrida()); //distancia recorrida

            primaryFrame.getjFormattedTextField10().setText(ciclistaActual.getBicicleta().infoPendiente()); //la informacion sobre la pendiente

            primaryFrame.getjFormattedTextField1().setText(ciclistaActual.infoCadencia());

            primaryFrame.getjFormattedTextField3().setText(ciclistaActual.infoPeriodo());
            
            primaryFrame.getjFormattedTextField11().setText(ciclistaActual.infoTiempoDeDuracionDePedalada());


            primaryFrame.getjPanel1().repaint(); //vuelve a pintar se panel
        } else if (o instanceof Ciclista) {
            primaryFrame.getjFormattedTextField1().setText(ciclistaActual.infoCadencia());
            
            primaryFrame.getjFormattedTextField2().setText(ciclistaActual.infoFuerza());

            primaryFrame.getjFormattedTextField3().setText(ciclistaActual.infoPeriodo());
        }
        else if (o instanceof ListaCiclistas){ //si es la lista de bicicletas
            primaryFrame.lanzarMensajeFinCarrera(); //le dice que lance el mensaje de fin de carrera
        }

    }
}
