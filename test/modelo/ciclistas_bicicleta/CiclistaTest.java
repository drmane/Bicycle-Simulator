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
public class CiclistaTest {
    
    public CiclistaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aumentarTiempoDeDuracionDePedalada method, of class Ciclista.
     */
    @Test
    public void testAumentarTiempoDeDuracionDePedalada() {
        System.out.println("aumentarTiempoDeDuracionDePedalada");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.aumentarTiempoDeDuracionDePedalada();
    }

    /**
     * Test of disminuirTiempoDeDuracionDePedalada method, of class Ciclista.
     */
    @Test
    public void testDisminuirTiempoDeDuracionDePedalada() {
        System.out.println("disminuirTiempoDeDuracionDePedalada");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.disminuirTiempoDeDuracionDePedalada();
    }

    /**
     * Test of calcularGastoFuerzaPedalada method, of class Ciclista.
     */
    @Test
    public void testCalcularGastoFuerzaPedalada() {
        System.out.println("calcularGastoFuerzaPedalada");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        double expResult = 0.0;
        double result = instance.calcularGastoFuerzaPedalada();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularAceleracionResultante method, of class Ciclista.
     */
    @Test
    public void testCalcularAceleracionResultante() {
        System.out.println("calcularAceleracionResultante");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        double expResult = 0.0;
        double result = instance.calcularAceleracionResultante();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularAceleracionParaGastoDeFuerza method, of class Ciclista.
     */
    @Test
    public void testCalcularAceleracionParaGastoDeFuerza() {
        System.out.println("calcularAceleracionParaGastoDeFuerza");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        double expResult = 0.0;
        double result = instance.calcularAceleracionParaGastoDeFuerza();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of darPedalada method, of class Ciclista.
     */
    @Test
    public void testDarPedalada() {
        System.out.println("darPedalada");
        double AceleracionATransmitir = 0.0;
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.darPedalada(AceleracionATransmitir);
    }

    /**
     * Test of aumentarCadencia method, of class Ciclista.
     */
    @Test
    public void testAumentarCadencia() {
        System.out.println("aumentarCadencia");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.aumentarCadencia();
    }

    /**
     * Test of disminuirCadencia method, of class Ciclista.
     */
    @Test
    public void testDisminuirCadencia() {
        System.out.println("disminuirCadencia");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.disminuirCadencia();
    }

    /**
     * Test of frenaTotal method, of class Ciclista.
     */
    @Test
    public void testFrenaTotal() {
        System.out.println("frenaTotal");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.frenaTotal();
    }

    /**
     * Test of frenaMas method, of class Ciclista.
     */
    @Test
    public void testFrenaMas() {
        System.out.println("frenaMas");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.frenaMas();
    }

    /**
     * Test of frenaMenos method, of class Ciclista.
     */
    @Test
    public void testFrenaMenos() {
        System.out.println("frenaMenos");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.frenaMenos();
    }

    /**
     * Test of ejecutar method, of class Ciclista.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        instance.ejecutar();
    }

    /**
     * Test of calcularAceleracionCiclista method, of class Ciclista.
     */
    @Test
    public void testCalcularAceleracionCiclista() {
        System.out.println("calcularAceleracionCiclista");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        double expResult = 0.00000523;
        double result = instance.calcularAceleracionCiclista();
        assertEquals(expResult, result, 0.00000001);
    }

    /**
     * Test of calcularAcelaracionAtransmitir method, of class Ciclista.
     */
    @Test
    public void testCalcularAcelaracionAtransmitir() {
        System.out.println("calcularAcelaracionAtransmitir");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        double expResult = 0.0;
        double result = instance.calcularAcelaracionAtransmitir();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of infoCadencia method, of class Ciclista.
     */
    @Test
    public void testInfoCadencia() {
        System.out.println("infoCadencia");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        String expResult = "60";
        String result = instance.infoCadencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoTiempoDeDuracionDePedalada method, of class Ciclista.
     */
    @Test
    public void testInfoTiempoDeDuracionDePedalada() {
        System.out.println("infoTiempoDeDuracionDePedalada");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        String expResult = "1000.0";
        String result = instance.infoTiempoDeDuracionDePedalada();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoPeriodo method, of class Ciclista.
     */
    @Test
    public void testInfoPeriodo() {
        System.out.println("infoPeriodo");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        String expResult = "1000,00";
        String result = instance.infoPeriodo();
        assertEquals(expResult, result);
    }

    /**
     * Test of infoFuerza method, of class Ciclista.
     */
     @Test
    public void testInfoFuerza() {
        System.out.println("infoFuerza");
        Ciclista instance = new Ciclista(new Bicicleta(new Eolo(new Reloj()),new PendioloCurviolo()));
        String expResult = "1000,00";
        String result = instance.infoFuerza();
        assertEquals(expResult, result);
    }
}