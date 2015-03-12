/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciclistas_bicicleta;

import java.util.Vector;
import modelo.Tiempo.Reloj;
import modelo.factores_externos.eolo.Eolo;
import modelo.factores_externos.pendiolo.PendioloCurviolo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class ListaCiclistasTest {
    
    public ListaCiclistasTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of anadirCiclista method, of class ListaCiclistas.
     */
    @Test
    public void testAnadirCiclista() {
        System.out.println("anadirCiclista");
        Ciclista ciclista = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        ListaCiclistas instance = new ListaCiclistas();
        instance.anadirCiclista(ciclista);
        assertEquals(1,instance.getListaCiclistasEstructura().size());
    }

    /**
     * Test of numeroCiclistas method, of class ListaCiclistas.
     */
    @Test
    public void testNumeroCiclistas() {
        System.out.println("numeroCiclistas");
        ListaCiclistas instance = new ListaCiclistas();
        int expResult = 1;
        instance.anadirCiclista(new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo())));
        int result = instance.numeroCiclistas();
        assertEquals(expResult, result);
    }

    /**
     * Test of ejecutar method, of class ListaCiclistas.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        ListaCiclistas instance = new ListaCiclistas();
        instance.ejecutar();
    }

    /**
     * Test of comprobarFinCarrera method, of class ListaCiclistas.
     */
    @Test
    public void testComprobarFinCarrera() {
        System.out.println("comprobarFinCarrera");
        ListaCiclistas instance = new ListaCiclistas();
        instance.comprobarFinCarrera();
    }

    /**
     * Test of getCiclista method, of class ListaCiclistas.
     */
    @Test
    public void testGetCiclista() {
        System.out.println("getCiclista");
        int n = 0;
        ListaCiclistas instance = new ListaCiclistas();
        Ciclista ciclista = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.anadirCiclista(ciclista);
        Ciclista expResult = ciclista;
        Ciclista result = instance.getCiclista(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCiclistasEstructura method, of class ListaCiclistas.
     */
    @Test
    public void testGetListaCiclistasEstructura() {
        System.out.println("getListaCiclistasEstructura");
        ListaCiclistas instance = new ListaCiclistas();
        Vector v = new Vector();
        Vector expResult = v;
        Vector result = instance.getListaCiclistasEstructura();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoCiclista method, of class ListaCiclistas.
     */
    @Test
    public void testInfoCiclista() {
        System.out.println("infoCiclista");
        int n = 0;
        ListaCiclistas instance = new ListaCiclistas();
        instance.anadirCiclista(new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo())));
        char[] expResult = {'C','i','c','l','i','s','t','a',' ','1'};
        char[] result = instance.infoCiclista(n);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of isListaFin method, of class ListaCiclistas.
     */
    @Test
    public void testIsListaFin() {
        System.out.println("isListaFin");
        ListaCiclistas instance = new ListaCiclistas();
        boolean expResult = false;
        instance.setListaFin(false);
        boolean result = instance.isListaFin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaFin method, of class ListaCiclistas.
     */
    @Test
    public void testSetListaFin() {
        System.out.println("setListaFin");
        boolean listaFin = true;
        ListaCiclistas instance = new ListaCiclistas();
        instance.setListaFin(listaFin);
        assertEquals(true,instance.isListaFin());
    }
}