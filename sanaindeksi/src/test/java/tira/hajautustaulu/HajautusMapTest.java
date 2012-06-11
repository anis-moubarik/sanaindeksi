/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.hajautustaulu;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author moubarik
 */
public class HajautusMapTest {
    
    HajautusMap hm;
    
    @Before
    public void setUp() {
        hm = new HajautusMap(5);
    }
    
    @Test
    public void insertTest(){
        String tiedosto = "testitiedosto.txt";
        String[] rivit = {"testi1", "testi2", "Kolmas rivi", "viides"};
        hm.put(tiedosto, rivit);
        hm.put("asdasdas", rivit);
        hm.put("kalevala.txt", rivit);
        hm.put("testi", rivit);
        hm.put("testi2", rivit);
        hm.put("pprrr", rivit);
        String[] haku = hm.get("testi");
                
        for (int i = 0; i < haku.length; i++) {
            boolean tulos = haku[i].equals(rivit[i]);
            assertEquals(true, tulos);   
        }
        
    }
    
    @Test
    public void rehashTest(){
        hm.rehash();
    }
}
