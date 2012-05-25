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
    
    public void lisääSanat(String[] sanat){
        int riviNumero = 1;
        for(String rivi : sanat){
           String[] riviSanat = rivi.split(" ");
           for(String sana : riviSanat){
               lisääSana(sana, riviNumero);
           }
           riviNumero++;
       }
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
        solmu.setOnkoSana(true); //Varmistetaan, että Yhdyssanojen ja pitkien sanojen alisanat tunnistetaan myös sanoiksi
        solmu.lisääRivi(rivi);
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
    
    public TrieSolmu etsiSolmu(String sana){
        sana = sana.toLowerCase();
        char[] kirjaimet = sana.toCharArray();
        int l = kirjaimet.length;
        TrieSolmu solmu = juuri;
        
        int i;
        for(i = 0; i < l; i++){
            if(solmu == null)
                return null;
            solmu = solmu.lapset.etsi(kirjaimet[i]);
        }
        
        if (i == l && solmu == null)
            return null;
        
        if (solmu != null && !solmu.onkoSana)
            return null;
        
        return solmu;
    }
    
}