package tira.trie;

import java.util.HashMap;



/**
 * 
 * @author Anis
 */
public class Trie{
    
    private TrieSolmu juuri;

    //Täällä säilötään tiedostonnimi ja teksti.
    private HashMap<String, String[]> tiedostoJaRivit;

    
    /**
     * 
     */
    public Trie(){
        juuri = new TrieSolmu('\0', false);
        tiedostoJaRivit = new HashMap<String, String[]>();
    }
    
    
    /**
     * Palautetaan HashMappina tiedostotJaRivit.
     * @return tiedostotJaRivit
     */
    public HashMap<String, String[]> getTiedostoJaRivit() {
        return tiedostoJaRivit;
    }

    
    /**
     * Asetetaan parametrina saatu HashMap uudeksi tiedostotJaRivit muuttujaksi.
     * @param tiedostoJaRivit 
     */
    public void setTiedostoJaRivit(HashMap<String, String[]> tiedostoJaRivit) {
        this.tiedostoJaRivit = tiedostoJaRivit;
    }
    
    /**
     * Lisätään String taulukosta kaikki sanat puuhun.
     * @param tiedosto 
     * @param sanat
     */
    public void lisääSanat(String tiedosto, String[] sanat){
        int riviNumero = 1;
        tiedostoJaRivit.put(tiedosto, sanat);
        for(String rivi : sanat){
           String[] riviSanat = rivi.split(" ");
           for(String sana : riviSanat){
               lisääSana(tiedosto, sana, riviNumero, rivi);
           }
           riviNumero++;
       }
    }
    
    /**
     * Lisätään sana, jos solmulla ei ole lapsia, tehdään sille dynaaminen taulu 
     * jonne lapset lisätään. Jos solmulta löytyy kyseisen kirjaimen lapsi alustetaan
     * solmu muuttuja lapsella.
     * @param tiedosto 
     * @param sana
     * @param rivi
     * @param riviTeksti  
     */
    public void lisääSana(String tiedosto, String sana, int rivi, String riviTeksti){
        sana = sana.replaceAll("[!=;,?:.)]", "");
        sana = sana.toLowerCase();
        int l = sana.length(), i = 0;
        char[] kirjaimet = sana.toCharArray();
        TrieSolmu solmu = juuri;
        for(i = 0; i < l; i++){
            if (solmu.getLapset().etsi(kirjaimet[i]) == null){
                TrieSolmu lisättäväSolmu = new TrieSolmu(kirjaimet[i], i == l-1 ? true : false);
                lisättäväSolmu.lisääTiedostoJaRivinumero(tiedosto, rivi);
                solmu.getLapset().lisää(lisättäväSolmu);
            }
            solmu = (TrieSolmu) solmu.getLapset().etsi(kirjaimet[i]);
        }
        solmu.setOnkoSana(true); //Varmistetaan, että Yhdyssanojen ja pitkien sanojen alisanat tunnistetaan myös sanoiksi
        solmu.lisääTiedostoJaRivinumero(tiedosto, rivi);
    }
    
    /**
     * Etsitään puusta parametrina annettu sana.
     * @param sana
     * @return
     */
    public boolean etsiSana(String sana){
        sana = sana.toLowerCase();
        char[] kirjaimet = sana.toCharArray();
        int l = kirjaimet.length;
        TrieSolmu solmu = juuri;
        
        int i;
        //Etsitään solmujen lapsi taulukoista sanan kirjaimia
        for(i = 0; i < l; i++){
            if(solmu == null)
                return false;
            solmu = (TrieSolmu) solmu.getLapset().etsi(kirjaimet[i]);
        }
        
        //Jos kaikki lapset on käyty läpi ja sanaa ei vielä olla löydetty palautetaan false
        if (i == l && solmu == null)
            return false;
        
        //Jos solmu on löydetty, mutta ei ole sana palautetaan false
        if (solmu != null && !solmu.onkoSana)
            return false;
        
        return true;
    }
    
    /**
     * Etsitään sanalla TrieSolmua ja palautetaan se.
     * Toimii samaan tapaan etsiSanan kanssa.
     * @param sana
     * @return
     */
    public TrieSolmu etsiSolmu(String sana){
        sana = sana.toLowerCase();
        char[] kirjaimet = sana.toCharArray();
        int l = kirjaimet.length;
        TrieSolmu solmu = juuri;
        
        int i;
        for(i = 0; i < l; i++){
            if(solmu == null)
                return null;
            solmu = (TrieSolmu) solmu.getLapset().etsi(kirjaimet[i]);
        }
        
        if (i == l && solmu == null)
            return null;
        
        if (solmu != null && !solmu.onkoSana)
            return null;
        
        return solmu;
    }
    
}