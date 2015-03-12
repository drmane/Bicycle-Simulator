/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.comandos;

import java.util.StringTokenizer;
import modelo.Modelo;

/**
 *
 * @author Daniel
 */
public class Parser {
    
    private Modelo modelo;

    public Parser(Modelo modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Permite parsear los comandos
     * Devuelve null sino se ha reconocido o no parsea
     * @param comandoTexto el comando con formato String
     * @return el comando ya parseado
     */
    public InterfazComando parse(StringTokenizer comandoTexto){
        
        String id = comandoTexto.nextToken();
        InterfazComando comandoParseado = null;
        
        if(id.equals("bicicleta")){
            String numeroCiclista = comandoTexto.nextToken();
            
            comandoTexto.nextToken();
            
            String id2 = comandoTexto.nextToken();
            
            if(id2.equals("plato")){
                String nuevoPlato = comandoTexto.nextToken();
                
                comandoParseado = new ComandoCambiaPlato(numeroCiclista,nuevoPlato,modelo.getListaCiclistas());
            }
           
             if((id2.equals("pinon"))||(id2.equals("pinon"))){ //desde archivo de texto no se lee la palabra pinon
                String nuevoPinon = comandoTexto.nextToken();
                
                comandoParseado = new ComandoCambiaPinon(numeroCiclista,nuevoPinon,modelo.getListaCiclistas());
            }
        }
        else if(id.equals("viento")){
            String hora = comandoTexto.nextToken();
            
            String sentido = comandoTexto.nextToken();
            
            String velocidad = comandoTexto.nextToken();
            
            comandoParseado = new ComandoAnadirViento(hora,sentido,Double.valueOf(velocidad),modelo.getEolo());
            
        }
        else if(id.equals("ciclista")){
            String idCiclista = comandoTexto.nextToken();
            
            comandoTexto.nextToken();
            
            String cadencia = comandoTexto.nextToken();
            
            comandoTexto.nextToken();
            
            String tiempoPedalada = comandoTexto.nextToken();
            
            comandoParseado = new ComandoCambiarCadenciaTiempoPedalada(Integer.valueOf(idCiclista), Integer.valueOf(cadencia),Double.valueOf(tiempoPedalada),modelo.getListaCiclistas());
        }
        
        return comandoParseado;
    }
}
