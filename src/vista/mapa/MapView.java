/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.mapa;

import constantes.Constantes;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;
import javax.swing.JPanel;
import modelo.ciclistas_bicicleta.Bicicleta;
import modelo.ciclistas_bicicleta.Ciclista;
import modelo.ciclistas_bicicleta.ListaCiclistas;

/**
 * Clase que se encarga de la representacion del mapaPendiente de la carrera
 * @author Daniel
 */
public class MapView extends JPanel implements Observer{
    
    private ListaCiclistas listaCiclistas;
    
    private int origenInfoCiclistas = 10;
    private int numeroPuntos;
    private int numeroCurvas;
    private int numeroBicicletas;
    
    
    private int [] puntosXMapa;
    private int [] puntosMMapa;
    private int [] puntosYMapa;
    
    private int [] puntosXCurva;
    private int [] puntosMCurva;
    private int [] puntosYCurva;
    
    private int ordenadaOrigenMapa;
    
    //Hay tres arrays auxiliares que guardan información de la bicicleta a la hora de pintar
    private int [] ordenadaOrigenBiciX; //donde se guardan las ordenadas en el origen X de la bici
    private int [] ordenadaOrigenBiciY; //donde se guardan las ordenadas en el origen y de la bici
    private int [] ultimasAlturasBicicletas; //donde se guardan las ultimas alturas de las bicicletas

    public MapView() {
        setBackground(Color.CYAN);
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        pintarMapa(g);
        pintarCurvas(g);
        pintarMeta(g);
        pintarListaCiclistas(g); 
    }
   
  
    /**
     * Pinta el mapaPendiente
     * @param g g el contenido grafico donde lo queremos pintar
     */
    public void pintarMapa(Graphics g){
         g.drawPolyline(puntosXMapa, puntosYMapa, puntosXMapa.length);  
    }
    
    /**
     * Pinta la lista de ciclistas en el mapaPendiente
     * @param g el contenido grafico donde lo queremos pintar
     */
    public void pintarListaCiclistas(Graphics g){
        Vector<Ciclista> lista = listaCiclistas.getListaCiclistasEstructura();
        Bicicleta bicicleta;
        
        int i = 0; //contador de las bicicletas
        int posicionRelativa = 10; //para que se pinten una bajo la otra
        
        Iterator it = lista.iterator();
        
        while(it.hasNext()){
            Ciclista ciclista = ((Ciclista)it.next());
            bicicleta = ciclista.getBicicleta();
            
            pintarInfoCiclista(g,bicicleta,i,posicionRelativa);
            
            if(bicicleta.isActivo()&& !bicicleta.isDestruida()){ //si esta viva la bicicleta lo pinta, sino no
                pintarBicicleta(g,bicicleta,i);
            }
            else if(!bicicleta.isActivo()&& bicicleta.isDestruida()){
                pintarBicicletaDestruida(g,bicicleta,i);
            }
            
            i++;
            posicionRelativa += 20;
        }  
    }

    /**
     * Pinta la bicicleta en su posicion actual
     * @param g el contenido grafico donde lo queremos pintar
     * @param bicicleta la bicicleta que deseamos pintar
     * @param i el numero de bicicleta a pintar
     */
    public void pintarBicicleta(Graphics g, Bicicleta bicicleta,int i){
        
        int x = (int)bicicleta.getDistanciaRecorridaKM();
        int variacionX = x - ordenadaOrigenBiciX[i]; //se pasa a int, en km

        
        int y = ordenadaOrigenBiciY[i] - calcularAltura(variacionX,(int)bicicleta.getPendienteActualSentido()); //se pasa a int
        
        ultimasAlturasBicicletas[i] = y; //la ultima altura es la nueva altura calculada
        

        g.setColor(bicicleta.getColor());
        g.fillOval(x, y -10, 10, 10);
        g.fillOval(x + 10, y -10, 10, 10);
        
    }
    
     /**
     * Pinta la bicicleta destruida en su posicion actual
     * @param g el contenido grafico donde lo queremos pintar
     * @param bicicleta la bicicleta que deseamos pintar
     * @param i el numero de bicicleta a pintar
     */
    private void pintarBicicletaDestruida(Graphics g, Bicicleta bicicleta, int i) {
        int x = (int)bicicleta.getDistanciaRecorridaKM();
        int variacionX = x - ordenadaOrigenBiciX[i]; //se pasa a int, en km

        
        int y = ordenadaOrigenBiciY[i] - calcularAltura(variacionX,(int)bicicleta.getPendienteActualSentido()); //se pasa a int
        
        ultimasAlturasBicicletas[i] = y; //la ultima altura es la nueva altura calculada
        
        //panelFondo.getGraphics().drawRect(x, y -10, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(x, y -10, 10, 10);
        g.fillRect(x + 10, y -10, 10, 10);
    }

    
    /**
     * Pinta la curva en el mapaPendiente
     * @param g los graficos donde lo va a pintar
     * @param x la posicion x de la curva
     * @param y la posicion y de la curva
     */
    public void pintarCurva(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillRect(x, y -10, 10, 10);
    }
    
