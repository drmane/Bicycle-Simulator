/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Tiempo.RelojAplicacion;
import modelo.Tiempo.RelojSistema;
import modelo.ciclistas_bicicleta.ListaCiclistas;
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
public class ModeloTest {
    
    public ModeloTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPendiolo method, of class Modelo.
     */
    @Test
    public void testGetPendiolo() {
        System.out.println("getPendiolo");
        Modelo instance = new Modelo();
        PendioloCurviolo expResult = instance.getPendiolo();
        PendioloCurviolo result = instance.getPendiolo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEolo method, of class Modelo.
     */
    @Test
    public void testGetEolo() {
        System.out.println("getEolo");
        Modelo instance = new Modelo();
        Eolo expResult = instance.getEolo();
        Eolo result = instance.getEolo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCiclistas method, of class Modelo.
     */
    @Test
    public void testGetListaCiclistas() {
        System.out.println("getListaCiclistas");
        Modelo instance = new Modelo();
        ListaCiclistas expResult = instance.getListaCiclistas();
        ListaCiclistas result = instance.getListaCiclistas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReloj method, of class Modelo.
     */
    @Test
    public void testGetReloj() {
        System.out.println("getReloj");
        Modelo instance = new Modelo();
        RelojAplicacion expResult = instance.getReloj();
        RelojAplicacion result = instance.getReloj();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getRelojSistema method, of class Modelo.
     */
    @Test
    public void testGetRelojSistema() {
        System.out.println("getRelojSistema");
        Modelo instance = new Modelo();
        RelojSistema expResult = instance.getRelojSistema();
        RelojSistema result = instance.getRelojSistema();
        assertEquals(expResult, result);
    }

    /**
     * Test of isActivo method, of class Modelo.
     */
    @Test
    public void testIsActivo() {
        System.out.println("isActivo");
        Modelo instance = new Modelo();
        boolean expResult = true;
        boolean result = instance.isActivo();
        assertEquals(expResult, result);
    }

    /**
     * Test of inicializarCiclistas method, of class Modelo.
     */
    @Test
    public void testInicializarCiclistas() {
        System.out.println("inicializarCiclistas");
        int n = 0;
        Modelo instance = new Modelo();
        instance.inicializarCiclistas(n);
    }

    /**
     * Test of inicializarListaEjecucion method, of class Modelo.
     */
    @Test
    public void testInicializarListaEjecucion() {
        System.out.println("inicializarListaEjecucion");
        Modelo instance = new Modelo();
        instance.inicializarListaEjecucion();
    }
}