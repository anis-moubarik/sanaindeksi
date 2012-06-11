
package tira.hajautustaulu;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 *
 * @author Anis
 */
public class HajautusMapDTTest {
    
    private HajautusMapDT hm;
    
    @Before
    public void setUp() {
        hm = new HajautusMapDT();
    }
    
    @Test
    public void insertTest(){
        String tiedosto = "testitiedosto.txt";
        DynaaminenTauluInterface<Integer> dt = new DynaaminenTauluInt();
        int[] numerot = {5, 6, 1, 500, 1385};
        dt.lisää(5); dt.lisää(6); dt.lisää(1); dt.lisää(500); dt.lisää(1385);
        hm.put(tiedosto, dt);
        hm.put("asdasdas", dt);
        hm.put("kalevala.txt", dt);
        hm.put("testi", dt);
        hm.put("testi2", dt);
        hm.put("pprrr", dt);
        DynaaminenTauluInterface<Integer> haku = hm.get("testi");
                
        for (int i = 0; i < haku.size(); i++) {
            boolean tulos = haku.hae(i) == numerot[i];
            assertEquals(true, tulos);   
        }
        
    }
    
    @Test
    public void rehashTest(){
        hm.rehash();
    }
}