    /**
     * Permite pintar las curvas del mapa
     * @param g los graficos donde se quieren pintar
     */
    private void pintarCurvas(Graphics g) {
        for(int i = 0; i < numeroCurvas; i++ ){
            pintarCurva(g,puntosXCurva[i],puntosYCurva[i]);
        }
    }
    
    /**
     * Pinta la informacion del ciclista con el color de la bicicleta
     * @param g los graphicos donde pintar
     * @param bicicleta la bicicleta que se quiere pintar
     * @param id el id de la bicicleta
     * @param posicionRelativa la posicion relativa respecto al origen de la informacion de los ciclistas
     */
    public void pintarInfoCiclista(Graphics g, Bicicleta bicicleta, int id, int posicionRelativa){
        char [] palabra = listaCiclistas.infoCiclista(id);
        
         g.setColor(bicicleta.getColor());
        
        g.drawChars(palabra, 0, palabra.length, 15, origenInfoCiclistas + posicionRelativa);
        
        g.fillOval(80, posicionRelativa , 10, 10);
    }
    
    /**
     * Permite pintar el final de la carrera
     * @param g los graficos donde pintar
     */
    public void pintarMeta(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(puntosXMapa[numeroPuntos-1],puntosYMapa[numeroPuntos-1] - 10 , 10, 10);
    }
    
    /**
     * Calcula la altura donde debe pintar un elemento con pendiene
     * @param posicion la posicion del elemento respecto al origen decidido (se le pasa la variacion de posiciones)
     * @param pendiente la pendiente del elemento
     * @return 
     */
    public int calcularAltura(int posicion, int pendiente){
        return (posicion * pendiente) / 100;       
    }
    
    /**
     * Calcula el mapaPendiente
     */
    public void calcularMapaPendientes(){
            
        Map<Double,Double> mapaPendiente = listaCiclistas.getCiclista(0).getBicicleta().getPendiolo().getMapaPendiente();
        //pinta el mapaPendiente de un ciclista de la lista (comparten el mismo mapaPendiente)
        

        numeroPuntos = mapaPendiente.size() + 1; 
        int contador = 0;

        ordenadaOrigenMapa = Constantes.ordenadaOrigenMapa; //por defecto
        
        //array de coordenadas X
        puntosXMapa = new int[numeroPuntos];

        //array de pendientes

        puntosMMapa = new int [numeroPuntos];
         //array de coordenadas Y
        puntosYMapa = new int[numeroPuntos];

        Set keys = mapaPendiente.keySet();

     
    //recorre el mapaPendiente con un iterador
       for (Iterator i = keys.iterator(); i.hasNext();) 
       {
            double key = (double) i.next();
            
            double value = mapaPendiente.get(key); //se tiene que hacer asi

            value *= -1; //cambiar el signo del valor

            puntosXMapa[contador] = (int) key;

            puntosMMapa[contador] = (int) value;
            
            contador++;
      }
       
        //calcula las alturas de los puntos
         puntosYMapa[0] = ordenadaOrigenMapa; //el primer punto lo establezco yo

         
         int variacionPuntos;
         
         for(int i = 1; i < puntosYMapa.length; i++){
             variacionPuntos = puntosXMapa[i] - puntosXMapa[i - 1];
             
             puntosYMapa[i] = ordenadaOrigenMapa - calcularAltura(variacionPuntos,puntosMMapa[i-1]);
             
             ordenadaOrigenMapa = puntosYMapa[i];
         }
        //pintar el punto final es un poco dificil
         
         puntosXMapa[numeroPuntos - 1] = (int)Constantes.finalCarrerra; //el final de la carrera es a los 1200 km
         puntosMMapa[numeroPuntos - 1] = 0; //es llano a partir de los 1200km
         
         ordenadaOrigenMapa = puntosYMapa[numeroPuntos - 2];
         
         int variacionPuntosAux = puntosXMapa[numeroPuntos - 1] - puntosXMapa[numeroPuntos - 2]; //para calcular el ultimo punto
         
         //calcular la altura del ultimo punto
         puntosYMapa[numeroPuntos - 1] = ordenadaOrigenMapa - calcularAltura(variacionPuntosAux,puntosMMapa[numeroPuntos - 2]);
    }
    
