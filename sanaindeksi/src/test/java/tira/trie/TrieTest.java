
package tira.trie;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class TrieTest {
    
    
    //Alustavat testi vielä toistaiseksi mainissa.
    Trie puu;
    
    @Before
    public void setUp(){
        puu = new Trie();
    }
    
    
    //Ei vielä tee mitään, ennen kuin etsimis operaatio toteutetaan Trielle.
    @Test
    public void lisäysTrieen(){
        String[] sanat = {"sana", "ananas", "kana", "puhelin", "sanoma", "puuhamaa", "kirjasto"};
        int[] rivit = {0};
        int i = 0;
        long lisäysStart = System.currentTimeMillis();
        for (String sana : sanat){
            rivit[0] = i;
            puu.lisääSana(sana, rivit);
            i++;
        }
        long lisäysEnd = System.currentTimeMillis();
        
        long start = System.currentTimeMillis();
        for (String sana : sanat){
            boolean tulos = puu.etsiSana(sana);
            assertEquals(true, tulos);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("-------------------lisäysTrieen testi-----------------");
        System.out.println("Aikaa meni etsimiseen: "+(end-start)+" millisekuntia.");
        System.out.println("Start: "+start);
        System.out.println("End: "+end);
        System.out.println("Aikaa meni tallentamiseen: "+(lisäysEnd - lisäysStart)+" millisekuntia");
        System.out.println("Start: "+lisäysStart);
        System.out.println("End: "+lisäysEnd);
        System.out.println("-------------------------------------------------------");
    }
    
    @Test
    public void etsiminenTriestä(){
        
    }
}
