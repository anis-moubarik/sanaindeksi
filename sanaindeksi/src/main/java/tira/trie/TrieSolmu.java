package tira.trie;

import java.util.LinkedList;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 * 
 * @author moubarik
 */
public class TrieSolmu{
    
    char kirjain;
    DynaaminenTauluInterface lapset;
    boolean onkoSana;
    LinkedList<Integer> rivit = new LinkedList<Integer>();
    
    /**
     * 
     * @param kirjain
     * @param onkoSana
     * @param rivi
     */
    public TrieSolmu(char kirjain, boolean onkoSana, int rivi){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        rivit.add(rivi);
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
     * Palautetaan linkitetty lista johon on talletettu rivit joilla sana esiintyy tiedostossa.
     * @return LinkedList
     */
    public LinkedList getRivit() {
        return rivit;
    }

    /**
     * Asetetaan rivit solmulle.
     * @param rivit
     */
    public void setRivit(LinkedList rivit) {
        this.rivit = rivit;
    }
    
    /**
     * Lisätään yksittäinen rivi solmulle.
     * @param rivi
     */
    public void lisääRivi(int rivi){
        rivit.add(rivi);
    }
    
}