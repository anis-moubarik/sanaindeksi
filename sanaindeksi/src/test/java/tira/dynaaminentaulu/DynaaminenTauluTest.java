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
    
    @Test
    public void testLisää() {
        TrieSolmu o = new TrieSolmu('a', false, 1);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(o);
        assertEquals('a', o.getKirjain());
        assertEquals(false, o.isOnkoSana());
        assertEquals(1, o.getRivit().get(0));
    }

    /**
     * Test of tyhjennäTaulu method, of class DynaaminenTaulu.
     */
    @Test
    public void testTyhjennäTaulu() {
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(new TrieSolmu('a', false, 1));
        instance.tyhjennäTaulu();
        assertEquals(true, instance.onkoTyhjä());
    }

    /**
     * Test of sisältää method, of class DynaaminenTaulu.
     */
    @Test
    public void testSisältää() {
        TrieSolmu elem = new TrieSolmu('b', true, 22);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(elem);
        boolean expResult = true;
        boolean result = instance.sisältää(elem);
        assertEquals(expResult, result);
    }

    /**
     * Test of hae method, of class DynaaminenTaulu.
     */
    @Test
    public void testHae() {
        int index = 0;
        TrieSolmu tr = new TrieSolmu('c', false, 34);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(tr);
        TrieSolmu expResult = tr;
        TrieSolmu result = instance.hae(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of onkoTyhjä method, of class DynaaminenTaulu.
     */
    @Test
    public void testOnkoTyhjä() {
        DynaaminenTaulu instance = new DynaaminenTaulu();
        boolean expResult = true;
        boolean result = instance.onkoTyhjä();
        assertEquals(expResult, result);
    }

    /**
     * Test of poista method, of class DynaaminenTaulu.
     */
    @Test
    public void testPoista() {
        int index = 0;
        TrieSolmu tr = new TrieSolmu('d', true, 33);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(tr);
        TrieSolmu expResult = tr;
        TrieSolmu result = instance.poista(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class DynaaminenTaulu.
     */
    @Test
    public void testSize() {
        DynaaminenTaulu instance = new DynaaminenTaulu();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of järjestäTaulu method, of class DynaaminenTaulu.
     */
    @Test
    public void testJärjestäTaulu() {
        DynaaminenTaulu instance = new DynaaminenTaulu();
        TrieSolmu tr = new TrieSolmu('a', true, 2);
        TrieSolmu tr2 = new TrieSolmu('b', true, 1);
        instance.lisää(tr); instance.lisää(tr2);
        instance.järjestäTaulu();
        assertEquals(instance.hae(0), tr);
        assertEquals(instance.hae(1), tr2);
    }

    /**
     * Test of etsi method, of class DynaaminenTaulu.
     */
    @Test
    public void testEtsi() {
        char c = 'a';
        TrieSolmu tr = new TrieSolmu('a', false, 55);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(tr);
        TrieSolmu expResult = tr;
        TrieSolmu result = instance.etsi(c);
        assertEquals(expResult, result);

    }
}
