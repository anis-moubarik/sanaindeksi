/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.dynaaminentaulu;

import org.junit.*;
import static org.junit.Assert.*;
import tira.trie.TrieSolmu;

/**
 *
 * @author moubarik
 */
public class DynaaminenTauluTest {
    
    public DynaaminenTauluTest() {
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
     * Test of lisää method, of class DynaaminenTaulu.
     */
    @Test
    public void testLisää() {
        System.out.println("lis\u00e4\u00e4");
        TrieSolmu o = null;
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tyhjennäTaulu method, of class DynaaminenTaulu.
     */
    @Test
    public void testTyhjennäTaulu() {
        System.out.println("tyhjenn\u00e4Taulu");
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.tyhjennäTaulu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sisältää method, of class DynaaminenTaulu.
     */
    @Test
    public void testSisältää() {
        System.out.println("sis\u00e4lt\u00e4\u00e4");
        TrieSolmu elem = null;
        DynaaminenTaulu instance = new DynaaminenTaulu();
        boolean expResult = false;
        boolean result = instance.sisältää(elem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hae method, of class DynaaminenTaulu.
     */
    @Test
    public void testHae() {
        System.out.println("hae");
        int index = 0;
        DynaaminenTaulu instance = new DynaaminenTaulu();
        TrieSolmu expResult = null;
        TrieSolmu result = instance.hae(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onkoTyhjä method, of class DynaaminenTaulu.
     */
    @Test
    public void testOnkoTyhjä() {
        System.out.println("onkoTyhj\u00e4");
        DynaaminenTaulu instance = new DynaaminenTaulu();
        boolean expResult = false;
        boolean result = instance.onkoTyhjä();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poista method, of class DynaaminenTaulu.
     */
    @Test
    public void testPoista() {
        System.out.println("poista");
        int index = 0;
        DynaaminenTaulu instance = new DynaaminenTaulu();
        TrieSolmu expResult = null;
        TrieSolmu result = instance.poista(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class DynaaminenTaulu.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DynaaminenTaulu instance = new DynaaminenTaulu();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of järjestäTaulu method, of class DynaaminenTaulu.
     */
    @Test
    public void testJärjestäTaulu() {
        System.out.println("j\u00e4rjest\u00e4Taulu");
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.järjestäTaulu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of etsi method, of class DynaaminenTaulu.
     */
    @Test
    public void testEtsi() {
        System.out.println("etsi");
        char c = ' ';
        DynaaminenTaulu instance = new DynaaminenTaulu();
        TrieSolmu expResult = null;
        TrieSolmu result = instance.etsi(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
