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
public class RelojAplicacionTest {
    
    public RelojAplicacionTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContadorDuracionDeIteracion method, of class RelojAplicacion.
     */
    @Test
    public void testGetContadorDuracionDeIteracion() {
        System.out.println("getContadorDuracionDeIteracion");
        RelojAplicacion instance = new RelojAplicacion();
        instance.setContadorDuracionDeIteracion(300);
        int expResult = 300;
        int result = instance.getContadorDuracionDeIteracion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContadorDuracionDeIteracion method, of class RelojAplicacion.
     */
    @Test
    public void testSetContadorDuracionDeIteracion() {
        System.out.println("setContadorDuracionDeIteracion");
        int ContadorDuracionDeIteracion = 0;
        RelojAplicacion instance = new RelojAplicacion();
        instance.setContadorDuracionDeIteracion(101);
        assertEquals(101,instance.getContadorDuracionDeIteracion());
    }

    /**
     * Test of getrelacionIteracionSegundo method, of class RelojAplicacion.
     */
    @Test
    public void testGetrelacionIteracionSegundo() {
        System.out.println("getrelacionIteracionSegundo");
        int expResult = 1000;
        int result = RelojAplicacion.getrelacionIteracionSegundo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setrelacionIteracionSegundo method, of class RelojAplicacion.
     */
    @Test
    public void testSetrelacionIteracionSegundo() {
        System.out.println("setrelacionIteracionSegundo");
        int periodoImpulsos = 0;
        RelojAplicacion instance = new RelojAplicacion();
        instance.setrelacionIteracionSegundo(300);
        assertEquals(300,RelojAplicacion.getrelacionIteracionSegundo());
    }

    /**
     * Test of ejecutar method, of class RelojAplicacion.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        RelojAplicacion instance = new RelojAplicacion();
        instance.setContadorDuracionDeIteracion(0);
        instance.ejecutar();
        assertEquals(1,instance.getSegundos());
        assertEquals(300,instance.getContadorDuracionDeIteracion());
    }
}