/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.eolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class SentidoVientoTest {
    
    public SentidoVientoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class SentidoViento.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        SentidoViento[] expResult = {SentidoViento.AFAVOR,SentidoViento.ENCONTRA,SentidoViento.LATERAL,SentidoViento.NULO};
        SentidoViento[] result = SentidoViento.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class SentidoViento.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        SentidoViento expResult = SentidoViento.AFAVOR;
        SentidoViento result = SentidoViento.valueOf("AFAVOR");
        assertEquals(expResult, result);
    }

    /**
     * Test of getFactor method, of class SentidoViento.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        int expResult = 1;
        int result = SentidoViento.AFAVOR.getFactor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnum method, of class SentidoViento.
     */
    @Test
    public void testGetEnum() {
        System.out.println("getEnum");
        String sentido = "";
        SentidoViento expResult = SentidoViento.ENCONTRA;
        SentidoViento result = SentidoViento.getEnum("ENCONTRA");
        assertEquals(expResult, result);
    }
}