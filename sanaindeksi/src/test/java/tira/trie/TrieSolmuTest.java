package tira.trie;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
        TrieSolmu instance = new TrieSolmu('a', false);
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
        TrieSolmu instance = new TrieSolmu('d', true);
        instance.setKirjain(kirjain);
        assertEquals(kirjain, instance.getKirjain());
    }


    /**
     * Test of isOnkoSana method, of class TrieSolmu.
     */
    @Test
    public void testIsOnkoSana() {
        TrieSolmu instance = new TrieSolmu('c', false);
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
        TrieSolmu instance = new TrieSolmu('k', true);
        instance.setOnkoSana(onkoSana);
        assertEquals(false, instance.onkoSana);
    }
}
