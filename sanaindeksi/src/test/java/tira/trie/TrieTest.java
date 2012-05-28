
package tira.trie;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tira.fileIO.TiedostonLuku;


public class TrieTest {
    
    
    //Alustavat testi vielä toistaiseksi mainissa.
    Trie puu;
    TiedostonLuku tl;
    
    @Before
    public void setUp(){
        puu = new Trie();
        tl = new TiedostonLuku();
    }
    
    @Test
    public void aliSanat(){
        String[] sanat = {"Runoilija", "Runo", "Jalkapallo", "Jalka", "pallo"};
        int riviNumero = 0;
        Trie tr = new Trie();
        
        for(String sana : sanat){
            tr.lisääSana(sana, riviNumero);
            riviNumero++;
        }
        
        boolean tulos = tr.etsiSana("runo");
        assertEquals(true, tulos);
        tulos = tr.etsiSana("jalka");
        assertEquals(true, tulos);
        tulos = tr.etsiSana("Pallo");
        assertEquals(true, tulos);
    }
    
    
    @Test
    public void lisäysTrieen(){
        String[] sanat = {"sana,", "väinämöinen!"};
        int i = 0;
        long lisäysStart = System.currentTimeMillis();
        for (String sana : sanat){
            puu.lisääSana(sana, i);
            i++;
        }
        long lisäysEnd = System.currentTimeMillis();
        
        long start = System.currentTimeMillis();
        for (String sana : sanat){
            sana = sana.replaceAll("[!=;,)]", "");
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
        System.out.println("-------------------------------------------------------\n\n");
    }
    
    @Test
    public void isoLisäysTrieen() throws IOException{
        String[] kalevala = tl.lueRivitTaulukkoon("kalevala.txt");
        int riviNumero = 1;
        
        long lisäysStart = System.currentTimeMillis();
        for(String rivi : kalevala){
            String[] sanat = rivi.split(" ");
            for(String sana : sanat){
                puu.lisääSana(sana, riviNumero);
            }
            riviNumero++;
        }
        long lisäysEnd = System.currentTimeMillis();
        
        String[] etsittävätSanat = {"Väinämöinen", "runoa", "Veli", "Sampo", "Louhi", "Ilmarinen",
                                    "Kullervon", "leipä"};
        long start = System.currentTimeMillis();
        for(String sana : etsittävätSanat){
            boolean tulos = puu.etsiSana(sana);
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
    
    @Test
    public void riviTesti() throws IOException{
        String[] kalevala = tl.lueRivitTaulukkoon("kalevala.txt");
        int riviNumero = 1;
        LinkedList<Integer> kaikkiRivit = new LinkedList<Integer>();
        
        for(String rivi : kalevala){
            String[] sanat = rivi.split(" ");
            for(String sana : sanat){
                puu.lisääSana(sana, riviNumero);
            }
            riviNumero++;
        }
        TrieSolmu s = puu.etsiSolmu("Kullervo");
        
        for(int rivi : s.rivit){
            kaikkiRivit.add(rivi);
        }
        for(int i = 0; i < s.lapset.size(); i++){
            for (int j = 0; j < s.lapset.hae(i).rivit.size(); j++) {
               kaikkiRivit.add(s.lapset.hae(i).rivit.get(j)); 
            }
        }
        
        Collections.sort(kaikkiRivit);
        
        System.out.print("\n\nRivi testi: Kullervo rivit:");
        int i = 0;
        for(int rivi : kaikkiRivit){
            if((i%5) == 0) System.out.println("");
            System.out.print(rivi+", ");
            i++;
        }
        
        
        
        //Ensimmäinen
        assertEquals(15234, (int)s.rivit.get(0));
    }
    
}
