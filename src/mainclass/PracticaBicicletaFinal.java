package mainclass;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import controlador.primary_controller.PrimaryController;
import controlador.secondary_controller.SecondaryController;
import java.util.Observer;
import modelo.Modelo;
import vista.ventanas.PrimaryFrame;
import vista.ventanas.SecondaryFrame;
import constantes.Constantes;
import controlador.Loader;
import controlador.comandos.Parser;
import java.util.StringTokenizer;
import org.apache.log4j.PropertyConfigurator;


/**
 * Version Final
 * @author Daniel.
 */
public class PracticaBicicletaFinal {


        
    /**
     * El main de la aplicacion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       if(args.length == 2){  
        int numeroCiclistas = Integer.valueOf(args[0]);

        if((numeroCiclistas < Constantes.minimoCiclistas)||(numeroCiclistas > Constantes.maximoCiclistas)){
            Constantes.logger.error("Introduce un numero de ciclistas valido, minimo: " + Constantes.minimoCiclistas + " maximo: " + Constantes.maximoCiclistas );
        }
        else{
             PracticaBicicletaFinal programa = new PracticaBicicletaFinal();
             programa.comenzar(numeroCiclistas,args[1]);
        }
       }
       else{
           Constantes.logger.error("Numero de argumentos no correcto, Formato: PracticaBicicletaFinal numero_ciclistas fichero_comandos");
       }
    }
    
   
   /**
     * Permite comenzar la aplicacion con n ciclistas
     * @param n los ciclistas
    * @param archivoComandos el nombre del archivo donde se leeran los comandos
    */
    public void comenzar(int n, String archivoComandos){
        PropertyConfigurator.configure("log4j.properties"); //configura el log
        
        //el orden es muy importante

         //hago el modelo y la vista
        Modelo m = new Modelo();
        
        
        PrimaryFrame primaryFrame = new PrimaryFrame();
        SecondaryFrame secondaryFrame = new SecondaryFrame();
             
        //hago el controlador
        PrimaryController primaryController = new PrimaryController();
        SecondaryController secondaryController = new SecondaryController();
        
        //añado el modelo y la vista al controlador
        primaryController.addModel(m);
        primaryController.addView(primaryFrame);
        
        secondaryController.addModel(m);
        secondaryController.addView(secondaryFrame);
        
        //y añado el controlador a la vista
        primaryFrame.addController(primaryController); //al mainFrame
        secondaryFrame.addController(secondaryController); //al secondFrame
        
        //añado el modelo para el patron observador observable
        primaryController.addModel(m); //al primaryController
        secondaryController.addModel(m); //al secondaryController
      
        //inicializa a los ciclistas
        m.inicializarCiclistas(n);
        
        //inicializo la vista con los ciclistas
        primaryController.initView();
        secondaryController.initView();
        
        //inicializa los observadores
        initObserversPrimaryFrame(m,primaryController); 
        initObserversSecondaryFrame(m,secondaryController);

        inicializarComandos(archivoComandos, m); //inicializa los comandos
        
        m.ejecutar(); //ejecuta el modelo
       
    }
    
        
    /**
     * Permite inicializar los observadores de la pantalla principal de la aplicacion
     * @param m el modelo de la aplicacion
     * @param c el controlador del primary frame
     */
    public void initObserversPrimaryFrame(Modelo m, PrimaryController c){
        m.addObserver((Observer)c); //al modelo lo observa la vista

        c.getCiclistaActual().addObserver((Observer)c); //al ciclista lo observa la ventana principal
        
        m.getEolo().addObserver((Observer)c); //a eolo lo observa el frame 1  
        
        m.getListaCiclistas().addObserver((Observer)c); //el primer controlador observa a la lista de bicicletas
    }
    
    /**
     * Permite inicializar los observadores de la segunda vntana de la aplicacion
     * @param m el modelo de la aplicacion
     * @param c el controlador del secondary frame
     */
    public void initObserversSecondaryFrame(Modelo m, SecondaryController c){
        
        m.getReloj().addObserver((Observer)c); //al reloj lo observa el segundo Frame
        
        m.getEolo().addObserver((Observer)c); // a eolo lo observa el segundo frame
        
        m.getRelojSistema().addObserver((Observer)c); //el segundo frame observa el reloj del sistema
        
    }
    
    /**
     * Inicializa los comandos del archivo de texto
     * @param nombreArchivoTexto el nombre del archivo de texto donde estan los comandos
     * @param modelo el modelo sobre el que actuan los comandos
     */
    public void inicializarComandos(String nombreArchivoTexto,Modelo modelo){
        
        Loader entrada = new Loader(nombreArchivoTexto);
        Parser parser = new Parser(modelo);
        
        String comandoTxt = entrada.leerLinea();
        
        while(comandoTxt != null){
            (parser.parse(new StringTokenizer (comandoTxt , " \n\t \r \f "))).ejecutarComando(); //ejecuta el comando
            comandoTxt = entrada.leerLinea(); //lee el siguiente comando
        }
    }
}
