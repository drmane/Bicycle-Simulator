/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciclistas_bicicleta;

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
public class BicicletaTest {
    
    public BicicletaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularDiametroBicicleta method, of class Bicicleta.
     */
    @Test
    public void testCalcularDiametroBicicleta() {
        System.out.println("calcularDiametroBicicleta");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        double expResult = 0.74;
        double result = instance.calcularDiametroBicicleta();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularRecorridoLineal method, of class Bicicleta.
     */
    @Test
    public void testCalcularRecorridoLineal() {
        System.out.println("calcularRecorridoLineal");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        double expResult = 2.32;
        double result = instance.calcularRecorridoLineal();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of aumentarPlato method, of class Bicicleta.
     */
    @Test
    public void testAumentarPlato() {
        System.out.println("aumentarPlato");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.aumentarPlato();
        
        assertEquals(1,instance.getPlatoActual());
    }

    /**
     * Test of isDestruida method, of class Bicicleta.
     */
    @Test
    public void testIsDestruida() {
        System.out.println("isDestruida");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        boolean expResult = false;
        boolean result = instance.isDestruida();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestruida method, of class Bicicleta.
     */
    @Test
    public void testSetDestruida() {
        System.out.println("setDestruida");
        boolean destruida = true;
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.setDestruida(destruida);
        assertEquals(true,instance.isDestruida());
    }

    /**
     * Test of disminuirPlato method, of class Bicicleta.
     */
    @Test
    public void testDisminuirPlato() {
        System.out.println("disminuirPlato");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.disminuirPlato();
        assertEquals(0,instance.getPlatoActual());
    }

    /**
     * Test of aumentarPinon method, of class Bicicleta.
     */
    @Test
    public void testAumentarPinon() {
        System.out.println("aumentarPinon");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.aumentarPinon();
        assertEquals(1,instance.getPinonActual());
    }

    /**
     * Test of disminuirPinon method, of class Bicicleta.
     */
    @Test
    public void testDisminuirPinon() {
        System.out.println("disminuirPinon");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.disminuirPinon();
        assertEquals(0,instance.getPinonActual());
    }

    /**
     * Test of calcularRelacionDeTransmision method, of class Bicicleta.
     */
    @Test
    public void testCalcularRelacionDeTransmision() {
        System.out.println("calcularRelacionDeTransmision");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        double expResult = 2.25;
        double result = instance.calcularRelacionDeTransmision();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularEspacioPorCadaPedalada method, of class Bicicleta.
     */
    @Test
    public void testCalcularEspacioPorCadaPedalada() {
        System.out.println("calcularEspacioPorCadaPedalada");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        double expResult = 5.23;
        double result = instance.calcularEspacioPorCadaPedalada();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcularAceleracionFactoresExternos method, of class Bicicleta.
     */
    @Test
    public void testCalcularAceleracionFactoresExternos() {
        System.out.println("calcularAceleracionFactoresExternos");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        double expResult = -0.00098;
        double result = instance.calcularAceleracionFactoresExternos();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of actualizarPendiente method, of class Bicicleta.
     */
    @Test
    public void testActualizarPendiente() {
        System.out.println("actualizarPendiente");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.actualizarPendiente();
    }

    /**
     * Test of acelera method, of class Bicicleta.
     */
    @Test
    public void testAcelera() {
        System.out.println("acelera");
        double aceleracion = 13.00;
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.acelera(aceleracion);
        assertEquals(13.00,instance.getAceleracion(),0.01);
    }

    /**
     * Test of desplazar method, of class Bicicleta.
     */
    @Test
    public void testDesplazar() {
        System.out.println("desplazar");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        instance.desplazar();
    }

    /**
     * Test of infoPlatos method, of class Bicicleta.
     */
    @Test
    public void testInfoPlatos() {
        System.out.println("infoPlatos");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "1 con 36 dientes";
        String result = instance.infoPlatos();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoPinon method, of class Bicicleta.
     */
    @Test
    public void testInfoPinon() {
        System.out.println("infoPinon");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "1 con 16 dientes";
        String result = instance.infoPinon();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoVelocidad method, of class Bicicleta.
     */
    @Test
    public void testInfoVelocidad() {
        System.out.println("infoVelocidad");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "0,00 m/s";
        String result = instance.infoVelocidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoDistanciaRecorrida method, of class Bicicleta.
     */
    @Test
    public void testInfoDistanciaRecorrida() {
        System.out.println("infoDistanciaRecorrida");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "0,000 km";
        String result = instance.infoDistanciaRecorrida();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoPendiente method, of class Bicicleta.
     */
    @Test
    public void testInfoPendiente() {
        System.out.println("infoPendiente");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "0,00% -0,00 m/s2 LLANO";
        String result = instance.infoPendiente();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoAceleracion method, of class Bicicleta.
     */
    @Test
    public void testInfoAceleracion() {
        System.out.println("infoAceleracion");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "0,0000 m/s2";
        String result = instance.infoAceleracion();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoPendienteAceleracion method, of class Bicicleta.
     */
    @Test
    public void testInfoPendienteAceleracion() {
        System.out.println("infoPendienteAceleracion");
        Bicicleta instance = new Bicicleta(new Eolo(new Reloj()), new PendioloCurviolo());
        String expResult = "-0,0010 m/s2";
        String result = instance.infoPendienteAceleracion();
        assertEquals(expResult, result);
    }
}