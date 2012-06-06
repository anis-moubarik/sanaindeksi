package tira.trie;

import java.util.HashMap;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 * 
 * @author Anis
 */
public class TrieSolmu{
    
    private char kirjain;
    /**
     * DynaaminenTaulu joka sisältää solmun lapset
     */
    private DynaaminenTauluInterface<TrieSolmu> lapset;

    /**
     * Kertoo onko solmuun asti kuljettu reitti kokonainen sana.
     */
    public boolean onkoSana;
    /**
     * HashMap jossa on rivi ja tekstit järjestyksessä.
     */
    private HashMap<String, DynaaminenTauluInterface<Integer>> tiedostoJaRivinumerot;

    
    /**
     * Lisätään taulukkoon tiedosto ja rivinnumero mistä rivin löytää.
     * @param s
     * @param i
     */
    public void lisääTiedostoJaRivinumero(String s, int i){
        DynaaminenTauluInterface e = tiedostoJaRivinumerot.get(s);
        if(e == null)
            e = new DynaaminenTauluInt();
        e.lisää(i);
        tiedostoJaRivinumerot.put(s, e);
    }
    
    
    /**
     * 
     * @param kirjain
     * @param onkoSana
     */
    public TrieSolmu(char kirjain, boolean onkoSana){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        this.tiedostoJaRivinumerot = new HashMap<String, DynaaminenTauluInterface<Integer>>();
    }

    /**
     * Palautetaan solmun kirjain.
     * @return char
     */
    public char getKirjain() {
        return kirjain;
    }

    /**
     * Asetetaan solmun kirjain
     * @param kirjain
     */
    public void setKirjain(char kirjain) {
        this.kirjain = kirjain;
    }

    /**
     * Palauttaa dynaamisessa taulussa olevat solmun lapset.
     * @return
     */
    public DynaaminenTauluInterface getLapset() {
        return lapset;
    }

    /**
     * Asetetaan solmun lapset.
     * @param lapset
     */
    public void setLapset(DynaaminenTauluInterface lapset) {
        this.lapset = lapset;
    }

    /**
     * Palauttaa true, jos solmu on merkitty sanaksi.
     * @return boolean
     */
    public boolean isOnkoSana() {
        return onkoSana;
    }

    /**
     * Asetetaan kirjaimen sana totuusarvo.
     * @param onkoSana
     */
    public void setOnkoSana(boolean onkoSana) {
        this.onkoSana = onkoSana;
    }
    
    /**
     * Palautetaan tiedostoJaRivinumerot HashMap.
     * @return
     */
    public HashMap<String, DynaaminenTauluInterface<Integer>> getTiedostoJaRivinumerot() {
        return tiedostoJaRivinumerot;
    }

    /**
     * Asetetaan parametrina saatu HashMap uudeksi tiedostoJaRivinumerot muuttujaksi.
     * @param tiedostoJaRivinumerot
     */
    public void setTiedostoJaRivinumerot(HashMap<String, DynaaminenTauluInterface<Integer>> tiedostoJaRivinumerot) {
        this.tiedostoJaRivinumerot = tiedostoJaRivinumerot;
    }
    
}