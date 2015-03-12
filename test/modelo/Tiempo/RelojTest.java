/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Tiempo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class RelojTest {
    
    public RelojTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSegundos method, of class Reloj.
     */
    @Test
    public void testGetSegundos() {
        System.out.println("getSegundos");
        Reloj instance = new Reloj();
        instance.setSegundos(11);
        int expResult = 11;
        int result = instance.getSegundos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegundos method, of class Reloj.
     */
    @Test
    public void testSetSegundos() {
        System.out.println("setSegundos");
        int segundos = 0;
        Reloj instance = new Reloj();
        instance.setSegundos(12);
       
        assertEquals(12,instance.getSegundos());
    }

    /**
     * Test of getMinutos method, of class Reloj.
     */
    @Test
    public void testGetMinutos() {
        System.out.println("getMinutos");
        Reloj instance = new Reloj();
        instance.setMinutos(55);
        int expResult = 55;
        int result = instance.getMinutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinutos method, of class Reloj.
     */
    @Test
    public void testSetMinutos() {
        System.out.println("setMinutos");
        int minutos = 0;
        Reloj instance = new Reloj();
        instance.setMinutos(30);
        assertEquals(30,instance.getMinutos());
    }

    /**
     * Test of getHoras method, of class Reloj.
     */
    @Test
    public void testGetHoras() {
        System.out.println("getHoras");
        Reloj instance = new Reloj();
        instance.setHoras(12);
        int expResult = 12;
        int result = instance.getHoras();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHoras method, of class Reloj.
     */
    @Test
    public void testSetHoras() {
        System.out.println("setHoras");
        int horas = 0;
        Reloj instance = new Reloj();
        instance.setHoras(30);
        assertEquals(30,instance.getHoras());
    }

    /**
     * Test of isTickProducido method, of class Reloj.
     */
    @Test
    public void testIsTickProducido() {
        System.out.println("isTickProducido");
        Reloj instance = new Reloj();
        instance.setTickProducido(true);
        boolean expResult = true;
        boolean result = instance.isTickProducido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTickProducido method, of class Reloj.
     */
    @Test
    public void testSetTickProducido() {
        System.out.println("setTickProducido");
        boolean tickProducido = false;
        Reloj instance = new Reloj();
        instance.setTickProducido(false);
        assertEquals(false,instance.isTickProducido());
    }

    /**
     * Test of getSegundosFormatted method, of class Reloj.
     */
    @Test
    public void testGetSegundosFormatted() {
        System.out.println("getSegundosFormatted");
        Reloj instance = new Reloj();
        instance.setSegundos(10);
        String expResult = "10";
        String result = instance.getSegundosFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutosFormatted method, of class Reloj.
     */
    @Test
    public void testGetMinutosFormatted() {
        System.out.println("getMinutosFormatted");
        Reloj instance = new Reloj();
        instance.setMinutos(50);
        String expResult = "50";
        String result = instance.getMinutosFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHorasFormatted method, of class Reloj.
     */
    @Test
    public void testGetHorasFormatted() {
        System.out.println("getHorasFormatted");
        Reloj instance = new Reloj();
        instance.setHoras(13);
        String expResult = "13";
        String result = instance.getHorasFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of tick method, of class Reloj.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Reloj instance = new Reloj();
        instance.setSegundos(10);
        instance.tick();
        assertEquals(11,instance.getSegundos());
        
        instance.setSegundos(59);
        instance.tick();
        assertEquals(0,instance.getSegundos());
    }

    /**
     * Test of toString method, of class Reloj.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Reloj instance = new Reloj();
        instance.setSegundos(10);
        instance.setMinutos(11);
        instance.setHoras(1);
        String expResult = "01:11:10";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}