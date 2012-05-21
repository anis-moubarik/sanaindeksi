
package tira.trie;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tira.fileIO.TiedostonLuku;


public class TrieTest {
    
    
    //Alustavat testi vielä toistaiseksi mainissa.
    Trie puu;
    TiedostonLuku tl;
    SanaPuhdistaja sp;
    
    @Before
    public void setUp(){
        puu = new Trie();
        tl = new TiedostonLuku();
        sp = new SanaPuhdistaja();
    }
    
    
    //Ei vielä tee mitään, ennen kuin etsimis operaatio toteutetaan Trielle.
    @Test
    public void lisäysTrieen(){
        String[] sanat = {"sana", "ananas", "kana", "puhelin", "sanoma", "puuhamaa", "kirjasto"};
        int i = 0;
        long lisäysStart = System.currentTimeMillis();
        for (String sana : sanat){
            puu.lisääSana(sana, i);
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
    public void isoLisäysTrieen() throws IOException{
        String[] kalevala = tl.lueRivitTaulukkoon("kalevala.txt");
        int riviNumero = 0;
        
        long lisäysStart = System.currentTimeMillis();
        for(String rivi : kalevala){
            String[] sanat = rivi.split(" ");
            for(String sana : sanat){
                sana = sp.puhidstaSana(sana);
                puu.lisääSana(sana, riviNumero);
            }
            riviNumero++;
        }
        long lisäysEnd = System.currentTimeMillis();
        
        String[] etsittävätSanat = {"Väinämöinen", "runo", "Veli", "Sampo", "Louhi", "Ilmarinen",
                                    "Kullervo", "leipä"};
        long start = System.currentTimeMillis();
        for(String sana : etsittävätSanat){
            boolean tulos = puu.etsiSana(sana);
            System.out.println(sana);
            assertEquals(true, tulos);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("-------------------isoLisäysTrieen testi-----------------");
        System.out.println("Aikaa meni etsimiseen: "+(end-start)+" millisekuntia.");
        System.out.println("Start: "+start);
        System.out.println("End: "+end);
        System.out.println("Aikaa meni tallentamiseen: "+(lisäysEnd - lisäysStart)+" millisekuntia");
        System.out.println("Start: "+lisäysStart);
        System.out.println("End: "+lisäysEnd);
        System.out.println("-------------------------------------------------------");
        
        
    }
    
}
