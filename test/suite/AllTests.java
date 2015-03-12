/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suite;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Daniel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({modelo.factores_externos.pendiolo.PendioloCurvioloTest.class, modelo.factores_externos.pendiolo.SentidoPendienteTest.class, modelo.factores_externos.pendiolo.PendioloTest.class,modelo.factores_externos.eolo.EoloTest.class, modelo.factores_externos.eolo.SentidoVientoTest.class,modelo.ciclistas_bicicleta.CiclistaTest.class, modelo.ciclistas_bicicleta.BicicletaTest.class, modelo.ciclistas_bicicleta.ListaCiclistasTest.class,modelo.Tiempo.RelojTest.class, modelo.Tiempo.RelojAplicacionTest.class, modelo.Tiempo.RelojSistemaTest.class,modelo.ModeloTest.class})
public class AllTests {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}