package tira.trie;

import java.util.HashMap;
import java.util.TreeMap;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInterface;
import tira.dynaaminentaulu.DynaaminenTauluString;

/**
 * 
 * @author Anis
 */
public class TrieSolmu{
    
    private char kirjain;
    /**
     * DynaaminenTaulu joka sisältää solmun lapset
     */
    public DynaaminenTauluInterface<TrieSolmu> lapset;
    /**
     * Kertoo onko solmuun asti kuljettu reitti kokonainen sana.
     */
    public boolean onkoSana;
    /**
     * key,value Puu jossa on rivi ja tekstit järjestyksessä.
     */
    private HashMap<String, DynaaminenTauluInterface<Integer>> tiedostoJaRivinumerot;

    
    public void lisääTiedostoJaRivinumero(String s, int i){
        DynaaminenTauluInterface e = tiedostoJaRivinumerot.get(s);
        if(e == null)
            e = new DynaaminenTauluString();
        e.lisää(e);
        tiedostoJaRivinumerot.put(s, e);
    }
    
    public HashMap getTiedostoJaRivinumerot(){
        return tiedostoJaRivinumerot;
    }
    
    /**
     * 
     * @param kirjain
     * @param onkoSana
     * @param rivi
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
    
}