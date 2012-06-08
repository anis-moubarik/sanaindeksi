/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.hajautustaulu;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author moubarik
 */
public class HajautusMapTest {
    
    HajautusMap<String, String[]> hm;
    
    @Before
    public void setUp() {
        hm = new HajautusMap<String, String[]>();
    }
    
    @Test
    public void insertTest(){
        String tiedosto = "testitiedosto.txt";
        String[] rivit = {"testi1", "testi2", "Kolmas rivi", "viides"};
        hm.put(tiedosto, rivit);
    }
}
