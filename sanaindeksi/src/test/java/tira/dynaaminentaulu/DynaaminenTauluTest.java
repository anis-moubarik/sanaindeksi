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
        TrieSolmu o = new TrieSolmu('a', false);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(o);
        assertEquals('a', o.getKirjain());
        assertEquals(false, o.isOnkoSana());
    }

    /**
     * Test of tyhjennäTaulu method, of class DynaaminenTaulu.
     */
    @Test
    public void testTyhjennäTaulu() {
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(new TrieSolmu('a', false));
        instance.tyhjennäTaulu();
        assertEquals(true, instance.onkoTyhjä());
    }

    /**
     * Test of sisältää method, of class DynaaminenTaulu.
     */
    @Test
    public void testSisältää() {
        TrieSolmu elem = new TrieSolmu('b', true);
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
        TrieSolmu tr = new TrieSolmu('c', false);
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
        TrieSolmu tr = new TrieSolmu('d', true);
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
        TrieSolmu tr = new TrieSolmu('a', true);
        TrieSolmu tr2 = new TrieSolmu('b', true);
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
        TrieSolmu tr = new TrieSolmu('a', false);
        DynaaminenTaulu instance = new DynaaminenTaulu();
        instance.lisää(tr);
        TrieSolmu expResult = tr;
        TrieSolmu result = instance.etsi(c);
        assertEquals(expResult, result);

    }
    
    @Test
    public void IntLisäysTesti(){
        DynaaminenTauluInt instance = new DynaaminenTauluInt();
        instance.lisää(2);
        assertEquals(2, (int)instance.hae(0));
    }
    
    @Test
    public void IntSisältääköTesti(){
        DynaaminenTauluInt instance = new DynaaminenTauluInt();
        instance.lisää(3);
        assertEquals(true, instance.sisältää(3));
    }
    
    @Test
    public void IntOnkoTyhjäTesti(){
        DynaaminenTauluInt instance = new DynaaminenTauluInt();
        assertEquals(true, instance.onkoTyhjä());
    }
    
    @Test
    public void IntPoistoTesti(){
        DynaaminenTauluInt instance = new DynaaminenTauluInt();
        instance.lisää(3);
        instance.lisää(5);
        instance.poista(1);
        assertEquals(true, instance.size() == 1);
    }
    
    @Test
    public void IntHakuTesti(){
        DynaaminenTauluInt instance = new DynaaminenTauluInt();
        instance.lisää(1); instance.lisää(2); instance.lisää(3);
        int lol = instance.etsi(2);
        assertEquals(2, lol);
    }
    
    @Test
    public void StringLisäysTesti(){
        DynaaminenTauluString instance = new DynaaminenTauluString();
        instance.lisää("testi");
        assertEquals("testi", instance.hae(0));
    }
    
    @Test
    public void StringSisältääköTesti(){
        DynaaminenTauluString instance = new DynaaminenTauluString();
        instance.lisää("three");
        assertEquals(true, instance.sisältää("three"));
    }
    
    @Test
    public void StringOnkoTyhjäTesti(){
        DynaaminenTauluString instance = new DynaaminenTauluString();
        assertEquals(true, instance.onkoTyhjä());
    }
    
    @Test
    public void StringPoistoTesti(){
        DynaaminenTauluString instance = new DynaaminenTauluString();
        instance.lisää("one");
        instance.lisää("three");
        instance.poista(1);
        assertEquals(true, instance.size() == 1);
        assertEquals("one", instance.hae(0));
    }
    
    @Test
    public void StringHakuTesti(){
        DynaaminenTauluString instance = new DynaaminenTauluString();
        instance.lisää("one"); instance.lisää("two"); instance.lisää("three");
        String two = instance.etsi("two");
        assertEquals("two", two);
    }
}