    /**
     * Permite calcula las curvas del mapa
     * Se usara a la hora de pintarlas
     */
    public void calcularCurvas(){
        Map<Double,Double> mapaCurvas = listaCiclistas.getCiclista(0).getBicicleta().getPendiolo().getMapaCurvas();
        
        numeroCurvas = mapaCurvas.size();
        
        //array de coordenadas X
        puntosXCurva = new int[numeroCurvas];

        //array de curvas

        puntosMCurva = new int [numeroCurvas];
         //array de coordenadas Y
        puntosYCurva = new int[numeroCurvas];
        
        Set keys = mapaCurvas.keySet();

        int contador = 0;
     
        //recorre el mapaCurvas con un iterador
        //rellena la componente X de las curvas
        for (Iterator i = keys.iterator(); i.hasNext();) 
        {
             double key = (double) i.next();

             puntosXCurva[contador] = (int) key;

             contador++;
       }
        
       boolean intervaloEncontrado = false;
       int j = 0;
       
       for(int i = 0; i < numeroCurvas; i++){
           
           while((j < numeroPuntos)&&(!intervaloEncontrado)){
               if(puntosXMapa[j] >= puntosXCurva[i]){
                   intervaloEncontrado= true;
                   puntosMCurva[i] = puntosMMapa[j - 1];
                   
                   int variacion = puntosXCurva[i] - puntosXMapa[j - 1];
                   
                   puntosYCurva[i] = puntosYMapa[j - 1] - calcularAltura(variacion,  puntosMCurva[i]);
               }
               else{
                   j++;
               }
           }
           intervaloEncontrado = false;
           j = 0;
       }
    }
    
    /**
     * Permite asignar una lista de ciclistas al mapaPendiente
     * @param listaCiclistas la lista que se desea asignar
     */
    public void asignarListaCiclistas(ListaCiclistas listaCiclistas){
        this.listaCiclistas = listaCiclistas;
        numeroBicicletas = listaCiclistas.getListaCiclistasEstructura().size();
        inicializarComponentesAuxiliares();
        initObserversMapa();
    }

    /**
     * Crea e inicializa los arrays auxiliares que va a usar para pintar
     */
    private void inicializarComponentesAuxiliares() {
       int size = listaCiclistas.getListaCiclistasEstructura().size(); 
        
       ordenadaOrigenBiciX = new int [size]; 
       ordenadaOrigenBiciY = new int [size]; 
       ultimasAlturasBicicletas = new int [size];
       
       for(int i = 0; i < size; i++){
           ordenadaOrigenBiciX[i] = 0;
           ordenadaOrigenBiciY[i] =  Constantes.ordenadaOrigenMapa; 
           ultimasAlturasBicicletas[i] = ordenadaOrigenBiciY[i]; //las ultimas alturas al principio es la ordenada en el origen
       }
    }
    
    /**
     * inicializa los observadores del mapaPendiente
     * El mapaPendiente observa a todos los ciclistas por si se produce un cambio de pendiente
     */
    public void initObserversMapa(){
        Iterator it = listaCiclistas.getListaCiclistasEstructura().iterator();
        
        while(it.hasNext()){
            ((Ciclista)it.next()).getBicicleta().addObserver(this);
        }
    }
    
    /**
     * Reconoce la bicicleta y devuelve su id respecto a la lista
     * La bicicleta siempre esta en la lista
     * @param bici la bicicleta a buscar
     * @return el id de la biciccleta buscada
     */
    public int reconocerBicicleta(Bicicleta bici){
        int i = 0; //para saber que bici ha cambiado
        boolean encontrado = false;
        Bicicleta biciAux;

        Iterator it = listaCiclistas.getListaCiclistasEstructura().iterator();
        
        //recorre los ciclistas para ver que bicicleta es
        while((it.hasNext())&&!encontrado){
            biciAux = ((Ciclista)it.next()).getBicicleta();
            
            if(biciAux.equals(bici)){ //si no es igual a la bici, aumenta el contador
                encontrado = true;
            }
            else{
                i++;
            }
        }
        
        return i;
    }
    
    
    //es sincronizado porque se puede dar un problema de concurrencia
    //hay una seccion critica en este metodo, ej: si dos bicicletas producen un cambio de pendiente
    @Override
    public synchronized void update(Observable o, Object arg) {
        if(o instanceof Bicicleta){ //si es la bici
            if(arg instanceof String){
                String s = (String) arg;
                if(s.equals("Cambio Pendiente")){
                    
                    Bicicleta bici = (Bicicleta)o;

                    int id = reconocerBicicleta(bici);

                    //se cambian las ordenadas en el origen x e y de la bicicleta
                    ordenadaOrigenBiciX[id] = (int)bici.getDistanciaRecorridaKM();
                    //el nuevo origen X es donde esta

                    ordenadaOrigenBiciY[id] = ultimasAlturasBicicletas[id];
                    //el nuevo origen Y es la ultima altura calculada
                    
                    Constantes.logger.info("Se ha producido un cambio de pendiente en la bici " + (id + 1));
                    
                         
                }
            }
        }
    }
}
