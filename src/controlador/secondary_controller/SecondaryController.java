/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.secondary_controller;

import constantes.Constantes;
import controlador.InterfazControlador;
import controlador.comandos.InterfazComando;
import controlador.comandos.Parser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import modelo.ciclistas_bicicleta.Bicicleta;
import modelo.ciclistas_bicicleta.Ciclista;
import modelo.factores_externos.eolo.Eolo;
import modelo.Modelo;
import modelo.Tiempo.RelojAplicacion;
import modelo.Tiempo.RelojSistema;
import vista.ventanas.SecondaryFrame;
import vista.ventanas.ViewInterface;

/**
 *
 * @author Daniel
 */
public class SecondaryController implements InterfazControlador, ActionListener, Observer {
    private Ciclista ciclistaActual;

    private SecondaryFrame secondaryFrame;
    private Modelo modelo; 
    
    private Parser parser;

    @Override
    public void addModel(Modelo m) {
        modelo = m;
        
        parser = new Parser(modelo); //al asignar el modelo, se crea el nuevo parser
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
            if(s.equals("Aceptar Periodo del Reloj")){
            modelo.getReloj().setrelacionIteracionSegundo(Integer.valueOf(secondaryFrame.getjFormattedTextField3().getText()));
        }
        else if(s.equals("Aceptar Comando")){
             String comandoTxt;
             comandoTxt = secondaryFrame.getjTextField2().getText();
             
             InterfazComando comandoParseado = (parser.parse(new StringTokenizer (comandoTxt , " \n\t \r \f ")));
             
             if(comandoParseado != null){
                 secondaryFrame.getjTextField3().setText("Exito!! Se ha reconocido el comando");
                 comandoParseado.ejecutarComando();
             }
             else{
                 secondaryFrame.getjTextField3().setText("ERROR!! No se ha reconocido el comando");
             }
        } 
    }

    @Override
    public void update(Observable o, Object arg) {
        
        if(o instanceof RelojAplicacion){ //si el reloj hace los cambios     
            secondaryFrame.getjTextField1().setText(modelo.getReloj().toString()); //actualiza el campo con la informacion del reloj
        }
        else if (o instanceof Eolo){
            secondaryFrame.getjFormattedTextField4().setText(modelo.getEolo().infoAceleracionViento()); //la informacion del viento
            Constantes.logger.info("Se ha producido un cambio en el viento");
        }
        else if (o instanceof Bicicleta){
            secondaryFrame.getjFormattedTextField5().setText(ciclistaActual.getBicicleta().infoPendienteAceleracion());
            
            if(arg instanceof String){
                String s = (String) arg;
                if(s.equals("Cambio Aceleracion")){
                    secondaryFrame.getjFormattedTextField1().setText(ciclistaActual.getBicicleta().infoAceleracion()); 
                }
            }
        }
        else if( o instanceof RelojSistema){
            secondaryFrame.getjFormattedTextField2().setText(modelo.getRelojSistema().toString());
        }
    }

    @Override
    public void addView(ViewInterface v) {
        secondaryFrame = (SecondaryFrame)v;
    }

    @Override
    public void initView() {
        secondaryFrame.setVisible(true);
        
        ciclistaActual = modelo.getListaCiclistas().getCiclista(0); //el primer ciclista es el de la posicion 0
        
        secondaryFrame.getjFormattedTextField4().setText(modelo.getEolo().infoAceleracionViento());
        
        secondaryFrame.getjFormattedTextField5().setText(ciclistaActual.getBicicleta().infoPendienteAceleracion());
        
        ciclistaActual.getBicicleta().addObserver((Observer)this); //a la bicicleta la observa este controlador
        
        secondaryFrame.getjFormattedTextField2().setText(modelo.getRelojSistema().toString());
    }
    
     /**
     * Permite cambiar el ciclista actual
     * @param nuevoCiclista el id del nuevo ciclista que se quiere poner
     */
    public void cambiarCiclistaActual(int nuevoCiclista){
        ciclistaActual = modelo.getListaCiclistas().getCiclista(nuevoCiclista);
    }
    
}
