/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.UI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;

/**
 *
 * @author moubarik
 */
public class KomentoRiviUITest {


    /**
     * Test of lataa method, of class KomentoRiviUI.
     */
<<<<<<< HEAD
//    @Test
//    public void testLataa() throws Exception {
//        KomentoRiviUI instance = new KomentoRiviUI();
//        instance.run();
//        String komennot = "lataa kalevala.txt\nhae Väinämöinen\nlopeta";
//        InputStream stdin = System.in;
//        try{
//            System.setIn(new ByteArrayInputStream(komennot.getBytes()));
//            Scanner sc = new Scanner(System.in);
//            System.out.println(sc.nextLine());
//        }finally{
//            System.setIn(stdin);
//        }
//
//
//        
//    }
=======
    @Test
    public void testLataa() throws Exception {
        String komennot = "lataa kalevala.txt\nhae väinämöinen\nlopeta";
        InputStream in = new ByteArrayInputStream(komennot.getBytes());
        KomentoRiviUI ui = new KomentoRiviUI(in);
        
        ui.run();        
    }

>>>>>>> 5442478e2d100e80453799b196496c4ae5add7d6
}
