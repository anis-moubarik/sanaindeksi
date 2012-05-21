package tira.fileIO;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
}
