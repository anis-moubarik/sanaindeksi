package tira.fileIO;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author moubarik
 */
public class TiedostonLukuTest{
    
    TiedostonLuku tl;
    
    @Before
    public void setUp(){
        tl = new TiedostonLuku();
    }
    
    @Test
    public void tiedostonluku(){
        String[] testi = null;
        try {
            testi = tl.lueRivitTaulukkoon("kalevala.txt");
        } catch (IOException ex) {
            Logger.getLogger(TiedostonLukuTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(testi[0]);
    }

    /**
     * Test of lueRivitTaulukkoon method, of class TiedostonLuku.
     */
    @Test
    public void testLueRivitTaulukkoon() throws Exception {
        System.out.println("lueRivitTaulukkoon");
        String tiedostonimi = "";
        TiedostonLuku instance = new TiedostonLuku();
        String[] expResult = null;
        String[] result = instance.lueRivitTaulukkoon(tiedostonimi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lueTiedostoMuistiin method, of class TiedostonLuku.
     */
    @Test
    public void testLueTiedostoMuistiin() throws Exception {
        System.out.println("lueTiedostoMuistiin");
        String tiedostonimi = "";
        TiedostonLuku instance = new TiedostonLuku();
        String expResult = "";
        String result = instance.lueTiedostoMuistiin(tiedostonimi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
