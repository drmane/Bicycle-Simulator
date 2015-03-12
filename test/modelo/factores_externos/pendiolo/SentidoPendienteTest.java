/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class SentidoPendienteTest {
    
    public SentidoPendienteTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class SentidoPendiente.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        SentidoPendiente[] expResult = {SentidoPendiente.ASCENDENTE,SentidoPendiente.DESCENDENTE,SentidoPendiente.LLANO,SentidoPendiente.NULO};
        SentidoPendiente[] result = SentidoPendiente.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class SentidoPendiente.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "ASCENDENTE";
        SentidoPendiente expResult = SentidoPendiente.ASCENDENTE;
        SentidoPendiente result = SentidoPendiente.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFactor method, of class SentidoPendiente.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        SentidoPendiente instance = SentidoPendiente.DESCENDENTE;
        int expResult = 1;
        int result = instance.getFactor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnum method, of class SentidoPendiente.
     */
    @Test
    public void testGetEnum() {
        System.out.println("getEnum");
        String sentido = "LLANO";
        SentidoPendiente expResult = SentidoPendiente.LLANO;
        SentidoPendiente result = SentidoPendiente.getEnum(sentido);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularEnum method, of class SentidoPendiente.
     */
    @Test
    public void testCalcularEnum() {
        System.out.println("calcularEnum");
        double n = 30.0;
        SentidoPendiente expResult = SentidoPendiente.DESCENDENTE;
        SentidoPendiente result = SentidoPendiente.calcularEnum(n);
        assertEquals(expResult, result);
    }
}