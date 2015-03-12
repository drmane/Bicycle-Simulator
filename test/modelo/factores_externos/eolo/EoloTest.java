/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.eolo;

import modelo.Tiempo.Reloj;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class EoloTest {
    
    public EoloTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSentido method, of class Eolo.
     */
    @Test
    public void testSetSentido() {
        System.out.println("setSentido");
        SentidoViento sentido = SentidoViento.AFAVOR;
        Eolo instance = new Eolo(new Reloj());
        instance.setSentido(sentido);
        assertEquals(SentidoViento.AFAVOR,instance.getSentido());
    }

    /**
     * Test of setVelocidadViento method, of class Eolo.
     */
    @Test
    public void testSetVelocidadViento() {
        System.out.println("setVelocidadViento");
        double velocidad = 1.11;
        Eolo instance = new Eolo(new Reloj());
        instance.setVelocidadViento(velocidad);
        assertEquals(1.11,instance.getVelocidadViento(),0.01);
    }

    /**
     * Test of getSentido method, of class Eolo.
     */
    @Test
    public void testGetSentido() {
        System.out.println("getSentido");
        Eolo instance = new Eolo(new Reloj());;
        instance.setSentido(SentidoViento.NULO);
        SentidoViento expResult = SentidoViento.NULO;
        SentidoViento result = instance.getSentido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVelocidadViento method, of class Eolo.
     */
    @Test
    public void testGetVelocidadViento() {
        System.out.println("getVelocidadViento");
        Eolo instance = new Eolo(new Reloj());;
        double expResult = 13.00;
        instance.setVelocidadViento(13.00);
        double result = instance.getVelocidadViento();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of anadirViento method, of class Eolo.
     */
    @Test
    public void testAnadirViento() {
        System.out.println("anadirViento");
        String hora = "00:11:13";
        String sentido = "NULO";
        double velocidad = 12.00;
        Eolo instance = new Eolo(new Reloj());;
        instance.anadirViento(hora, sentido, velocidad);
    }

    /**
     * Test of getAceleracionViento method, of class Eolo.
     */
    @Test
    public void testGetAceleracionViento() {
        System.out.println("getAceleracionViento");
        Eolo instance = new Eolo(new Reloj());
        double expResult = 0.0;
        double result = instance.getAceleracionViento();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of ejecutar method, of class Eolo.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        Eolo instance = new Eolo(new Reloj());
        instance.setVelocidadViento(0);
        instance.setSentido(SentidoViento.NULO);
        instance.ejecutar();
        assertEquals(SentidoViento.NULO,instance.getSentido());
        assertEquals(0,instance.getVelocidadViento(),0.01);
    }

    /**
     * Test of infoAceleracionViento method, of class Eolo.
     */
    @Test
    public void testInfoAceleracionViento() {
        System.out.println("infoAceleracionViento");
        Eolo instance = new Eolo(new Reloj());
        String expResult = "0,0000 m/s2 ";
        String result = instance.infoAceleracionViento();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Eolo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Eolo instance =  new Eolo(new Reloj());
        String expResult = "0,0000 m/s2 NULO 0,00 km/h";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}