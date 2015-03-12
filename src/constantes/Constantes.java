/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

import java.awt.Image;
import java.awt.Toolkit;
import modelo.Modelo;
import org.apache.log4j.Logger;

/**
 * Constantes de la aplicacion
 * @author Daniel
 */
public class Constantes {
    
   public static final double gravedad = 9.8; //metros/s al cuadrado 
   public static final double PI = 3.14159265358979323846; //constante que no se puede cambiar
   
   public static final int maxPinones = 7;
   public static final int maxPlatos = 3;
   
   public static final int maxCadencia = 120;
   public static final int minCadencia = 60;
   
    //al no cambiarse en la aplicacion, las considero constantes
   public static final double masaCiclista = 80;
   public static final double altura = 1.80;
   public static final double masaBicicleta = 18;
   
   public static final double fuerzaInicial = 1000; //la fuerza inicial
   
   //como el intervalo entre cada pedalada no puede ser menor a la duracion de la pedalada. Entonces, si la duracionDePedaladaInicial = 1, la cadencia inicial es >= 60 
   public static final int cadenciaInicial = 60;
   public static final int duracionDePedaladaInicial = 1000; //en milisegundos
   
   
    public static final int tiempoDeIteracion = 300; //Tiempo que representa la iteracion , en milisegundos 0

   
   public static final int pinonInicial = 0;
   public static final int platoInicial = 0;
   
   public static final double radio = 0.37;
   
   public static final double constanteViento = 0.837;

   public static final int minimoCiclistas = 1;
   
   public static final int maximoCiclistas = 4;
   
   public static final int ordenadaOrigenMapa = 300;
   
   public static final double finalCarrerra = 1360; //la carrera va a ser de 1360 KM(para que entre ajustado en el mapa)
   
   public static final Logger logger = Logger.getLogger(Modelo.class); //el logger de todo el modelo
   //el logger es una constante de la aplicacion (el modelo realmente)
   //lo normal es tener un logger por clase
   
   public static final Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/iconoB.png"));
}
