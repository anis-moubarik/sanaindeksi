/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.mergesort;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tira.trie.TrieSolmu;

/**
 *
 * @author moubarik
 */
public class MergesortTest {
    
    MergesortInterface<String> ms;
    MergesortInterface<Integer> ms1;
    MergesortInterface<TrieSolmu> ms2;
    TrieSolmu t1, t2 ,t3, t4, t5;
    
    @Before
    public void setUp() {
        ms = new Mergesort();
        ms1 = new MergesortInt();
        ms2 = new MergesortTS();
        t1 = new TrieSolmu('a', false);
        t2 = new TrieSolmu('b', true);
        t3 = new TrieSolmu('c', true);
        t4 = new TrieSolmu('d', false);
        t5 = new TrieSolmu('e', true);
    }

    /**
     * Test of sort method, of class Mergesort.
     */
    @Test
    public void testSortString() {
        String[] järjestettävä = {"Kalevala", "Väinämöinen", "Aino", "sampo", "Lönnrot", "Runo", "Elias", "ratikka"};
        String[] oikeaJärjestys = {"Aino", "Elias", "Kalevala", "Lönnrot", "ratikka", "Runo", "sampo", "Väinämöinen"};
        ms.sort(järjestettävä, järjestettävä.length);
        for (int i = 0; i < oikeaJärjestys.length; i++) {
            assertEquals(true, järjestettävä[i].equals(oikeaJärjestys[i]));
            
        }
    }
    
    @Test
    public void testSortInt() {
        Integer[] järjestettävä = {10, 5, 3, 8, 6, 4, 1, 2, 7, 9};
        Integer[] oikeaJärjestys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ms1.sort(järjestettävä, järjestettävä.length);
        for (int i = 0; i < oikeaJärjestys.length; i++) {
            assertEquals(true, järjestettävä[i] == oikeaJärjestys[i]);
            
        }
    }
        
    @Test
    public void testSortTS() {
        
        
        
        TrieSolmu[] järjestettävä = {t5, t1, t2, t4, t3};
        TrieSolmu[] oikeaJärjestys = {t1, t2, t3, t4, t5};
        ms2.sort(järjestettävä, järjestettävä.length);
        for (int i = 0; i < oikeaJärjestys.length; i++) {
            assertEquals(true, järjestettävä[i].equals(oikeaJärjestys[i]));
            
        }
    }
}
