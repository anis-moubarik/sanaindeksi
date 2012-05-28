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

    /**
     * Test of getKirjain method, of class TrieSolmu.
     */
    @Test
    public void testGetKirjain() {
        TrieSolmu instance = new TrieSolmu('a', false, 1);
        char expResult = 'a';
        char result = instance.getKirjain();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKirjain method, of class TrieSolmu.
     */
    @Test
    public void testSetKirjain() {
        char kirjain = 'b';
        TrieSolmu instance = new TrieSolmu('d', true, 334);
        instance.setKirjain(kirjain);
        assertEquals(kirjain, instance.getKirjain());
    }


    /**
     * Test of isOnkoSana method, of class TrieSolmu.
     */
    @Test
    public void testIsOnkoSana() {
        TrieSolmu instance = new TrieSolmu('c', false, 644);
        boolean expResult = false;
        boolean result = instance.isOnkoSana();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOnkoSana method, of class TrieSolmu.
     */
    @Test
    public void testSetOnkoSana() {
        boolean onkoSana = false;
        TrieSolmu instance = new TrieSolmu('k', true, 655);
        instance.setOnkoSana(onkoSana);
        assertEquals(false, instance.onkoSana);
    }

    /**
     * Test of lisääRivi method, of class TrieSolmu.
     */
    @Test
    public void testLisääRivi() {
        int rivi = 0;
        TrieSolmu instance = new TrieSolmu('o', true, 5);
        instance.lisääRivi(rivi);
        assertEquals(rivi, instance.getRivit().get(1));

    }
}
