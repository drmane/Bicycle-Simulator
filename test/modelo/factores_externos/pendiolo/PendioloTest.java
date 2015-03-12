/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class PendioloTest {
    
    public PendioloTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAceleracionPendiente method, of class Pendiolo.
     */
    @Test
    public void testGetAceleracionPendiente() {
        System.out.println("getAceleracionPendiente");
        double puntoKilometrico = 0.0;
        Pendiolo instance = new Pendiolo();
        double expResult = 0.0;
        double result = instance.getAceleracionPendiente(puntoKilometrico);
        assertNotNull(expResult);
    }

    /**
     * Test of getPendiente method, of class Pendiolo.
     */
    @Test
    public void testGetPendiente() {
        System.out.println("getPendiente");
        double recorrido = 0.0;
        Pendiolo instance = new Pendiolo();
        double expResult = -10;
        double result = instance.getPendiente(recorrido);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSentido method, of class Pendiolo.
     */
    @Test
    public void testGetSentido() {
        System.out.println("getSentido");
        double pendiente = 0.0;
        Pendiolo instance = new Pendiolo();
        SentidoPendiente expResult = SentidoPendiente.LLANO;
        SentidoPendiente result = instance.getSentido(pendiente);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMapaPendiente method, of class Pendiolo.
     */
    @Test
    public void testGetMapaPendiente() {
        System.out.println("getMapaPendiente");
        Pendiolo instance = new Pendiolo();
        Map expResult = null;
        Map result = instance.getMapaPendiente();
        Assert.assertNotNull(result);
    }

    /**
     * Test of setMapaPendiente method, of class Pendiolo.
     */
    @Test
    public void testSetMapaPendiente() {
        System.out.println("setMapaPendiente");
        Map<Double, Double> mapaPendiente = null;
        Pendiolo instance = new Pendiolo();
        instance.setMapaPendiente(mapaPendiente);
        assertNull(instance.getMapaPendiente());
    }
}