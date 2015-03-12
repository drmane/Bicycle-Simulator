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
public class RelojSistemaTest {
    
    public RelojSistemaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSegundos method, of class RelojSistema.
     */
    @Test
    public void testGetSegundos() {
        System.out.println("getSegundos");
        RelojSistema instance = new RelojSistema();
        instance.setSegundos(11);
        int expResult = 11;
        int result = instance.getSegundos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegundos method, of class RelojSistema.
     */
    @Test
    public void testSetSegundos() {
        System.out.println("setSegundos");
        int segundos = 0;
        RelojSistema instance = new RelojSistema();
        instance.setSegundos(12);
       
        assertEquals(12,instance.getSegundos());
    }

    /**
     * Test of getMinutos method, of class RelojSistema.
     */
    @Test
    public void testGetMinutos() {
        System.out.println("getMinutos");
        RelojSistema instance = new RelojSistema();
        instance.setMinutos(55);
        int expResult = 55;
        int result = instance.getMinutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinutos method, of class RelojSistema.
     */
    @Test
    public void testSetMinutos() {
        System.out.println("setMinutos");
        int minutos = 0;
        RelojSistema instance = new RelojSistema();
        instance.setMinutos(30);
        assertEquals(30,instance.getMinutos());
    }

    /**
     * Test of getHoras method, of class RelojSistema.
     */
    @Test
    public void testGetHoras() {
        System.out.println("getHoras");
        RelojSistema instance = new RelojSistema();
        instance.setHoras(12);
        int expResult = 12;
        int result = instance.getHoras();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHoras method, of class RelojSistema.
     */
    @Test
    public void testSetHoras() {
        System.out.println("setHoras");
        int horas = 0;
        RelojSistema instance = new RelojSistema();
        instance.setHoras(30);
        assertEquals(30,instance.getHoras());
    }

    /**
     * Test of getSegundosFormatted method, of class RelojSistema.
     */
    @Test
    public void testGetSegundosFormatted() {
        System.out.println("getSegundosFormatted");
        RelojSistema instance = new RelojSistema();
        instance.setSegundos(10);
        String expResult = "10";
        String result = instance.getSegundosFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutosFormatted method, of class RelojSistema.
     */
    @Test
    public void testGetMinutosFormatted() {
        System.out.println("getMinutosFormatted");
        RelojSistema instance = new RelojSistema();
        instance.setMinutos(50);
        String expResult = "50";
        String result = instance.getMinutosFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHorasFormatted method, of class RelojSistema.
     */
    @Test
    public void testGetHorasFormatted() {
        System.out.println("getHorasFormatted");
        RelojSistema instance = new RelojSistema();
        instance.setHoras(13);
        String expResult = "13";
        String result = instance.getHorasFormatted();
        assertEquals(expResult, result);
    }

    /**
     * Test of tick method, of class RelojSistema.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        RelojSistema instance = new RelojSistema();
        instance.setSegundos(10);
        instance.tick();
        assertEquals(11,instance.getSegundos());
        
        instance.setSegundos(59);
        instance.tick();
        assertEquals(0,instance.getSegundos());
    }

    /**
     * Test of toString method, of class RelojSistema.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RelojSistema instance = new RelojSistema();
        instance.setSegundos(10);
        instance.setMinutos(11);
        instance.setHoras(1);
        String expResult = "01:11:10";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of run method, of class RelojSistemaSistema.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        RelojSistema instance = new RelojSistema();     
        instance.setSegundos(0);
        instance.run();    
        assertEquals(1,instance.getSegundos());
    }
}