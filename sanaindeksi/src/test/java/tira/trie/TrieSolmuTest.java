/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.trie;

import java.util.LinkedList;
import org.junit.*;
import static org.junit.Assert.*;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 *
 * @author moubarik
 */
public class TrieSolmuTest {
    
    public TrieSolmuTest() {
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
     * Test of getKirjain method, of class TrieSolmu.
     */
    @Test
    public void testGetKirjain() {
        System.out.println("getKirjain");
        TrieSolmu instance = null;
        char expResult = ' ';
        char result = instance.getKirjain();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKirjain method, of class TrieSolmu.
     */
    @Test
    public void testSetKirjain() {
        System.out.println("setKirjain");
        char kirjain = ' ';
        TrieSolmu instance = null;
        instance.setKirjain(kirjain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLapset method, of class TrieSolmu.
     */
    @Test
    public void testGetLapset() {
        System.out.println("getLapset");
        TrieSolmu instance = null;
        DynaaminenTauluInterface expResult = null;
        DynaaminenTauluInterface result = instance.getLapset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLapset method, of class TrieSolmu.
     */
    @Test
    public void testSetLapset() {
        System.out.println("setLapset");
        DynaaminenTauluInterface lapset = null;
        TrieSolmu instance = null;
        instance.setLapset(lapset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnkoSana method, of class TrieSolmu.
     */
    @Test
    public void testIsOnkoSana() {
        System.out.println("isOnkoSana");
        TrieSolmu instance = null;
        boolean expResult = false;
        boolean result = instance.isOnkoSana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnkoSana method, of class TrieSolmu.
     */
    @Test
    public void testSetOnkoSana() {
        System.out.println("setOnkoSana");
        boolean onkoSana = false;
        TrieSolmu instance = null;
        instance.setOnkoSana(onkoSana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRivit method, of class TrieSolmu.
     */
    @Test
    public void testGetRivit() {
        System.out.println("getRivit");
        TrieSolmu instance = null;
        LinkedList expResult = null;
        LinkedList result = instance.getRivit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRivit method, of class TrieSolmu.
     */
    @Test
    public void testSetRivit() {
        System.out.println("setRivit");
        LinkedList rivit = null;
        TrieSolmu instance = null;
        instance.setRivit(rivit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisääRivi method, of class TrieSolmu.
     */
    @Test
    public void testLisääRivi() {
        System.out.println("lis\u00e4\u00e4Rivi");
        int rivi = 0;
        TrieSolmu instance = null;
        instance.lisääRivi(rivi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
