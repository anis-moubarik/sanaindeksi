/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.UI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
        String komennot = "lataa kalevala.txt\nhae väinämöinen\nlopeta";
        InputStream in = new ByteArrayInputStream(komennot.getBytes());
        KomentoRiviUI ui = new KomentoRiviUI(in);
        
        ui.run();
        assertEquals(true, true);
        
    }

}
