package tira.trie;



/**
 * 
 * @author Anis
 */
public class Trie{
    
    private TrieSolmu juuri;
    
    /**
     * 
     */
    public Trie(){
        juuri = new TrieSolmu('\0', false, null);
    }
    
    /**
     * Lisätään sana, jos solmulla ei ole lapsia, tehdään sille dynaaminen taulu 
     * jonne lapset lisätään. Jos solmulta löytyy kyseisen kirjaimen lapsi alustetaan
     * solmu muuttuja lapsella.
     * @param sana
     */
    public void lisääSana(String sana, int[] rivit){
        int l = sana.length();
        char[] kirjaimet = sana.toCharArray();
        TrieSolmu solmu = juuri;
        for(int i = 0; i < l; i++){
            rivit[0] = i;
            if (solmu.lapset.etsi(kirjaimet[i]) == null)
                solmu.lapset.lisää(new TrieSolmu(kirjaimet[i], i  == l-1 ? true : false, rivit));
            solmu = solmu.lapset.etsi(kirjaimet[i]);
        }
    }
    
}