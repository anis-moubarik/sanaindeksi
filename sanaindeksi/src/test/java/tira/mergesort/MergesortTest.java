/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.mergesort;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author moubarik
 */
public class MergesortTest {
    
    MergesortInterface ms;
    
    @Before
    public void setUp() {
        ms = new Mergesort();
    }

    /**
     * Test of sort method, of class Mergesort.
     */
    @Test
    public void testSort() {
        String[] järjestettävä = {"Kalevala", "Väinämöinen", "Aino", "sampo", "Lönnrot", "Runo", "Elias", "ratikka"};
        String[] oikeaJärjestys = {"Aino", "Elias", "Kalevala", "Lönnrot", "ratikka", "Runo", "sampo", "Väinämöinen"};
        ms.sort(järjestettävä);
        for (int i = 0; i < oikeaJärjestys.length; i++) {
            assertEquals(true, järjestettävä[i].equals(oikeaJärjestys[i]));
            
        }
    }
}
