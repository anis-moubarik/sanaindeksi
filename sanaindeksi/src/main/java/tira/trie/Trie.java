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
        juuri = new TrieSolmu('\0', false, 0);
    }
    
    /**
     * Lisätään sana, jos solmulla ei ole lapsia, tehdään sille dynaaminen taulu 
     * jonne lapset lisätään. Jos solmulta löytyy kyseisen kirjaimen lapsi alustetaan
     * solmu muuttuja lapsella.
     * @param sana
     */
    public void lisääSana(String sana, int rivi){
        sana = sana.replaceAll("[!=;,?:.)]", "");
        sana = sana.toLowerCase();
        int l = sana.length(), i = 0;
        char[] kirjaimet = sana.toCharArray();
        TrieSolmu solmu = juuri;
        for(i = 0; i < l; i++){
            if (solmu.lapset.etsi(kirjaimet[i]) == null)
                solmu.lapset.lisää(new TrieSolmu(kirjaimet[i], i  == l-1 ? true : false, rivi));
            solmu = solmu.lapset.etsi(kirjaimet[i]);
        }
        solmu.setOnkoSana(true);
    }
    
    public boolean etsiSana(String sana){
        sana = sana.toLowerCase();
        char[] kirjaimet = sana.toCharArray();
        int l = kirjaimet.length;
        TrieSolmu solmu = juuri;
        
        int i;
        for(i = 0; i < l; i++){
            if(solmu == null)
                return false;
            solmu = solmu.lapset.etsi(kirjaimet[i]);
        }
        
        if (i == l && solmu == null)
            return false;
        
        if (solmu != null && !solmu.onkoSana)
            return false;
        
        return true;
    }
    
}