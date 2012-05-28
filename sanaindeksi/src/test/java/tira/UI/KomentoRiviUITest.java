/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.UI;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author moubarik
 */
public class KomentoRiviUITest {


    /**
     * Test of lataa method, of class KomentoRiviUI.
     */
    @Test
    public void testLataa() throws Exception {
        String tiedosto = "kalevala.txt";
        KomentoRiviUI instance = new KomentoRiviUI();
        instance.lataa(tiedosto);
        
    }
}
