/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class PendioloCurvioloTest {
    
    public PendioloCurvioloTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMapaCurvas method, of class PendioloCurviolo.
     */
    @Test
    public void testGetMapaCurvas() {
        System.out.println("getMapaCurvas");
        PendioloCurviolo instance = new PendioloCurviolo();
        Map expResult = null;
        Map result = instance.getMapaCurvas();
        assertNotNull(result);
    }

    /**
     * Test of comprobarCurva method, of class PendioloCurviolo.
     */
    @Test
    public void testComprobarCurva() {
        System.out.println("comprobarCurva");
        double posicion = 0.0;
        PendioloCurviolo instance = new PendioloCurviolo();
        double expResult = 0.0;
        double result = instance.comprobarCurva(posicion);
        assertNotNull(result);
    }
}