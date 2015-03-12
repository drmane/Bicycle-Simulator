/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.colorgenerator;

import java.awt.Color;
import java.util.Random;

/**
 * Clase que genera colores aleatorios
 * Se ha hecho estática para que sea accesible desde cualquier punto del programa
 * @author Daniel
 */
public class ColorGenerator {
    
    private static Random numAleatorios = new Random();

    public static Color generateColor(){
        return new Color(numAleatorios.nextFloat(), numAleatorios.nextFloat(), numAleatorios.nextFloat());     
    }  
}
