/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.UI;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author moubarik
 */
public class KomentoRiviUITest {
    
    public KomentoRiviUITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class KomentoRiviUI.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        KomentoRiviUI instance = new KomentoRiviUI();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lataa method, of class KomentoRiviUI.
     */
    @Test
    public void testLataa() throws Exception {
        System.out.println("lataa");
        String tiedosto = "";
        KomentoRiviUI instance = new KomentoRiviUI();
        instance.lataa(tiedosto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
