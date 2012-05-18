
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
        String[] sanat = {"sana", "ananas", "kana", "puhelin"};
        int[] rivit = {0};
        int i = 0;
        for (String sana : sanat){
            rivit[0] = i;
            puu.lisääSana(sana, rivit);
            i++;
        }
    }
}
